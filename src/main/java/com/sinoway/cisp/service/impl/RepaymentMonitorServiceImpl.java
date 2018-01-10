package com.sinoway.cisp.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.InstiDetailMapper;
import com.sinoway.cisp.dao.PaidMonthlyAmountMapper;
import com.sinoway.cisp.dao.SearchDetailMapper;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.ErrorFieldWarning;
import com.sinoway.cisp.entitys.PaidMonthlyAmount;
import com.sinoway.cisp.entitys.SubmittingBehavior;
import com.sinoway.cisp.service.IRepaymentMonitorService;
import com.sinoway.cisp.utils.RepaymentDateUtil;

@Component
public class RepaymentMonitorServiceImpl implements IRepaymentMonitorService {

	@Resource
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Resource
	private PaidMonthlyAmountMapper paidMonthlyAmountMapper;
	@Resource
	private IdMapperMapper idMapperMapper;
	@Resource
	private InstiDetailMapper instiDetailMapper;
	@Resource
	private SearchDetailMapper searchDetailMapper;

	private static final String PRESINOID = "SINOWAY-S-";

	@Override
	public List<ErrorFieldWarning> allInstiRepaymentMonitor() throws ParseException {

		List<String> instiCodeList = instiDetailMapper.selectAllInstiCode();
		List<ErrorFieldWarning> errorFieldWarningList = new ArrayList<ErrorFieldWarning>();
		for (String instiCode : instiCodeList) {
			long unqualifiedDataCountOfPaidTime = 0; // 时间不合格数据量(若还款时间-预估还款时间>20则判定不合格,数量加1)
			long unqualifiedDataCountOfPaidMoney = 0; // 还款金额不合格数据量
			List<String> sinoidList = idMapperMapper.selectSinoidsByInstiCode(instiCode);
			ContractAcceptDetail contractAcceptDetail = null;
			for (String sinoid : sinoidList) {
				contractAcceptDetail = contractAcceptDetailMapper.selectRepaymentInfoBySinoid(sinoid);
				if (contractAcceptDetail != null) { // 若contractAcceptDetail为null则说明该sinoid未签约同意(未到贷中状态)
					int payPeriod = 0;
					String payPeriodString = contractAcceptDetail.getPayPeriod();
					if (StringUtils.isNotBlank(payPeriodString)) {
						payPeriod = Integer.parseInt(payPeriodString); // 还款总期数
					}

					Date startDate = contractAcceptDetail.getStartTime();
					Date stopDate = contractAcceptDetail.getStopTime();

					if (startDate != null && stopDate != null && payPeriod > 0) {

						long contractSum = contractAcceptDetail.getContractSum().longValue(); // 合同金额
						long estimatedRepaymentMoneyPerInstalment = contractSum / payPeriod; // 预计每期应还款金额
						// 预估每期应还款的时间点
						List<Date> estimatedRepaymentDateList = RepaymentDateUtil.repaymentDate(startDate, stopDate,
								payPeriod);
						// boolean daysFlag=true;
						// boolean moneyFlag=true;

						List<PaidMonthlyAmount> paidMonthlyAmountList = paidMonthlyAmountMapper
								.selectPaidMonthlyAmountBySinoid(sinoid);
						if (!paidMonthlyAmountList.isEmpty()) {

							for (PaidMonthlyAmount paidMonthlyAmount : paidMonthlyAmountList) {
								long intervalDays = -1;
								// if (daysFlag) {
								// |预期还款时间-实际还款时间|
								int estimatedRepaymentDateSubscript = paidMonthlyAmount.getPaymentnumber() - 1;// 实际还款期数下标
								int estimatedRepaymentDateListSize = estimatedRepaymentDateList.size();// 还款期数
								if (estimatedRepaymentDateSubscript < estimatedRepaymentDateListSize) {
									intervalDays = Math.abs(TimeUnit.MILLISECONDS.toDays(
											paidMonthlyAmount.getPaidTime().getTime() - estimatedRepaymentDateList
													.get(estimatedRepaymentDateSubscript).getTime()));
									if (intervalDays > 20) { // 如果至少一期的应还款时间和还款时间差距20天则数量加1
										// if
										// (unqualifiedDataCountOfPaidTime<10001)
										// {
										unqualifiedDataCountOfPaidTime++;
										// daysFlag=false;
										// }
									}
								}

								// }

								long differenceAmount = -1;
								// if (moneyFlag) {
								// |预期还款金额-实际还款金额|
								differenceAmount = Math.abs(paidMonthlyAmount.getPaidMoney().longValue()
										- estimatedRepaymentMoneyPerInstalment);
								if (differenceAmount > 5000) { // 如果至少一期的应还款金额和实际还款金额差距5000元则数量加1
									// if
									// (unqualifiedDataCountOfPaidMoney<10001) {
									unqualifiedDataCountOfPaidMoney++;
									// moneyFlag=false;
									// }
								}
								// }
							}
						}
					}
				}
			}
			// TODO 更改阈值!!!
			if (unqualifiedDataCountOfPaidTime > 10000 || unqualifiedDataCountOfPaidMoney > 10000) {
				String instiName = instiDetailMapper.selectInstiNameByInstiCode(instiCode);
				ErrorFieldWarning errorFieldWarning = new ErrorFieldWarning();
				errorFieldWarning.setInstiCode(instiCode);
				errorFieldWarning.setInstiName(instiName);
				if (unqualifiedDataCountOfPaidTime > 10000) { // 改为10000!!!
					errorFieldWarning.setUnqualifiedDataCountOfPaidTime(String.valueOf(unqualifiedDataCountOfPaidTime));
				} else {
					errorFieldWarning.setUnqualifiedDataCountOfPaidTime("-");

				}
				if (unqualifiedDataCountOfPaidMoney > 10000) { // 改为10000!!!
					errorFieldWarning.setUnqualifiedDataCountOfPaidMoney(String.valueOf(unqualifiedDataCountOfPaidMoney));
				} else {
					errorFieldWarning.setUnqualifiedDataCountOfPaidMoney("-");
				}
				errorFieldWarningList.add(errorFieldWarning);
			}
		}
		return errorFieldWarningList;

	}

	@Override
	public List<SubmittingBehavior> submittingBehaviorMontior() {
		List<String> instiCodeList = instiDetailMapper.selectAllInstiCode();
		List<SubmittingBehavior> submittingBehaviorList = new ArrayList<SubmittingBehavior>();
		for (String instiCode : instiCodeList) {
			String sinoid = PRESINOID + instiCode + "-%";
			int contCount = searchDetailMapper.findContCountBySinoid(sinoid); // 签约数量-效率低待优化
			int upCount = searchDetailMapper.findUpCountBySinoid(sinoid); // 贷中数量-效率低待优化
			// 贷中/签约<0.8
			double upCont = 0;
			if (contCount > 0) {
				upCont = (double) upCount / contCount;
				// TODO 更改阈值!!!
				if (upCont < 0.8) {
					String instiName = instiDetailMapper.selectInstiNameByInstiCode(instiCode);
					SubmittingBehavior submittingBehavior = new SubmittingBehavior();
					submittingBehavior.setInstiCode(instiCode);
					submittingBehavior.setInstiName(instiName);
					submittingBehavior.setContCount(contCount);
					submittingBehavior.setUpCount(upCount);
					submittingBehaviorList.add(submittingBehavior);
				}
			}

		}
		return submittingBehaviorList;

	}

	@Override
	public List<SubmittingBehavior> contractBehaviorMontior() {
		List<String> instiCodeList = instiDetailMapper.selectAllInstiCode();
		List<SubmittingBehavior> contractBehaviorList = new ArrayList<SubmittingBehavior>();
		for (String instiCode : instiCodeList) {
			String sinoid = PRESINOID + instiCode + "-%";
			int contCount = searchDetailMapper.findContCountBySinoid(sinoid); // 签约数量-效率低待优化
			int loanCount = searchDetailMapper.findLoanCountBySinoid(sinoid); // 进件数量-效率低待优化
			// 贷中/签约<0.8
			double modulus = 0;
			if (loanCount > 0) {
				modulus = (double) contCount / loanCount;
				// TODO 更改阈值!!!
				if (modulus < 0.2) {
					String instiName = instiDetailMapper.selectInstiNameByInstiCode(instiCode);
					SubmittingBehavior submittingBehavior = new SubmittingBehavior();
					submittingBehavior.setInstiCode(instiCode);
					submittingBehavior.setInstiName(instiName);
					submittingBehavior.setContCount(contCount);
					submittingBehavior.setLoanCount(loanCount);
					contractBehaviorList.add(submittingBehavior);
				}
			}

		}
		return contractBehaviorList;
	}

	@Override
	public List<SubmittingBehavior> dataQualityMontior() {
		List<String> instiCodeList = instiDetailMapper.selectAllInstiCode();
		List<SubmittingBehavior> dataQualityList = new ArrayList<SubmittingBehavior>();
		for (String instiCode : instiCodeList) {
			String sinoid = PRESINOID + instiCode + "-%";
			int acceptCount = contractAcceptDetailMapper.selectacceptCountBySinoid(sinoid); // 签约数量-效率低待优化
			int acceptBadCount = contractAcceptDetailMapper.selectacceptBadCountBySinoid(sinoid); // 进件数量-效率低待优化

			double datamodulus = 0;
			if (acceptCount > 0) {
				datamodulus = (double) acceptBadCount / acceptCount;
				// TODO 更改阈值!!!
				if (datamodulus > 0.5) {

					String instiName = instiDetailMapper.selectInstiNameByInstiCode(instiCode);
					SubmittingBehavior submittingBehavior = new SubmittingBehavior();
					submittingBehavior.setInstiCode(instiCode);
					submittingBehavior.setInstiName(instiName);
					submittingBehavior.setAcceptCount(acceptCount);
					submittingBehavior.setAcceptBadCount(acceptBadCount);
					dataQualityList.add(submittingBehavior);
				}
			}

		}
		return dataQualityList;
	}

}
