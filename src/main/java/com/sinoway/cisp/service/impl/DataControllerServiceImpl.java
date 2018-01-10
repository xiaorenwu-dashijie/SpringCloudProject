package com.sinoway.cisp.service.impl;

import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.sinoway.cisp.dao.RoleAuthMapper;
import com.sinoway.cisp.dao.SinoBodyMapper;
import com.sinoway.cisp.entitys.MonitorStock;
import com.sinoway.cisp.entitys.QueryPHPro;
import com.sinoway.cisp.entitys.SinoBody;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.DataControllerService;
import com.sinoway.cisp.utils.InvoInclFinaAPIUtil;
import com.sinoway.cisp.utils.Parameters;
import com.sinoway.cisp.utils.PhoneNumberUtil;

@Service
@Transactional
public class DataControllerServiceImpl implements DataControllerService {

	private final static Logger LOGGER = LoggerFactory.getLogger(DataControllerServiceImpl.class);

	@Autowired
	private SinoBodyMapper sinoBodyMapper;
	@Autowired
	private RoleAuthMapper roleAuthMapper;

	@Override
	public String getInFinReport(User user, String sinoCardid, String cellPhoneNum) {
		String validateAuthForCISPCredit = validateAuthForCISPCredit(cellPhoneNum, user);
		if (!StringUtils.isEmpty(validateAuthForCISPCredit)) {
			return validateAuthForCISPCredit;
		}
		try {
			String token = "Nm0q7qdD58JBsNa";
			Gson gson = new Gson();
			SinoBody sinoBody = sinoBodyMapper.selectByPrimaryKey(sinoCardid);
			long currentTimeMillis = System.currentTimeMillis();
			String inclusive_finance_report = InvoInclFinaAPIUtil.connectInclFinaAPI(Parameters.credit_inc_url,
					user.getUserAccount(), user.getUserPsw(), "1", sinoBody.getName(), sinoBody.getCardid(),
					cellPhoneNum, "1", token);
			LOGGER.info("调用贷前审核耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			if (StringUtils.isNotBlank(inclusive_finance_report)) {
				JSONObject inclusiveObject = new JSONObject(inclusive_finance_report);
				String code = inclusiveObject.getString("CODE");
				if ("200".equals(code)) {
					LOGGER.info("机构调用贷前审核报告成功");
					QueryPHPro queryPHPro = gson.fromJson(inclusive_finance_report, QueryPHPro.class);
					if ("0,0,999,0,0,0,999".equals(queryPHPro.toValidateRecordString())) { // 无记录
						return "{\"code\":\"200\",\"iscreditrecord\":\"0\"}";
					} else { // 有记录
						return queryPHPro.toJsonString().toLowerCase();
					}
				} else {
					LOGGER.warn("调用贷前审核错误代码：{},原因：{}", code, inclusiveObject.getString("MESSAGE"));
				}
			} else {
				LOGGER.warn("访问失败,有可能接口停用");
			}
		} catch (JSONException e) {
			LOGGER.warn("解析贷前审核报告json出现异常{}", e);
		} catch (SocketTimeoutException e) {
			LOGGER.warn("调用贷前审核报告出现超时异常(连接主机超时/从主机读取数据超时){}", e.getMessage());
		} catch (Exception e) {
			LOGGER.warn("调用贷前审核报告出现异常{}", e);
		}
		return "{\"code\":\"1020\"}";
	}

	@Override
	public String getPostLoanReport(User user, String sinoCardid, String cellPhoneNum) {
		String validateAuthForCISPCredit = validateAuthForCISPCredit(cellPhoneNum, user);
		if (!StringUtils.isEmpty(validateAuthForCISPCredit)) {
			return validateAuthForCISPCredit;
		}
		try {
			String token = "Nm0q7qdD58JBsNa";
			Gson gson = new Gson();
			SinoBody sinoBody = sinoBodyMapper.selectByPrimaryKey(sinoCardid);
			long currentTimeMillis = System.currentTimeMillis();
			String postLoanMonitorData = InvoInclFinaAPIUtil.connectInclFinaAPI(Parameters.credti_monitor_url,
					user.getUserAccount(), user.getUserPsw(), null, sinoBody.getName(), sinoBody.getCardid(),
					cellPhoneNum, null, token);
			LOGGER.info("调用存量预警耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");

			if (StringUtils.isNotBlank(postLoanMonitorData)) {
				JSONObject inclusiveObject = new JSONObject(postLoanMonitorData);
				String code = inclusiveObject.getString("CODE");
				if ("200".equals(code)) {
					MonitorStock monitorStock = gson.fromJson(postLoanMonitorData, MonitorStock.class);
					if ("无记录".equals(monitorStock.getISCREDITRECORD())) {
						monitorStock.setISCREDITRECORD("0");
					} else {
						monitorStock.setISCREDITRECORD("1");
					}
					LOGGER.info("机构调用存量预警报告成功");
					return gson.toJson(monitorStock).toLowerCase();
				} else {
					LOGGER.warn("调用存量预警报告错误代码：{},原因：{}", code, inclusiveObject.getString("MESSAGE"));
				}
			} else {
				LOGGER.warn("访问失败,有可能接口停用");
			}
		} catch (JSONException e) {
			LOGGER.warn("解析存量预警报告json出现异常{}", e);
		} catch (SocketTimeoutException e) {
			LOGGER.warn("调用贷前审核报告出现超时异常(连接主机超时/从主机读取数据超时){}", e.getMessage());
		} catch (Exception e) {
			LOGGER.warn("调用贷前审核报告出现异常{}", e);
		}
		return "{\"code\":\"1020\"}";
	}

	/**
	 * 检测手机号格式和用户权限
	 * 
	 * @param cellPhoneNum
	 * @param user
	 * @return
	 */
	private String validateAuthForCISPCredit(String cellPhoneNum, User user) {
		boolean validatePhone = PhoneNumberUtil.isMobile(cellPhoneNum);
		if (!validatePhone) {
			LOGGER.warn("调用大数据风控报告错误码:{},手机号校验错误:{}", "1019", cellPhoneNum);
			return "{\"code\":\"1019\"}";
		}
		String funCodeFormat = user.getFunCodeFormat();
		if (StringUtils.isBlank(funCodeFormat)) {
			LOGGER.warn("用户没有赋予角色");
			return "{\"code\":\"1002\"}";
		}

		String[] split = funCodeFormat.split("/");
		Set<String> authSet = new HashSet<>();
		for (String roleCode : split) {
			if (roleCode.contains("B001")) {// 说明可以用cisp服务
				List<String> authList = roleAuthMapper.findAuthListByRoleCode(roleCode);
				for (String string : authList) {
					authSet.add(string);
				}
			}
		}
		if (!authSet.contains(Parameters.CISPCreditReport)) {
			LOGGER.warn("角色为{}的用户,未开通捆绑大数据风控报告权限m_6", user.getFunCodeFormat());
			return "{\"code\":\"1002\"}";
		}
		return null;
	}

}
