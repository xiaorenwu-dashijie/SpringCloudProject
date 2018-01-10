package com.sinoway.cisp.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.ContractCancelDetailMapper;
import com.sinoway.cisp.dao.ContractDelayHistoryMapper;
import com.sinoway.cisp.dao.ContractRefuseDetailMapper;
import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.LoanApplicationMapper;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.ContractCancelDetail;
import com.sinoway.cisp.entitys.ContractDelayHistory;
import com.sinoway.cisp.entitys.ContractDelayHistoryExample;
import com.sinoway.cisp.entitys.ContractRefuseDetail;
import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CispBasicApiService;
import com.sinoway.cisp.service.MddCityDicService;
import com.sinoway.cisp.service.ReportService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SearchService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.MddValidator;
import com.sinoway.cisp.utils.PhoneNumberUtil;

@Service(value = "contractService")
@Transactional
public class ContractServiceImpl implements CispBasicApiService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ContractServiceImpl.class);

	@Autowired
	private IdMapperMapper idMapperMapper;
	@Autowired
	private LoanApplicationMapper loanApplicationMapper;
	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private ContractDelayHistoryMapper contractDelayHistoryMapper;
	@Autowired
	private ContractRefuseDetailMapper contractRefuseDetailMapper;
	@Autowired
	private ContractCancelDetailMapper contractCancelDetailMapper;
	@Autowired
	private ReportService reportService;
	@Autowired
	private SearchService searchService;
	@Autowired
	private ResponseJsonService responseJsonService;
	@Autowired
	private MddCityDicService mddCityDicService;

	@Override
	public String pushLoanInfo(User user, String cmd, String isgetreport, String version, String reportId,
			String sinoCardid, String crid, String data) throws Exception {
		String reqReason = null;
		String result = null;

		String userAccount = user.getUserAccount();
		IdMapper idMapper = idMapperMapper.findIdmapperByInstiid(crid, userAccount);
		if (idMapper == null) {
			LOGGER.error("权限不足，该机构没有该进件{}，不能进行操作", crid);
			result = responseJsonService.creaRespJson(false, "1011", null, null, null, null);// 权限不足或者没有该进件
		} else {
			String sinoid = idMapper.getSinoid();
			LoanApplication loanApplication = loanApplicationMapper.selectByPrimaryKey(sinoid);

			JSONObject jsonObject = new JSONObject(data);
			JSONObject opJson = jsonObject.getJSONObject("op");
			JSONObject loanInfoJson = jsonObject.getJSONObject("loan_info");
			String option = null;
			@SuppressWarnings("unchecked")
			Iterator<String> iterator = opJson.keys();
			List<String> upOptionList = new ArrayList<String>();
			while (iterator.hasNext()) {
				upOptionList.add((String) iterator.next());
			}
			if (upOptionList.size() != 1) {
				LOGGER.error("签约决策有且只能有一个");
				return responseJsonService.creaRespJson(false, "1008", null, null, null, null);
			}
			@SuppressWarnings("rawtypes")
			Iterator keys = opJson.keys();
			while (keys.hasNext()) {
				option = (String) keys.next();
			}

			// 判断进件状态
			String requestResult = loanApplication.getRequestResult();
			if (StringUtils.isNotEmpty(requestResult)) {
				if (MddValidator.findMdd(requestResult, "1", "2", "4")) {
					LOGGER.error("合同处理错误,该进件{}审批结果为{},不能再次审批", crid, requestResult);
					return responseJsonService.creaRespJson(false, "1009", null, null, null, null);
				}
			}

			boolean has = loanInfoJson.has("cell_phone_num");
			if (has) {
				String cellPhoneNum = loanInfoJson.getString("cell_phone_num");
				if (StringUtils.isNotBlank(cellPhoneNum)) {
					boolean validatePhone = PhoneNumberUtil.isMobile(cellPhoneNum);
					if (validatePhone) {
						loanApplication.setCellPhoneNum(cellPhoneNum);
					} else {
						LOGGER.warn("手机号校验错误:{}", cellPhoneNum);
					}
				}
			}
			Date date = new Date();
			if ("accept".equals(option)) {
				ContractAcceptDetail contractAcceptDetail = new ContractAcceptDetail();

				reqReason = "5";// 查询原因：同意贷款
				idMapper.setCrStatus("11");// 设置id映射，合同状态为同意贷款
				loanApplication.setRequestResult("1");// 封装申请结果，同意贷款

				JSONObject acceptJson = opJson.getJSONObject("accept");
				idMapper.setContractId(acceptJson.getString("contract_id"));
				contractAcceptDetail.setSinoid(sinoid);
				contractAcceptDetail.setContractStatus("1");// 正常

				String contractid = acceptJson.getString("contract_id");
				String contSinoid = idMapperMapper.findContSinoidByContId(contractid, userAccount);
				if (StringUtils.isEmpty(contSinoid)) {
					contractAcceptDetail.setContractId(contractid);
				} else {
					LOGGER.error("该机构已经有该合同编号:{}", contractid);
					return responseJsonService.creaRespJson(false, "1017", null, null, null, null);
				}

				contractAcceptDetail.setPayPeriod(acceptJson.getString("pay_period"));
				String startTime = acceptJson.getString("start_time");
				Date contStartTime = null;
				if (StringUtils.isNotBlank(startTime)) {
					contStartTime = DateUtils.parseDate(startTime);
					Date requestTime = loanApplication.getRequestTime();
					if (!(contStartTime.getTime() >= requestTime.getTime()
							&& contStartTime.getTime() <= date.getTime())) {
						LOGGER.error("合同开始时间{}不在申请日期{}和报送时间之间", startTime,
								DateUtils.dateToStr(requestTime));
						return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
					}
					contractAcceptDetail.setStartTime(contStartTime);
				} else {
					LOGGER.error("合同开始时间不能为空");
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
				String stopTime = acceptJson.getString("stop_time");
				Date contStopTime = null;
				if (StringUtils.isNotBlank(stopTime)) {
					contStopTime = DateUtils.parseDate(stopTime);
					if (contStopTime.getTime() < contStartTime.getTime()) {
						LOGGER.error("合同结束时间{}小于合同开始时间{}", stopTime, startTime);
						return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
					}
					contractAcceptDetail.setStopTime(contStopTime);
				} else {
					LOGGER.error("合同结束时间不能为空");
					return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
				// 合同金额可以为空
				String contractSum = loanInfoJson.getString("contract_sum");
				if (StringUtils.isBlank(contractSum)) {
					contractAcceptDetail.setContractSum(null);
				} else {
					BigDecimal bigDecimal = new BigDecimal(contractSum);
					contractAcceptDetail.setContractSum(bigDecimal);
				}

				contractAcceptDetail.setContractType(acceptJson.getString("contract_type"));
				contractAcceptDetail.setGuaraType(acceptJson.getString("guara_type"));
				String payLocation = acceptJson.getString("pay_location");
				if (StringUtils.isBlank(payLocation)) {
					contractAcceptDetail.setPayLocation("9999");
				} else {
					boolean isCity = mddCityDicService.checkCityCode(payLocation);
					if (isCity) {
						contractAcceptDetail.setPayLocation(payLocation);
					} else {
						LOGGER.error("地址{}不在字典表中", payLocation);
						return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
					}
				}
				contractAcceptDetail.setSinotime(date);

				contractAcceptDetailMapper.insert(contractAcceptDetail);

			} else if ("refuse".equals(option)) {
				reqReason = "6";// 查询原因：拒绝贷款
				idMapper.setCrStatus("12");// 拒绝贷款
				loanApplication.setRequestResult("2");// 封装申请结果，拒绝贷款
				JSONObject refuseJson = opJson.getJSONObject("refuse");

				ContractRefuseDetail contractRefuseDetail = new ContractRefuseDetail();
				contractRefuseDetail.setSinoid(sinoid);
				contractRefuseDetail.setRefuseTime(DateUtils.parseDate(refuseJson.getString("refuse_time")));
				contractRefuseDetail.setRefuseReason(refuseJson.getString("refuse_reason"));
				contractRefuseDetail.setSinotime(date);

				contractRefuseDetailMapper.insert(contractRefuseDetail);

			} else if ("delay".equals(option)) {

				ContractDelayHistoryExample example = new ContractDelayHistoryExample();
				com.sinoway.cisp.entitys.ContractDelayHistoryExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andSinoidEqualTo(sinoid);
				List<ContractDelayHistory> selectByExample = contractDelayHistoryMapper.selectByExample(example);
				ContractDelayHistory contractDelayHistory = new ContractDelayHistory();
				contractDelayHistory.setSinoid(sinoid);
				contractDelayHistory.setSinotime(new Date());
				if (selectByExample.size() == 0) {
					contractDelayHistory.setSn(String.valueOf(1));
				} else {
					int max = 0;
					for (ContractDelayHistory contractDelayHistory2 : selectByExample) {
						String sn = contractDelayHistory2.getSn();
						if (Integer.parseInt(sn) > max) {
							max = Integer.parseInt(sn);
						}
						max += max;
					}
					contractDelayHistory.setSn(String.valueOf(max));
				}
				contractDelayHistoryMapper.insert(contractDelayHistory);

				reqReason = "7";// 查询原因：延迟贷款
				idMapper.setCrStatus("13");// 延迟贷款
				loanApplication.setRequestResult("3");// 封装申请结果，延迟处理

			} else if ("clientcancel".equals(option)) {
				reqReason = "8";// 查询原因：客户取消
				idMapper.setCrStatus("14");// 客户取消
				loanApplication.setRequestResult("4");// 封装申请结果，客户取消

				ContractCancelDetail contractCancelDetail = new ContractCancelDetail();
				contractCancelDetail.setSinoid(sinoid);
				contractCancelDetail.setCancelTime(date);
				contractCancelDetail.setSinotime(date);

				contractCancelDetailMapper.insert(contractCancelDetail);

			} else {
				LOGGER.error("请发送正确的合同相关决策:accept/refuse/delay/clientcancel");
				return responseJsonService.creaRespJson(false, "1008", null, null, null, null);// 正确的相关决策
			}
			idMapperMapper.updateByPrimaryKey(idMapper);
			loanApplicationMapper.updateByPrimaryKey(loanApplication);
			searchService.insSearchReport(reportId, user, sinoid, reqReason, date, sinoCardid, date);
			if (isgetreport.equals("1")) {
				String report = reportService.getReport(reportId, sinoCardid, user);
				result = responseJsonService.creaRespJson(true, null, report, null, null, reportId);
			} else {
				LOGGER.warn("该机构不要报告");
				result = responseJsonService.creaRespJson(true, null, null, null, null, null);
			}
		}

		return result;
	}

}
