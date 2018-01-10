package com.sinoway.cisp.service.impl;

import java.util.Date;
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
import com.sinoway.cisp.dao.LoanApplicationMapper;
import com.sinoway.cisp.dao.OverdueStatusMapper;
import com.sinoway.cisp.entitys.Blacklist;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.OverdueStatus;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CispBasicApiService;
import com.sinoway.cisp.service.ReportService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SearchService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.MddValidator;
import com.sinoway.cisp.utils.PhoneNumberUtil;

@Service(value = "collectionService")
@Transactional
public class CollectionServiceImpl implements CispBasicApiService {
	private final static Logger LOGGER = LoggerFactory.getLogger(CollectionServiceImpl.class);

	@Autowired
	private ReportService reportService;
	@Autowired
	private SearchService searchService;
	@Autowired
	private ResponseJsonService responseJsonService;

	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private OverdueStatusMapper overdueStatusMapper;
	@Autowired
	private LoanApplicationMapper loanApplicationMapper;
	@Autowired
	private IdMapperMapper idMapperMapper;
	@Autowired
	private BlacklistMapper blacklistMapper;

	@Override
	public String pushLoanInfo(User user, String cmd, String isgetreport, String version, String reportId,
			String sinoCardid, String crid, String data) throws Exception {
		Date date = new Date();

		String result = null;
		JSONObject dataJsonObject = new JSONObject(data);
		JSONObject overdueInfoJson = dataJsonObject.getJSONObject("overdue_info"); // 逾期信息

		String overdue_start_time = overdueInfoJson.getString("overdue_start_time"); // 逾期开始时间
		String overdue_duration = overdueInfoJson.getString("overdue_duration"); // 逾期时长
		String overdue_reason = overdueInfoJson.getString("overdue_reason"); // 逾期原因
		String overdue_status = overdueInfoJson.getString("overdue_status"); // 逾期状态

		// 参数校验:cell_phone_num(手机号) 若不传或者为空则不更改,若传了则更新
		String cellPhoneNum = null;
		boolean falgCellPhoneNum = true; // 判断JSON是不是含有cell_phone_num,如果true,则需要更新,false则不需要更新
		boolean has = overdueInfoJson.has("cell_phone_num");
		if (has) { // 若手机号存在则必须满足手机号格式,不存在则设为null
			cellPhoneNum = overdueInfoJson.getString("cell_phone_num");
			if (StringUtils.isBlank(cellPhoneNum)) { // 如果cellPhoneNum为空则false,不更新loanapplication表
				LOGGER.warn("json中cell_phone_num值为空");
				falgCellPhoneNum = false;
			} else {
				boolean validatePhone = PhoneNumberUtil.isMobile(cellPhoneNum);
				if (!validatePhone) {
					LOGGER.warn("手机号校验错误:{}", cellPhoneNum);
					falgCellPhoneNum = false;
				}
			}
		} else { // 如果cellPhoneNum没传,则false,不更新loanapplication表
			LOGGER.warn("json中不包含cell_phone_num");
			falgCellPhoneNum = false;
		}
		IdMapper idMapper = idMapperMapper.findidMapperByContId(crid, user.getUserAccount());
		if (idMapper == null) {
			LOGGER.error("权限不足，该机构没有该合同{}，不能进行催收", crid);
			return responseJsonService.creaRespJson(false, "1010", null, null, null, null);
		}
		String sinoid = idMapper.getSinoid();
		ContractAcceptDetail contractAcceptDetail = contractAcceptDetailMapper.findContOfOverdure(sinoid);
		if (contractAcceptDetail != null) {
			// 得到所有的OverdueStatus对象
			List<OverdueStatus> overdueStatusList = overdueStatusMapper.findOverdueListBySinoid(sinoid);

			if (CollectionUtils.isNotEmpty(overdueStatusList)) {
				// 1.更新表contract_accept_detail(合同同意详情表)
				// 修改债权状态
				if (MddValidator.findMdd(overdue_status, "81", "82", "83", "84")) {
					List<Blacklist> blacklists = blacklistMapper.findBlackBySinocardidAndAccount(sinoCardid,
							user.getUserAccount());
					if (CollectionUtils.isEmpty(blacklists)) {
						LOGGER.warn("该信息主体{}在本机构没有黑名单", sinoCardid);
					} else {
						for (Blacklist blacklist : blacklists) {
							blacklist.setOverdueStatus(overdue_status);
							blacklist.setIshide("1");
							blacklist.setHideTime(date);
							blacklistMapper.updateByPrimaryKey(blacklist);
						}
						LOGGER.info("对该信息主体{}洗白黑名单成功", sinoCardid);
					}
				}
				if ("32".equals(overdue_status) || "83".equals(overdue_status)) { // 处置状态32:恢复正常
					contractAcceptDetail.setContractStatus("1"); // 债权状态1:正常
				} else if ("21".equals(overdue_status) || "84".equals(overdue_status)) { // 处置状态21:贷款结清
					contractAcceptDetail.setContractStatus("2"); // 债权状态2:结清
				} else if ("35".equals(overdue_status) || "82".equals(overdue_status)) { // 处置状态35:核销
					contractAcceptDetail.setContractStatus("5"); // 债权状态3:核销
				} else if ("33".equals(overdue_status) || "81".equals(overdue_status)) { // 处置状态33:逾期已结清
					contractAcceptDetail.setContractStatus("6"); // 债权状态6:逾期已结清
				}
				contractAcceptDetailMapper.updateByPrimaryKeySelective(contractAcceptDetail);

				// 2.更新表loan_application和id_mapper
				if (falgCellPhoneNum) {
					LoanApplication loanApplication = loanApplicationMapper.selectByPrimaryKey(sinoid);
					if (loanApplication != null) {
						loanApplication.setCellPhoneNum(cellPhoneNum);
						loanApplicationMapper.updateByPrimaryKey(loanApplication);
					}
					idMapper.setCellPhoneNum(cellPhoneNum);
				}

				// 获得催收次数最多的一次的催收次数(colSn)
				String colSn = overdueStatusList.get(0).getColSn();

				// 3.向表overdue_status(催收表)中插入数据
				OverdueStatus overdueStatus = new OverdueStatus();
				overdueStatus.setSinoid(sinoid);
				overdueStatus.setColSn(String.valueOf(Integer.parseInt(colSn) + 1));
				overdueStatus.setPaymentLevel(Integer.valueOf(overdue_duration));
				overdueStatus.setOverdueStartTime(DateUtils.parseDate(overdue_start_time));
				overdueStatus.setOverdueReason(overdue_reason);
				overdueStatus.setOverdueStatusMark(overdue_status);
				overdueStatus.setSinotime(date);
				overdueStatusMapper.insertSelective(overdueStatus);

				// 4.更新表id_mapper(id映射表)
				idMapper.setCrStatus(overdue_status); // 债权流转过程状态(逾期状态)
				idMapperMapper.updateByPrimaryKeySelective(idMapper);

				// 5.生成报告
				searchService.insSearchReport(reportId, user, sinoid, "3", date, sinoCardid, date);
				if ("1".equals(isgetreport)) {
					String report = reportService.getReport(reportId, sinoCardid, user);
					result = responseJsonService.creaRespJson(true, null, report, null, null, reportId);
				} else {
					LOGGER.warn("该机构不要报告");
					result = responseJsonService.creaRespJson(true, null, null, null, null, null);
				}

			} else {
				LOGGER.error("该合同{}没有逾期行为不能进行催收", crid);
				result = responseJsonService.creaRespJson(false, "1011", null, null, null, null);
			}
		} else {
			LOGGER.error("该合同{}在合同表中不存在或者没有逾期的合同不能进行催收", crid);
			result = responseJsonService.creaRespJson(false, "1012", null, null, null, null);
		}

		return result;
	}

}
