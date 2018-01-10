package com.sinoway.cisp.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.RoleAuthMapper;
import com.sinoway.cisp.dao.SinoBodyMapper;
import com.sinoway.cisp.entitys.SinoBody;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CheckSignService;
import com.sinoway.cisp.service.UserService;
import com.sinoway.cisp.utils.IDUtil;
import com.sinoway.cisp.utils.IdcardValidatorUtil;
import com.sinoway.cisp.utils.MD5;
import com.sinoway.cisp.utils.Parameters;

@Service
@Transactional
public class CheckSignServiceImpl implements CheckSignService {

	private final static Logger LOGGER = LoggerFactory.getLogger(CheckSignServiceImpl.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RoleAuthMapper roleAuthMapper;
	@Autowired
	private SinoBodyMapper sinoBodyMapper;

	public String check(String key, String sign, String cmd, String isgetreport, String version, String name,
			String cardid, String cridOrPhone) {
		// version = "V2.1";
		String errorCode = null;
		Date date = new Date();

		boolean validatedAllIdcard = IdcardValidatorUtil.isValidatedAllIdcard(cardid);
		if (!validatedAllIdcard) {
			LOGGER.error(key + " 身份证格式错误:{}", cardid);
			return "1003";// 身份证格式错误
		}
		SinoBody sinoBody = sinoBodyMapper.findSinobodyByCardid(name, cardid);
		if (sinoBody == null) {
			String sinoCardid = IDUtil.getSinowayCardid();
			SinoBody sinoBody2 = new SinoBody();
			sinoBody2.setName(name);
			sinoBody2.setCardid(cardid);
			sinoBody2.setSinoCardid(sinoCardid);
			sinoBody2.setSinotime(date);
			sinoBodyMapper.insert(sinoBody2);
		}
		User user = userService.selectUserByKey(key);
		if (null == user) {
			LOGGER.error(key + "--非法的授权信息,通过公钥找不到该用户");
			errorCode = "1002";
		} else {
			MDC.put("userAccount", user.getUserAccount());
			boolean flag = false;
			String funCodeFormat = user.getFunCodeFormat();
			if (StringUtils.isNotBlank(funCodeFormat)) {
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
				if (authSet.contains(Parameters.CISPApi)) {
					flag = true;
				}
				if (!flag) {
					LOGGER.error("该用户没有使用CISPapi的权限");
					errorCode = "1002";
				} else {
					if (!"3".equals(user.getFreezeStatus())) {
						String userPrivate = user.getUserPrivate();
						if (!StringUtils.isBlank(userPrivate)) {
							String content = null;
							if ("blacklist".equals(cmd)) {
								content = key + cmd + version + name + cardid + userPrivate;
							} else if ("personreport".equals(cmd)) {
								if (!authSet.contains(Parameters.PersonCreditReport)) {
									LOGGER.error("该用户没有使用个人信用报告的权限");
									return "1002";
								}
								content = key + cmd + isgetreport + version + name + cardid + cridOrPhone + userPrivate;
							} else {
								content = key + cmd + isgetreport + version + name + cardid + cridOrPhone + userPrivate;
							}
							boolean flag2 = false;
							try {
								flag2 = MD5.process(content).equalsIgnoreCase(sign.toLowerCase());
							} catch (Exception e) {
								e.printStackTrace();
								flag2 = false;
							}
							flag2 = true;//TODO
							if (!flag2) {
								LOGGER.error("用户认证失败,MD5拼接有误");
								errorCode = "1001";
							}
						} else {
							LOGGER.error("公钥为{}的用户，私钥未分配", key);
							errorCode = "1006";
						}
					} else {
						LOGGER.error("用户已冻结");
						errorCode = "1018";
					}
				}
			} else {
				LOGGER.error("该用户没有赋予角色");
				errorCode = "1002";
			}

		}
		return errorCode;
	}
}
