package com.sinoway.cisp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.ExtendTimeMapper;
import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.LoanApplicationMapper;
import com.sinoway.cisp.dao.OverdueStatusMapper;
import com.sinoway.cisp.dao.PaidMonthlyAmountMapper;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.ExtendTime;
import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.OverdueStatus;
import com.sinoway.cisp.entitys.PaidMonthlyAmount;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CispBasicApiService;
import com.sinoway.cisp.service.ReportService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SearchService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.MddValidator;
import com.sinoway.cisp.utils.PhoneNumberUtil;

@Service(value = "debtService")
@Transactional
public class DebtServiceImpl implements CispBasicApiService {
	private final static Logger LOGGER = LoggerFactory.getLogger(DebtServiceImpl.class);

	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private PaidMonthlyAmountMapper paidMonthlyAmountMapper;
	@Autowired
	private ExtendTimeMapper extendTimeMapper;
	@Autowired
	private OverdueStatusMapper overdueStatusMapper;
	@Autowired
	private IdMapperMapper idMapperMapper;
	@Autowired
	private LoanApplicationMapper loanApplicationMapper;

	@Autowired
	private ReportService reportService;
	@Autowired
	private SearchService searchService;
	@Autowired
	private ResponseJsonService responseJsonService;

	@Override
	public String pushLoanInfo(User user, String cmd, String isgetreport, String version, String reportId,
			String sinoCardid, String crid, String data) throws Exception {
		Date currentDate = new Date();
		String result = null;
		String reqReason = null;

		IdMapper idMapper = idMapperMapper.findidMapperByContId(crid, user.getUserAccount());
		if (idMapper == null) {
			LOGGER.error("权限不足，该合同{}不属于该机构", crid);
			return responseJsonService.creaRespJson(false, "1010", null, null, null, null);
		}
		String sinoid = idMapper.getSinoid();
		ContractAcceptDetail contractAcceptDetail = contractAcceptDetailMapper.selectByPrimaryKey(sinoid);
		// 进行判断合同号是否为空
		if (contractAcceptDetail != null) {
			JSONObject dataJsonObject = new JSONObject(data);
			JSONObject opJson = dataJsonObject.getJSONObject("op");

			@SuppressWarnings("unchecked")
			Iterator<String> iterator = opJson.keys();
			List<String> upOptionList = new ArrayList<String>();
			while (iterator.hasNext()) {
				upOptionList.add((String) iterator.next());
			}

			boolean mdd = true;
			if (!upOptionList.contains("cell_phone_num")) { // 决策中不包含手机号,则决策数量只能为1
				if (upOptionList.size() != 1) {
					LOGGER.error("贷中决策有且只能有一个");
					return responseJsonService.creaRespJson(false, "1008", null, null, null, null);
				} else {
					mdd = MddValidator.findMdd(upOptionList.get(0), "repayment", "settle", "extendible", "overdue");
				}
			} else {
				if (upOptionList.size() != 2) { // 决策中含有手机号，则决策数量只能为2
					LOGGER.error("贷中决策有且只能有一个");
					return responseJsonService.creaRespJson(false, "1008", null, null, null, null);
				} else {
					if ("cell_phone_num".equals(upOptionList.get(0))) { // 判断是否0位是手机号,是则判断1位是否争取
						mdd = MddValidator.findMdd(upOptionList.get(1), "repayment", "settle", "extendible", "overdue");
					} else {
						mdd = MddValidator.findMdd(upOptionList.get(0), "repayment", "settle", "extendible", "overdue");
					}
				}
			}
			if (!mdd) {
				LOGGER.error("贷中决策与规定的四个不符");
				return responseJsonService.creaRespJson(false, "1008", null, null, null, null);
			}

			String upOption = upOptionList.get(0); // JSON中的贷中选项 --还款/结清/逾期/展期
			if ("cell_phone_num".equals(upOption)) {
				upOption = upOptionList.get(1);
			}
			LoanApplication loanApplication = loanApplicationMapper.selectByPrimaryKey(sinoid);
			JSONObject upOptionJson = opJson.getJSONObject(upOption);
			boolean has = opJson.has("cell_phone_num");
			if (has) {
				String cellPhoneNum = opJson.getString("cell_phone_num");
				boolean validatePhone = PhoneNumberUtil.isMobile(cellPhoneNum);
				if (validatePhone) {
					if (loanApplication != null) {
						loanApplication.setCellPhoneNum(cellPhoneNum);
					}
					idMapper.setCellPhoneNum(cellPhoneNum);
				} else {
					LOGGER.warn("手机号校验错误:{}", cellPhoneNum);
				}
			}

			String contractStatus = contractAcceptDetail.getContractStatus();
			if ("repayment".equals(upOption)) {
				if (!MddValidator.findMdd(contractStatus, "1", "3", "4", "6", "9")) {
					LOGGER.error("数据操作错误，合同状态为{}的时候不能进行还款操作", contractStatus);
					return responseJsonService.creaRespJson(false, "1005", null, null, null, null);
				}
				reqReason = "9";
				List<PaidMonthlyAmount> paidMonthlyAmountList = paidMonthlyAmountMapper
						.selectPaidMonthlyAmountListBySinoid(sinoid);

				String paid_time = upOptionJson.getString("paid_time");
				if (StringUtils.isEmpty(paid_time)) {
					LOGGER.error("贷中还款时间不能为空");
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
				String paid_money = upOptionJson.getString("paid_money");
				String remark = upOptionJson.getString("remark");
				if (CollectionUtils.isEmpty(paidMonthlyAmountList)) {
					PaidMonthlyAmount paidMonthlyAmount = new PaidMonthlyAmount();
					paidMonthlyAmount.setPaidTime(DateUtils.parseDate(paid_time));
					paidMonthlyAmount.setPaymentnumber(1);// 需要进行判断
					paidMonthlyAmount.setPaidMoney(new BigDecimal(paid_money));
					paidMonthlyAmount.setRemark(remark);
					paidMonthlyAmount.setSinoid(sinoid);
					paidMonthlyAmount.setSinotime(currentDate);
					paidMonthlyAmountMapper.insert(paidMonthlyAmount);
				} else {
					// 期数加一
					PaidMonthlyAmount paidMonthlyAmount = paidMonthlyAmountList.get(0);
					int paymentnumber = paidMonthlyAmount.getPaymentnumber();

					PaidMonthlyAmount paids = new PaidMonthlyAmount();
					paids.setPaidTime(DateUtils.parseDate(paid_time));
					paids.setPaymentnumber(paymentnumber + 1);// 需要进行判断
					paids.setPaidMoney(new BigDecimal(paid_money));
					paids.setRemark(remark);
					paids.setSinoid(sinoid);
					paids.setSinotime(currentDate);
					paidMonthlyAmountMapper.insert(paids);
				}
				contractAcceptDetail.setContractStatus("1");// 正常还款
				idMapper.setCrStatus("23");// 正常还款

			} else if ("settle".equals(upOption)) {
				if (!MddValidator.findMdd(contractStatus, "1", "3", "4", "6", "9")) {
					LOGGER.error("数据操作错误，合同状态为{}的时候不能进行结清操作", contractStatus);
					return responseJsonService.creaRespJson(false, "1005", null, null, null, null);
				}
				reqReason = "10";
				// 结清日期
				String settle_time = upOptionJson.getString("settle_time");

				idMapper.setCrStatus("21");// 贷款结清
				// idMapper.setSinotime(currentDate);
				Date settleTime = contractAcceptDetail.getSettleTime();
				if (settleTime == null) {
					contractAcceptDetail.setSettleTime(DateUtils.parseDate(settle_time));
					contractAcceptDetail.setContractStatus("2");// 贷款结清
				} else {
					// 只能结清一次
					LOGGER.error("该合同{}已经结清", crid);
					return responseJsonService.creaRespJson(false, "1009", null, null, null, null);
				}
			} else if ("extendible".equals(upOption)) {
				if (!MddValidator.findMdd(contractStatus, "1", "4", "6", "9")) {
					LOGGER.error("数据操作错误，合同状态为{}的时候不能进行展期操作", contractStatus);
					return responseJsonService.creaRespJson(false, "1005", null, null, null, null);
				}
				reqReason = "11";
				ExtendTime extendTime = extendTimeMapper.selectByPrimaryKey(sinoid);
				if (extendTime == null) {
					String extend_limit_time = upOptionJson.getString("extend_limit_time");
					String whole_not_paid = upOptionJson.getString("whole_not_paid");
					extendTime = new ExtendTime();
					extendTime.setExtendLimitTime(DateUtils.parseDate(extend_limit_time));
					extendTime.setWholeNotPaid(new BigDecimal(whole_not_paid));
					extendTime.setSinoid(sinoid);
					extendTime.setSinotime(currentDate);
					extendTimeMapper.insertSelective(extendTime);

					idMapper.setCrStatus("22");// 贷款展期
					// idMapper.setSinotime(currentDate);
					contractAcceptDetail.setContractStatus("3");// 贷款展期
					// contractAcceptDetail.setSinotime(currentDate);
				} else {
					// 只能展期一次
					LOGGER.error("该合同{}已经展期", crid);
					return responseJsonService.creaRespJson(false, "1015", null, null, null, null);
				}
			} else if ("overdue".equals(upOption)) {
				if (!MddValidator.findMdd(contractStatus, "1", "3", "6", "9")) {
					LOGGER.error("数据操作错误，合同状态为{}的时候不能进行逾期操作", contractStatus);
					return responseJsonService.creaRespJson(false, "1005", null, null, null, null);
				}
				reqReason = "12";
				// 得到所有的OverdueStatus对象
				List<OverdueStatus> overdueStatusList = overdueStatusMapper.findOverdueListBySinoid(sinoid);

				if (CollectionUtils.isEmpty(overdueStatusList)) {
					String overdue_start_time = upOptionJson.getString("overdue_start_time");
					String payment_leve = upOptionJson.getString("payment_leve");
					String overdue_reason = upOptionJson.getString("overdue_reason");
					String overdue_status_mark = upOptionJson.getString("overdue_status_mark");

					OverdueStatus overdueStatus = new OverdueStatus();
					overdueStatus.setSinoid(sinoid);
					overdueStatus.setColSn("1");
					overdueStatus.setPaymentLevel(Integer.valueOf(payment_leve));
					overdueStatus.setOverdueStartTime(DateUtils.parseDate(overdue_start_time));
					overdueStatus.setOverdueReason(overdue_reason);
					overdueStatus.setOverdueStatusMark(overdue_status_mark);
					overdueStatus.setSinotime(currentDate);
					overdueStatusMapper.insert(overdueStatus);

					idMapper.setCrStatus(overdue_status_mark);// 逾期状态，这是传的参数
					contractAcceptDetail.setContractStatus("4");// 逾期
				} else {// 已经逾期 可以进行催收
					LOGGER.error("该合同{}已经逾期", crid);
					return responseJsonService.creaRespJson(false, "1014", null, null, null, null);
				}
			} else {
				LOGGER.error("请选择一个贷中决策");
				return responseJsonService.creaRespJson(false, "1008", null, null, null, null);
			}
			idMapperMapper.updateByPrimaryKey(idMapper);
			contractAcceptDetailMapper.updateByPrimaryKey(contractAcceptDetail);
			loanApplicationMapper.updateByPrimaryKey(loanApplication);
			searchService.insSearchReport(reportId, user, sinoid, reqReason, currentDate, sinoCardid, currentDate);
			if ("1".equals(isgetreport)) {
				String report = reportService.getReport(reportId, sinoCardid, user);
				result = responseJsonService.creaRespJson(true, null, report, null, null, reportId);
			} else {
				LOGGER.warn("该机构不要报告");
				result = responseJsonService.creaRespJson(true, null, null, null, null, null);
			}
		} else {
			// 没有找到合同号
			LOGGER.error("合同编号{}不存在", crid);
			return responseJsonService.creaRespJson(false, "1012", null, null, null, null);
		}
		return result;
	}

}
