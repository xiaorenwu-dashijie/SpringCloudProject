package com.sinoway.cisp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.sinoway.cisp.dao.BlacklistMapper;
import com.sinoway.cisp.entitys.BlackListVo;
import com.sinoway.cisp.entitys.Blacklist;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.BlackListReportService;
import com.sinoway.cisp.service.CispBasicDataApiService;
import com.sinoway.cisp.service.MddCityDicService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SearchService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.IDUtil;
import com.sinoway.cisp.utils.PhoneNumberUtil;
import com.sinoway.cisp.utils.StringUtil;

@Service(value = "blackService")
@Transactional
public class BlackListServiceImpl implements CispBasicDataApiService {

	private final static Logger LOGGER = LoggerFactory.getLogger(BlackListServiceImpl.class);

	@Autowired
	private BlacklistMapper blackListMapper;

	@Autowired
	private SearchService searchService;
	@Autowired
	private BlackListReportService blackListReportService;
	@Autowired
	private ResponseJsonService responseJsonService;
	@Autowired
	private MddCityDicService mddCityDicService;

	public String pushCreditData(User user, String datatype, String version, String sinoCardid, String data)
			throws Exception {
		String result = null;
		Blacklist blackList = new Blacklist();
		blackList.setSinoid(IDUtil.getSinoId(user.getInstiCode(), "D"));// D
		blackList.setSinoCardid(sinoCardid);
		// 解析json
		try {
			JSONObject json = new JSONObject(data);
			JSONObject loanInfo = json.getJSONObject("loan_info");
			String phone = loanInfo.getString("phone");
			boolean validatePhone = PhoneNumberUtil.isMobile(phone);
			if (!validatePhone) {
				LOGGER.error("手机号校验错误:{}", phone);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}

			// 贷款开始日期格式校验(若为null则校验失败)
			String loanStartTime = loanInfo.getString("loan_start_time");
			boolean convertSuccess = DateUtils.isValidDate(loanStartTime);
			if (!convertSuccess) {
				LOGGER.error("贷款开始日期格式错误或者为空:{}", loanStartTime);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}

			JSONObject overdueInfo = json.getJSONObject("overdue_info");

			String overdueStartTime = overdueInfo.getString("overdue_start_time");
			boolean convertSuccess1 = DateUtils.isValidDate(overdueStartTime);
			if (!convertSuccess1) {
				LOGGER.error("逾期开始日期格式错误或者为空:{}", overdueStartTime);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}
			String overMoney = overdueInfo.getString("overdue_money");
			if (StringUtils.isBlank(overMoney)) {
				LOGGER.error("逾期金额为空:{}", overMoney);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			} else {
				BigDecimal overdueMoney = new BigDecimal(overMoney);
				blackList.setOverdueMoney(overdueMoney);
			}
			Date overdueStartT = DateUtils.parseDate(overdueStartTime);
			blackList.setOverdueStartTime(overdueStartT);
			String payLocation = loanInfo.getString("pay_location");
			if (StringUtils.isBlank(payLocation)) {
				blackList.setLoanLocation("9999");
			} else {
				boolean isCity = mddCityDicService.checkCityCode(payLocation);
				if (isCity) {
					blackList.setLoanLocation(payLocation);
				} else {
					LOGGER.error("地址{}不在字典表中", payLocation);
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
			}
			String bornLocation = loanInfo.getString("born_location");
			if (StringUtils.isBlank(bornLocation)) {
				blackList.setPersonalAddress("9999");
			} else {
				boolean isCity = mddCityDicService.checkCityCode(bornLocation);
				if (isCity) {
					blackList.setPersonalAddress(bornLocation);
				} else {
					LOGGER.error("地址{}不在字典表中", bornLocation);
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
			}
			String liveLocation = loanInfo.getString("live_location");
			if (StringUtils.isBlank(liveLocation)) {
				blackList.setLiveAddress("9999");
			} else {
				boolean isCity = mddCityDicService.checkCityCode(liveLocation);
				if (isCity) {
					blackList.setLiveAddress(liveLocation);
				} else {
					LOGGER.error("地址{}不在字典表中", liveLocation);
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
			}
			blackList.setLoanType(loanInfo.getString("loan_type"));
			blackList.setLoanGuarantee(loanInfo.getString("loan_guarantee"));
			String loanStart = (String) loanInfo.get("loan_start_time");
			Date a = StringUtil.stringToDate(loanStart, "yyyy-MM-dd");
			blackList.setLoanStartTime(a);
			blackList.setPhone(loanInfo.getString("phone"));
			blackList.setEmail(loanInfo.getString("email"));
			blackList.setOverdueTimes(overdueInfo.getString("overdue_times"));
			blackList.setIshide("0");// 默认不隐藏
			String overDuration = overdueInfo.getString("overdue_longest_duration");
			blackList.setOverdueDuration(overDuration);
			String overdueReason = overdueInfo.getString("overdue_reason");
			if (StringUtils.isBlank(overdueReason)) {
				LOGGER.error("逾期原因为空:{}", overdueReason);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			} else {
				blackList.setReason(overdueReason);
				if ("2".equals(overdueReason) || "3".equals(overdueReason) || "9".equals(overdueReason)) {// 2、恶意拖欠；3、身份欺诈
					if ("9".equals(overdueReason)) {
						if (!"4".equals(overDuration)) { // 逾期时长大于90天
							LOGGER.error("逾期时长小于90天:{}", overDuration);
							return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
						}
					}
				} else {
					LOGGER.error("逾期原因不是2恶意拖欠、3身份欺诈、9其他:{}", overdueReason);
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
			}
			blackList.setOverdueStatus(overdueInfo.getString("overdue_status"));
			blackList.setUserAccount(user.getUserAccount());
			blackList.setPublicTime(new Date());
			blackListMapper.insert(blackList);

			result = responseJsonService.creaRespJson(true, null, null, null, null, null);
		} catch (Exception e) {
			result = responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		return result;
	}

	public String getCreditData(User user, String datatype, String version, String sinoCardid, String qreason)
			throws Exception {
		String result = null;
		String reportId = IDUtil.getSinoId(user.getInstiCode(), "D");
		searchService.insSearchReport(reportId, user, reportId, qreason, new Date(), sinoCardid, new Date());
		List<BlackListVo> bLackListVos = blackListReportService.getBlackListReport(sinoCardid, user);
		Gson gson = new Gson();
		String report = gson.toJson(bLackListVos);
		result = responseJsonService.creaRespJson(true, null, report, null, "black", reportId);
		return result;
	}
}
