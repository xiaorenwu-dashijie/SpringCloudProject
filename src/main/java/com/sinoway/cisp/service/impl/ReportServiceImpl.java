package com.sinoway.cisp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.sinoway.cisp.dao.LoanApplicationMapper;
import com.sinoway.cisp.dao.ReportMapper;
//import com.sinoway.cisp.dao.RoleAuthMapper;
import com.sinoway.cisp.dao.SearchDetailMapper;
import com.sinoway.cisp.dao.SinoBodyMapper;
import com.sinoway.cisp.entitys.ApplyDetail;
import com.sinoway.cisp.entitys.Authentication;
import com.sinoway.cisp.entitys.BlackListVo;
import com.sinoway.cisp.entitys.CommonInfoVo;
import com.sinoway.cisp.entitys.Dissent;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.SearchDetail;
import com.sinoway.cisp.entitys.SinoBody;
import com.sinoway.cisp.entitys.TagRepository;
import com.sinoway.cisp.entitys.TransactionsDetail;
import com.sinoway.cisp.entitys.TwoYearSearchDetail;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.BlackListReportService;
import com.sinoway.cisp.service.CommonInfoService;
import com.sinoway.cisp.service.ReportDetailService;
import com.sinoway.cisp.service.ReportService;
import com.sinoway.cisp.service.TagRepositoryService;
import com.sinoway.cisp.utils.Base64Utils;
import com.sinoway.cisp.utils.DateUtils;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

	@Autowired
	private ReportDetailService reportDetailService;
	@Autowired
	private CommonInfoService commonInfoService;
	@Autowired
	private BlackListReportService blackListReportService;
	@Autowired
	private TagRepositoryService tagRepositoryService;
	@Autowired
	private LoanApplicationMapper loanApplicationMapper;
	@Autowired
	private SearchDetailMapper searchDetailMapper;
	// @Autowired
	// private RoleAuthMapper roleAuthMapper;
	@Autowired
	private SinoBodyMapper sinoBodyMapper;
	@Autowired
	private ReportMapper reportMapper;

	@Override
	public String getReport(String reportid, String sinoCardid, User user) throws Exception {
		SinoBody sinoBody = sinoBodyMapper.selectByPrimaryKey(sinoCardid);
		String name = sinoBody.getName();
		String cardid = sinoBody.getCardid();

		SearchDetail searchDetail = searchDetailMapper.selectByPrimaryKey(reportid);
		// String serviceCode = searchDetail.getServiceCode();

		// 组装报告的map
		Map<String, Object> map = new LinkedHashMap<>();

		// 1.报告查询时间
		String request_time = DateUtils.dateToStr(new Date());
		map.put("request_time", request_time);

		// 2.报告编号
		if (!reportid.isEmpty()) {
			String[] split = reportid.split("-");
			String instiCode2 = split[2];
			// 给机构代码加密
			String encode = Base64Utils.encode(instiCode2);
			reportid = split[0] + "-" + split[1] + "-" + encode + "-" + split[3] + "-" + split[4];
			map.put("report_id", reportid.replace("SINOWAY", "SW"));
		} else {
			LOGGER.warn("没有报告编号");
		}

		// 3.个人属性信息
		String edu = "9";
		LoanApplication loanApplication = loanApplicationMapper.selectByPrimaryKey(searchDetail.getSinoid());
		if (loanApplication != null) {
			edu = loanApplication.getEdu();
		} else {
			edu = loanApplicationMapper.findEduBySinoCardid(sinoCardid);
		}
		if (StringUtils.isEmpty(edu)) {
			edu = "9";
		}
		Map<String, Object> personal_info = new LinkedHashMap<>();

		personal_info.put("name", name);
		personal_info.put("cardid", cardid);
		personal_info.put("edu", edu);
		personal_info.put("sinocardid", "***");
		map.put("personal_info", personal_info);

		// 4.认证信息
		Authentication authentication = new Authentication("3", "3", "3", "3", "3", "3");

		/*String funCodeFormat = user.getFunCodeFormat();
		boolean identityFlag = false;
		boolean eduFlag = false;
		boolean judicialFlag = false;
		if (!StringUtils.isBlank(funCodeFormat)) {
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
			if (authSet.contains(Parameters.IdentityAuth)) {
				identityFlag = true;
			} else {
				identityFlag = false;
			}
			if (authSet.contains(Parameters.EduAuth)) {
				eduFlag = true;
			} else {
				eduFlag = false;
			}
			if (authSet.contains(Parameters.JudicialAuth)) {
				judicialFlag = true;
			} else {
				judicialFlag = false;
			}
		} else {
			LOGGER.info("用户{}，没有赋予任何角色", user.getUserAccount());
		}
		// 4.1身份认证
		if (identityFlag) {
			String identiyAuthResult = reportDetailService.getIdentityAuth(cardid, name);
			if (StringUtils.isNotEmpty(serviceCode)) {
				if ("0".equals(identiyAuthResult) || "1".equals(identiyAuthResult)) {
					serviceCode = serviceCode + ",11";// 后面的1代表查中，及调用成功
				} else {
					serviceCode = serviceCode + ",10";// 后面的0代表未查中，及调用不成功
				}
			} else {
				if ("0".equals(identiyAuthResult) || "1".equals(identiyAuthResult)) {
					serviceCode = "11";
				} else {
					serviceCode = "10";
				}
			}
			authentication.setIdentity(identiyAuthResult);
		} else {
			LOGGER.info("该用户{}没有身份认证权限" + Parameters.IdentityAuth, user.getUserAccount());
		}
		// 4.2学历认证
		if (eduFlag) {
			String eduAuthResult = reportDetailService.getEduAuth(cardid, name);
			if (StringUtils.isNotEmpty(serviceCode)) {
				if ("0".equals(eduAuthResult) || "1".equals(eduAuthResult)) {
					serviceCode = serviceCode + ",21";// 后面的1代表查中，及调用成功
				} else {
					serviceCode = serviceCode + ",20";// 后面的0代表未查中，及调用不成功
				}
			} else {
				if ("0".equals(eduAuthResult) || "1".equals(eduAuthResult)) {
					serviceCode = "21";
				} else {
					serviceCode = "20";
				}
			}
			authentication.setEducation(eduAuthResult);
		} else {
			LOGGER.info("该用户{}没有学历认证权限" + Parameters.EduAuth, user.getUserAccount());
		}
		// 4.3司法认证
		if (judicialFlag) {

			List<String> judicialAuthResult = reportDetailService.getJudicialAuth(cardid, name);
			authentication.setShixin(judicialAuthResult.get(0));
			authentication.setPanjue(judicialAuthResult.get(1));
			authentication.setZhixing(judicialAuthResult.get(2));
			boolean ischecked = false;// 未查中
			for (String string : judicialAuthResult) {
				if ("1".equals(string)) {
					ischecked = true;
					break;
				}
			}
			if (StringUtils.isNotEmpty(serviceCode)) {
				if (ischecked) {
					serviceCode = serviceCode + ",31";
				} else {
					serviceCode = serviceCode + ",30";
				}
			} else {
				if (ischecked) {
					serviceCode = "31";
				} else {
					serviceCode = "30";
				}
			}
		} else {
			LOGGER.info("该用户{}没有司法认证权限" + Parameters.JudicialAuth, user.getUserAccount());
		}*/
		map.put("authentication", authentication);
		// searchDetail.setServiceCode(serviceCode);
		// searchDetailMapper.updateByPrimaryKey(searchDetail);

		// 5.交易记录统计
		List<String> findSinoidByNormalOutSettle = reportMapper.findSinoidByNormalOutSettle(sinoCardid);// 正常还款记录-未清
		int unpaid = getCount(findSinoidByNormalOutSettle, "2");
		List<String> findSinoidByNormalSettle = reportMapper.findSinoidByNormalSettle(sinoCardid);// 正常还款记录-结清
		int paid = getCount(findSinoidByNormalSettle, "2");
		List<String> findSinoidByAbnormalOutSettle = reportMapper.findSinoidByAbnormalOutSettle(sinoCardid);// 异常还款记录-未清
		int un_unpaid = getCount(findSinoidByAbnormalOutSettle, "2");
		List<String> findSinoidByAbnormalSettle = reportMapper.findSinoidByAbnormalSettle(sinoCardid);// 异常还款记录-结清
		int un_paid = getCount(findSinoidByAbnormalSettle, "2");
		List<String> findSinoidByWaitCheck = reportMapper.findSinoidByWaitCheck(sinoCardid);// 待审
		int unreviewed = getCount(findSinoidByWaitCheck, "1");
		List<String> findSinoidByPassCheck = reportMapper.findSinoidByPassCheck(sinoCardid);// 通过
		int reviewed = getCount(findSinoidByPassCheck, "1");
		List<String> findSinoidByUnpassCheck = reportMapper.findSinoidByUnpassCheck(sinoCardid);// 拒绝
		int refuse = getCount(findSinoidByUnpassCheck, "1");
		List<String> findSinoidByCancel = reportMapper.findSinoidByCancel(sinoCardid);// 取消
		int cancel = getCount(findSinoidByCancel, "1");
		List<String> findSinoidBySear = reportMapper.findSinoidBySear(sinoCardid);// 近两年查询记录数
		int twoYearsCount = getCount(findSinoidBySear, "11");
		Map<String, Object> normal_pay1 = new LinkedHashMap<>();
		normal_pay1.put("paid", paid);
		normal_pay1.put("unpaid", unpaid);
		Map<String, Object> unnormal_pay = new LinkedHashMap<>();
		unnormal_pay.put("paid", un_paid);
		unnormal_pay.put("unpaid", un_unpaid);
		Map<String, Object> last_6Month_apply_history = new LinkedHashMap<>();
		last_6Month_apply_history.put("unreviewed", unreviewed);
		last_6Month_apply_history.put("reviewed", reviewed);
		last_6Month_apply_history.put("refuse", refuse);
		last_6Month_apply_history.put("cancel", cancel);

		Map<String, Object> transactions_count = new LinkedHashMap<>();
		transactions_count.put("normal_pay", normal_pay1);
		transactions_count.put("last_6Month_apply_history", last_6Month_apply_history);
		transactions_count.put("unnormal_pay", unnormal_pay);
		transactions_count.put("last_2years_history", twoYearsCount);
		map.put("transactions_count", transactions_count);

		// 6.最近6个月贷款申请记录明细，按照申请时间算并排序
		List<ApplyDetail> apply_history = new ArrayList<>();
		apply_history = reportDetailService.applyHistoryDetail(sinoCardid, user);
		if (CollectionUtils.isEmpty(apply_history)) {
			LOGGER.info("最近6个月该信息主体{}没有贷款申请记录", sinoCardid);
		}
		map.put("apply_history", apply_history);

		// 7.近两年交易记录明细，按照合同开始时间算并排序
		List<TransactionsDetail> transactions = new ArrayList<>();
		transactions = reportDetailService.transactionsHistoryDetail(sinoCardid, user);
		if (CollectionUtils.isEmpty(transactions)) {
			LOGGER.info("该信息主体{}没有交易记录", sinoCardid);
		}
		map.put("transactions", transactions);

		// 8.最近两年内查询记录统计，按照查询时间算并排序
		List<TwoYearSearchDetail> last_2years_history_detail = new ArrayList<>();
		last_2years_history_detail = reportDetailService.Last2yearsSearchDetail(sinoCardid, user);
		if (CollectionUtils.isEmpty(last_2years_history_detail)) {
			LOGGER.info("近两年内该信息主体{}没有查询记录明细", sinoCardid);
		}
		map.put("last_2years_history", last_2years_history_detail);

		// 9.严重失信行为记录，（5年）按照报送时间算并排序
		List<BlackListVo> discredit = new ArrayList<>();
		discredit = blackListReportService.getBlackListReport(sinoCardid, user);
		if (CollectionUtils.isEmpty(discredit)) {
			LOGGER.info("该信息主体{}没有严重失信记录", sinoCardid);
		}
		map.put("discredit", discredit);

		// 10.公共信用信息
		List<CommonInfoVo> commonInfoVos = commonInfoService.findInfoListBySinocardid(sinoCardid);
		map.put("common_info", commonInfoVos);

		// 11.本人异议申诉明细
		List<Dissent> dissent = new ArrayList<>();
		dissent = reportDetailService.getDissents(sinoCardid);
		map.put("dissent", dissent);

		Gson gson = new Gson();
		String report = gson.toJson(map);

		return report;
	}

	/**
	 * 获取未被隐藏的记录数
	 * 
	 * @param sinoidList
	 * @param table_code
	 * @return
	 */
	private int getCount(List<String> sinoidList, String table_code) {
		int count = sinoidList.size();
		if (count > 0) {
			List<TagRepository> tagRepositories = tagRepositoryService.findTagBySinoidList(sinoidList);
			for (TagRepository tagRepository : tagRepositories) {
				String tagCode = tagRepository.getTagCode();
				String tableName = tagRepository.getTableName();
				if ("020201".equals(tagCode) && StringUtils.isEmpty(tableName)) {
					count = count - 1;
					LOGGER.info("这条债权相关数据被隐藏");
				}
				if ("030102".equals(tagCode) && table_code.equals(tableName)) {
					count = count - 1;
					LOGGER.info("这条记录被隐藏");
				}
			}
		}
		return count;
	}

}
