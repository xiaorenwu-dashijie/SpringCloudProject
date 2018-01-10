package com.sinoway.cisp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.LoanApplicationMapper;
import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CispBasicApiService;
import com.sinoway.cisp.service.DataControllerService;
import com.sinoway.cisp.service.MddCityDicService;
import com.sinoway.cisp.service.ReportService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SearchService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.IDUtil;

@Component(value = "loanService")
@Transactional
public class LoanServiceImpl implements CispBasicApiService {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoanServiceImpl.class);

	@Autowired
	private LoanApplicationMapper loanApplicationMapper;
	@Autowired
	private IdMapperMapper idMapperMapper;

	@Autowired
	private SearchService searchService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private ResponseJsonService responseJsonService;
	@Autowired
	private DataControllerService dataControllerService;
	@Autowired
	private MddCityDicService mddCityDicService;

	public String pushLoanInfo(User user, String cmd, String isgetreport, String version, String reportId,
			String sinoCardid, String crid, String data) throws Exception {
		Date date = new Date();

		JSONObject jsonObject = new JSONObject(data);
		JSONObject basicJsonObject = jsonObject.getJSONObject("basic_info");
		JSONObject loanJsonObject = jsonObject.getJSONObject("loan_info");

		String cellPhoneNum = basicJsonObject.getString("cell_phone_num");
		// 校验金额
		String request_money = loanJsonObject.getString("request_money");
		if (StringUtils.isEmpty(request_money)) {
			LOGGER.error("申请金额为空");
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$"); // 判断小数点后2位的数字的正则表达式
		Matcher match = pattern.matcher(request_money);
		if (match.matches() == false) {
			LOGGER.error("金额格式错误:{}", request_money);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		} else {
			Double valueOf = Double.valueOf(request_money);
			if (valueOf <= 0) {
				LOGGER.error("金额小于等于0:{}", request_money);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}
		}
		// 校验申请日期
		String request_time_str = loanJsonObject.getString("request_time");
		if (StringUtils.isEmpty(request_time_str)) {
			LOGGER.error("申请日期为空");
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		Date request_time = DateUtils.parseDate(request_time_str);
		Date sixMonthAgo = DateUtils.getSixMonthAgo(date);
		if (request_time.getTime() < sixMonthAgo.getTime() || request_time.getTime() > date.getTime()) {
			LOGGER.error("申请日期不在六个月之内:{}", request_time_str);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}

		String sinoid = idMapperMapper.findSinoidByInstiid(crid, user.getUserAccount());
		if (StringUtils.isNotBlank(sinoid)) {
			LOGGER.error("申请编号{}在该机构重复", crid);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		sinoid = IDUtil.getSinoId(user.getInstiCode(), "S");
		IdMapper idMapper = new IdMapper();
		idMapper.setSinoid(sinoid);
		idMapper.setInstiCode(user.getInstiCode());
		idMapper.setInstiid(crid);
		idMapper.setSinoCardid(sinoCardid);
		idMapper.setCellPhoneNum(cellPhoneNum);
		idMapper.setUserAccount(user.getUserAccount());
		idMapper.setDataFrom("2");// 来源于接口
		idMapper.setCrStatus("15");// 待审批
		idMapper.setSinotime(date);
		LoanApplication loanApplication = new LoanApplication();
		loanApplication.setSinoid(sinoid);
		loanApplication.setSinoCardid(sinoCardid);
		loanApplication.setRequestResult("0");// 待审批
		loanApplication.setCellPhoneNum(cellPhoneNum);
		loanApplication.setEdu(basicJsonObject.getString("edu"));
		String requestLocation = loanJsonObject.getString("request_location");
		if (StringUtils.isBlank(requestLocation)) {
			loanApplication.setRequestLocation("9999");
		} else {
			boolean isCity = mddCityDicService.checkCityCode(requestLocation);
			if (isCity) {
				loanApplication.setRequestLocation(requestLocation);
			} else {
				LOGGER.error("地址{}不在字典表中", requestLocation);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}
		}
		loanApplication.setRequestType(loanJsonObject.getString("request_type"));
		loanApplication.setRequestMoney(new BigDecimal(loanJsonObject.getString("request_money")));
		loanApplication.setSinotime(date);
		loanApplication.setRequestTime(request_time);

		loanApplicationMapper.insert(loanApplication);
		idMapperMapper.insert(idMapper);

		searchService.insSearchReport(reportId, user, sinoid, "1", date, sinoCardid, date);

		String result = null;
		if (isgetreport.equals("1")) {
			// 个人征信报告
			String creditReport = reportService.getReport(reportId, sinoCardid, user);
			// 贷前审核报告
			String inFinReport = dataControllerService.getInFinReport(user, sinoCardid, cellPhoneNum);
			result = responseJsonService.creaRespJson(true, null, creditReport, inFinReport, "7", reportId);
		} else {
			LOGGER.warn("该机构不要报告");
			result = responseJsonService.creaRespJson(true, null, null, null, null, null);
		}
		return result;
	}

}
