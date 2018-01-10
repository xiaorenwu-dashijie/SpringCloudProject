package com.sinoway.cisp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.BlacklistMapper;
import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.InventoryMapper;
import com.sinoway.cisp.dao.OverdueStatusMapper;
import com.sinoway.cisp.dao.PaidMonthlyAmountMapper;
import com.sinoway.cisp.entitys.Blacklist;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.Inventory;
import com.sinoway.cisp.entitys.OverdueStatus;
import com.sinoway.cisp.entitys.PaidMonthlyAmount;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CispBasicApiService;
import com.sinoway.cisp.service.DataControllerService;
import com.sinoway.cisp.service.MddCityDicService;
import com.sinoway.cisp.service.ReportService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SearchService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.IDUtil;
import com.sinoway.cisp.utils.MddValidator;

@Service(value = "inventoryService")
@Transactional
public class InventoryServiceImpl implements CispBasicApiService {

	private final static Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

	@Autowired
	private ReportService reportService;
	@Autowired
	private SearchService searchService;
	@Autowired
	private ResponseJsonService responseJsonService;
	@Autowired
	private DataControllerService dataControllerService;
	@Autowired
	private MddCityDicService mddCityDicService;

	@Autowired
	private OverdueStatusMapper overdueStatusMapper;
	@Autowired
	private PaidMonthlyAmountMapper paidMonthlyAmountMapper;
	@Autowired
	private InventoryMapper inventoryMapper;
	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private IdMapperMapper idMapperMapper;
	@Autowired
	private BlacklistMapper blackListMapper;

	@Override
	public String pushLoanInfo(User user, String cmd, String isgetreport, String version, String reportId,
			String sinoCardid, String crid, String data) throws Exception {
		Date date = new Date();
		String sinoid = IDUtil.getSinoId(user.getInstiCode(), "H");
		// 合同同意表中数据
		JSONObject jsonobj = new JSONObject(data);
		JSONObject loanInfoJsonObj = jsonobj.getJSONObject("loan_info");
		boolean has = loanInfoJsonObj.has("cell_phone_num");
		String cellPhoneNum = null;
		if (has) {
			cellPhoneNum = loanInfoJsonObj.getString("cell_phone_num");
		} else {
			LOGGER.warn("json中不包含cell_phone_num");
		}

		String contract_money = loanInfoJsonObj.getString("contract_money");
		if (StringUtils.isBlank(contract_money)) {
			LOGGER.error("合同金额为空:{}", contract_money);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}

		String contract_start_time = loanInfoJsonObj.getString("contract_start_time");
		if (StringUtils.isBlank(contract_start_time)) {
			LOGGER.error("合同开始日期为空:{}", contract_start_time);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		Date contractStartTime = DateUtils.parseDate(contract_start_time);
		Date sixMonthAgo = DateUtils.getSixMonthAgo(date);
		if (contractStartTime.getTime() > sixMonthAgo.getTime()) {
			LOGGER.error("合同开始日期不在6个月以前:{}", contract_start_time);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}

		String contract_end_time = loanInfoJsonObj.getString("contract_end_time");
		if (StringUtils.isBlank(contract_end_time)) {
			LOGGER.error("合同结束日期为空:{}", contract_end_time);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		Date contractEndTime = DateUtils.parseDate(contract_end_time);
		if (contractEndTime.getTime() < contractStartTime.getTime()) {
			LOGGER.error("合同结束日期不在开始日期以后:{}", contract_end_time);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}

		String loan_type = loanInfoJsonObj.getString("loan_type");
		if (StringUtils.isBlank(loan_type)) {
			LOGGER.error("贷款类型为空:{}", loan_type);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		String loan_guarantee_type = loanInfoJsonObj.getString("loan_guarantee_type");
		if (StringUtils.isBlank(loan_guarantee_type)) {
			LOGGER.error("担保方式为空:{}", loan_guarantee_type);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		String pay_period = loanInfoJsonObj.getString("pay_period");
		if (StringUtils.isBlank(pay_period)) {
			LOGGER.error("还款期数为空:{}", pay_period);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		String payLocation = loanInfoJsonObj.getString("pay_location");
		if (StringUtils.isBlank(payLocation)) {
			payLocation = "9999";
		} else {
			boolean isCity = mddCityDicService.checkCityCode(payLocation);
			if (!isCity) {
				LOGGER.error("地址{}不在字典表中", payLocation);
				return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}
		}
		String contSinoid = idMapperMapper.findContSinoidByContId(crid, user.getUserAccount());
		if (StringUtils.isNotEmpty(contSinoid)) {
			LOGGER.error("合同编号{}在该机构重复", crid);
			return responseJsonService.creaRespJson(false, "1017", null, null, null, null);
		}
		JSONObject opJsonObject = jsonobj.getJSONObject("op");
		String optionStr = null;
		@SuppressWarnings("unchecked")
		Iterator<String> keys = opJsonObject.keys();
		while (keys.hasNext()) {
			optionStr = keys.next();
		}
		if (!("overdue_info".equals(optionStr) || "loan_info".equals(optionStr))) {
			LOGGER.error("存量key值{}错误", optionStr);
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}

		ContractAcceptDetail contractAcceptDetail = new ContractAcceptDetail();
		contractAcceptDetail.setSinoid(sinoid);
		contractAcceptDetail.setContractId(crid);
		contractAcceptDetail.setContractSum(new BigDecimal(contract_money));
		contractAcceptDetail.setStartTime(DateUtils.parseDate(contract_start_time));
		contractAcceptDetail.setStopTime(DateUtils.parseDate(contract_end_time));
		contractAcceptDetail.setContractType(loan_type);
		contractAcceptDetail.setGuaraType(loan_guarantee_type);
		contractAcceptDetail.setPayPeriod(pay_period);
		contractAcceptDetail.setPayLocation(payLocation);
		contractAcceptDetail.setSinotime(date);

		IdMapper idMapper = new IdMapper();
		idMapper.setSinoid(sinoid);
		idMapper.setSinoCardid(sinoCardid);
		idMapper.setContractId(crid);
		idMapper.setDataFrom("4");// 数据来源：存量接口
		idMapper.setCellPhoneNum(cellPhoneNum);
		idMapper.setUserAccount(user.getUserAccount());
		idMapper.setSinotime(date);
		idMapper.setInstiCode(user.getInstiCode());

		JSONObject optionJsonObject = opJsonObject.getJSONObject(optionStr);

		if ("overdue_info".equals(optionStr)) {
			String overdue_start_time = optionJsonObject.getString("overdue_start_time");
			String overdue_duration = optionJsonObject.getString("overdue_duration");
			String overdue_reason = optionJsonObject.getString("overdue_reason");
			String overdue_status = optionJsonObject.getString("overdue_status");

			if (MddValidator.findMdd(overdue_status, "81", "82", "83", "84")) {
				List<Blacklist> blacklists = blackListMapper.findBlackBySinocardidAndAccount(sinoCardid,
						user.getUserAccount());
				if (CollectionUtils.isEmpty(blacklists)) {
					LOGGER.warn("该信息主体{}在本机构没有黑名单", sinoCardid);
				} else {
					for (Blacklist blacklist : blacklists) {
						blacklist.setOverdueStatus(overdue_status);
						blacklist.setIshide("1");
						blacklist.setHideTime(date);
						blackListMapper.updateByPrimaryKey(blacklist);
					}
					LOGGER.info("对该信息主体{}洗白黑名单成功", sinoCardid);
				}
			}
			OverdueStatus overdueStatus = new OverdueStatus();
			overdueStatus.setSinoid(sinoid);
			overdueStatus.setOverdueStartTime(DateUtils.parseDate(overdue_start_time));
			overdueStatus.setPaymentLevel(Integer.valueOf(overdue_duration));
			overdueStatus.setOverdueReason(overdue_reason);
			overdueStatus.setOverdueStatusMark(overdue_status);
			overdueStatus.setColSn("1");
			overdueStatus.setSinotime(date);
			overdueStatusMapper.insert(overdueStatus);

			contractAcceptDetail.setContractStatus("4");// 债权状态：逾期
			idMapper.setCrStatus(overdue_status);// 处置状态：传的参数

		} else if ("loan_info".equals(optionStr)) {
			String last_time_paid = optionJsonObject.getString("last_time_paid");
			String unpaid_money = optionJsonObject.getString("unpaid_money");
			String current_bill_money = optionJsonObject.getString("current_bill_money");

			PaidMonthlyAmount paidMonthlyAmount = new PaidMonthlyAmount();
			paidMonthlyAmount.setPaidMoney(new BigDecimal(current_bill_money));
			paidMonthlyAmount.setPaidTime(DateUtils.parseDate(last_time_paid));
			paidMonthlyAmount.setPaymentnumber(1);
			paidMonthlyAmount.setSinoid(sinoid);
			paidMonthlyAmount.setSinotime(date);
			paidMonthlyAmountMapper.insert(paidMonthlyAmount);

			Inventory inventory = new Inventory();
			inventory.setSinoid(sinoid);
			inventory.setNotRepayMoney(new BigDecimal(unpaid_money));
			inventory.setPaymentDate(DateUtils.parseDate(last_time_paid));
			inventory.setCurrentMoney(new BigDecimal(current_bill_money));
			inventory.setSinotime(date);
			inventoryMapper.insert(inventory);

			contractAcceptDetail.setContractStatus("1");// 债权状态：正常
			idMapper.setCrStatus("23");// 处置状态：正常还款
		}
		contractAcceptDetailMapper.insert(contractAcceptDetail);
		idMapperMapper.insert(idMapper);
		searchService.insSearchReport(reportId, user, sinoid, "4", date, sinoCardid, date);
		String result = null;
		if (isgetreport.equals("1")) {
			// 个人征信报告
			String creditReport = reportService.getReport(reportId, sinoCardid, user);
			// 存量预警报告
			String postLoanReport = dataControllerService.getPostLoanReport(user, sinoCardid, cellPhoneNum);
			result = responseJsonService.creaRespJson(true, null, creditReport, postLoanReport, "8", reportId);
		} else {
			LOGGER.warn("该机构不要报告");
			result = responseJsonService.creaRespJson(true, null, null, null, null, null);
		}
		return result;
	}

}
