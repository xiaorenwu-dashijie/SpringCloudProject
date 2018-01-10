package com.sinoway.cisp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.DissentDetailMapper;
import com.sinoway.cisp.dao.InstiDetailMapper;
import com.sinoway.cisp.dao.OverdueStatusMapper;
import com.sinoway.cisp.dao.PaidMonthlyAmountMapper;
import com.sinoway.cisp.dao.ReportMapper;
import com.sinoway.cisp.dao.SearchDetailMapper;
import com.sinoway.cisp.dao.TagRepositoryMapper;
import com.sinoway.cisp.entitys.ApplyDetail;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.Dissent;
import com.sinoway.cisp.entitys.DissentDetail;
import com.sinoway.cisp.entitys.InstiDetail;
import com.sinoway.cisp.entitys.LoanApplication;
import com.sinoway.cisp.entitys.OverdueDetail;
import com.sinoway.cisp.entitys.OverdueStatus;
import com.sinoway.cisp.entitys.PaidMonthlyAmount;
import com.sinoway.cisp.entitys.SearchDetail;
import com.sinoway.cisp.entitys.TagRepository;
import com.sinoway.cisp.entitys.TransactionsDetail;
import com.sinoway.cisp.entitys.TwoYearSearchDetail;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.ReportDetailService;
import com.sinoway.cisp.utils.DateUtils;

@Service
@Transactional
public class ReportDetailServiceImpl implements ReportDetailService {

	private static Logger logger = LoggerFactory.getLogger(ReportDetailServiceImpl.class);

	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private OverdueStatusMapper overdueStatusMapper;
	@Autowired
	private SearchDetailMapper searchDetailMapper;
	@Autowired
	private DissentDetailMapper dissentDetailMapper;
	@Autowired
	private InstiDetailMapper instiDetailMapper;
	@Autowired
	private PaidMonthlyAmountMapper paidMonthlyAmountMapper;
	@Autowired
	private TagRepositoryMapper tagRepositoryMapper;

	@Value("${service_identity_url}")
	private String service_identity_url;
	@Value("${service_judicial_url}")
	private String service_judicial_url;

	@Override
	public List<ApplyDetail> applyHistoryDetail(String sinoCardid, User user) {
		List<ApplyDetail> list = new ArrayList<>();
		List<LoanApplication> listAllApplication = reportMapper.selectLoanAppOfSixMonth(sinoCardid);
		for (LoanApplication loanApplication : listAllApplication) {
			String loansinoid = loanApplication.getSinoid();
			Date reqestTime = loanApplication.getRequestTime();
			String apply_time = DateUtils.dateToStr(reqestTime);
			String apply_location = loanApplication.getRequestLocation();
			String loan_type = loanApplication.getRequestType();
			double apply_money = loanApplication.getRequestMoney().doubleValue();
			String apply_result = loanApplication.getRequestResult();
			String member_type = getInstiType(user);

			List<TagRepository> tagRepositories = tagRepositoryMapper.findTagsBySinoid(loansinoid);
			String comment = null;
			if (CollectionUtils.isEmpty(tagRepositories)) {
				comment = getRemarker(user, loansinoid);
				ApplyDetail applydetail = new ApplyDetail(apply_time, member_type, apply_location, loan_type,
						apply_money, apply_result, comment);
				list.add(applydetail);
			} else {
				boolean flag = isHideRecord(tagRepositories, "1");
				if (!flag) {
					for (TagRepository tagRepository : tagRepositories) {
						String tagCode = tagRepository.getTagCode();
						if ("020102".equals(tagCode)) {
							comment = "6";
						} else if ("020101".equals(tagCode)) {
							comment = "5";
						} else if ("030101".equals(tagCode)) {
							apply_result = "4";
						} else {
							comment = getRemarker(user, loansinoid);
						}
					}
					ApplyDetail applydetail = new ApplyDetail(apply_time, member_type, apply_location, loan_type,
							apply_money, apply_result, comment);
					list.add(applydetail);
				}
			}
		}
		return list;
	}

	@Override
	public List<TransactionsDetail> transactionsHistoryDetail(String sinoCardid, User user) {
		List<TransactionsDetail> transactionsDetails = new ArrayList<>();
		// 拼装返回对象的数据
		List<ContractAcceptDetail> contractAcceptDetails = contractAcceptDetailMapper.selectBySinoCardid(sinoCardid);
		for (ContractAcceptDetail contractAcceptDetail : contractAcceptDetails) {
			double contractSum = 0;
			if (contractAcceptDetail.getContractSum() != null) {
				contractSum = contractAcceptDetail.getContractSum().doubleValue();
			}
			String startTime = null;
			if (contractAcceptDetail.getStartTime() != null) {
				startTime = DateUtils.dateToStr(contractAcceptDetail.getStartTime());
			}
			String stopTime = null;
			if (contractAcceptDetail.getStopTime() != null) {
				stopTime = DateUtils.dateToStr(contractAcceptDetail.getStopTime());
			}
			String contractType = contractAcceptDetail.getContractType();
			String guaraType = contractAcceptDetail.getGuaraType();
			String payPeriod = contractAcceptDetail.getPayPeriod();
			String payLocation = contractAcceptDetail.getPayLocation();
			String contractStatus = contractAcceptDetail.getContractStatus();
			String contractSinoid = contractAcceptDetail.getSinoid();
			TransactionsDetail transactionsDetail = new TransactionsDetail();
			transactionsDetail.setLoan_money(contractSum);
			transactionsDetail.setLoan_start_time(startTime);
			transactionsDetail.setLoan_end_time(stopTime);
			transactionsDetail.setLoan_type(contractType);
			transactionsDetail.setLoan_guarantee(guaraType);
			transactionsDetail.setPay_period(payPeriod);
			transactionsDetail.setLoan_location(payLocation);
			transactionsDetail.setLoan_status(contractStatus);
			// 正常、展期、逾期
			List<OverdueDetail> overdueDetailList = new ArrayList<>();
			List<OverdueStatus> overdueStatusList = overdueStatusMapper.findOverdueListBySinoid(contractSinoid);
			if (!CollectionUtils.isEmpty(overdueStatusList)) {
				for (OverdueStatus overdueStatus : overdueStatusList) {
					String done_time = DateUtils.dateToStr(overdueStatus.getSinotime());
					String overdue_time = DateUtils.dateToStr(overdueStatus.getOverdueStartTime());
					String overdue_level = overdueStatus.getPaymentLevel().toString();
					String overdue_reason = overdueStatus.getOverdueReason();
					String now_status = overdueStatus.getOverdueStatusMark();
					OverdueDetail overdueDetail = new OverdueDetail(done_time, overdue_time, overdue_level, overdue_reason, now_status);
					overdueDetailList.add(overdueDetail);
				}
			}
			String paidMonthlyTimeStringList = getStringHis(contractAcceptDetail);
			transactionsDetail.setPaid_history(paidMonthlyTimeStringList);
			transactionsDetail.setOverdueStatusList(overdueDetailList);

			List<TagRepository> tagRepositories = tagRepositoryMapper.findTagsBySinoid(contractSinoid);
			String comment = null;
			if (CollectionUtils.isEmpty(tagRepositories)) {
				comment = getRemarker(user, contractSinoid);
				transactionsDetail.setComment(comment);
				transactionsDetails.add(transactionsDetail);
			} else {
				boolean flag = isHideRecord(tagRepositories, "2");
				if (!flag) {
					for (TagRepository tagRepository : tagRepositories) {
						String tagCode = tagRepository.getTagCode();
						if ("020102".equals(tagCode)) {
							comment = "6";
						} else if ("020101".equals(tagCode)) {
							comment = "5";
						} else {
							comment = getRemarker(user, contractSinoid);
						}
					}
					transactionsDetail.setComment(comment);
					transactionsDetails.add(transactionsDetail);
				}
			}
		}
		return transactionsDetails;
	}

	@Override
	public List<TwoYearSearchDetail> Last2yearsSearchDetail(String sinoCardid, User user) {
		List<SearchDetail> searchDetails = searchDetailMapper.findSearListBySinocardid(sinoCardid);
		List<TwoYearSearchDetail> twoYearSearchDetails = new ArrayList<>();
		for (SearchDetail searchDetail : searchDetails) {
			String query_time = DateUtils.dateToStr(searchDetail.getReqTime());
			String sinoid = searchDetail.getSinoid();
			String member_type = getInstiType(user);
			String query_type = searchDetail.getReqReason();
			String comment = null;
			List<TagRepository> tagRepositories = tagRepositoryMapper.findTagsBySinoid(sinoid);
			if (CollectionUtils.isEmpty(tagRepositories)) {
				comment = getRemarker(user, sinoid);
				TwoYearSearchDetail twoYearSearchDetail = new TwoYearSearchDetail(query_time, member_type, query_type,
						comment);
				twoYearSearchDetails.add(twoYearSearchDetail);
			} else {
				boolean flag = isHideRecord(tagRepositories, "11");
				if (!flag) {
					for (TagRepository tagRepository : tagRepositories) {
						String tagCode = tagRepository.getTagCode();
						if ("020102".equals(tagCode)) {
							comment = "6";
						} else if ("020101".equals(tagCode)) {
							comment = "5";
						} else {
							comment = getRemarker(user, sinoid);
						}
					}
					TwoYearSearchDetail twoYearSearchDetail = new TwoYearSearchDetail(query_time, member_type,
							query_type, comment);
					twoYearSearchDetails.add(twoYearSearchDetail);
				}
			}
		}
		return twoYearSearchDetails;
	}

	@Override
	public List<Dissent> getDissents(String sinoCardid) {
		List<DissentDetail> dissentDetails = dissentDetailMapper.selectDissentListBySinocardid(sinoCardid);
		// 传输的json
		List<Dissent> dissents = new ArrayList<>();
		for (DissentDetail dissentDetail : dissentDetails) {
			String dissent_id = dissentDetail.getDissentId();
			String appeal_time = DateUtils.dateToStr(dissentDetail.getAppealTime());
			String appeal_detail = dissentDetail.getAppealDetail();
			String status = dissentDetail.getStatus();
			Dissent dissent = new Dissent(dissent_id, appeal_time, appeal_detail, status);
			dissents.add(dissent);
		}
		return dissents;
	}

	/**
	 * 1：本机构、2：本机构-存量、3：--、4：存量
	 * 
	 * @param user
	 * @param sinoid
	 * @return
	 */
	public String getRemarker(User user, String sinoid) {
		String comment = null;
		String[] split = sinoid.split("-");
		String opCode = split[1];
		String instiCode = split[2];
		if (user.getInstiCode().equals(instiCode) && "S".equals(opCode)) {
			comment = "1";
		} else if (user.getInstiCode().equals(instiCode) && "H".equals(opCode)) {
			comment = "2";
		} else if (!user.getInstiCode().equals(instiCode) && "S".equals(opCode)) {
			comment = "3";
		} else {
			comment = "4";
		}
		return comment;
	}

	/**
	 * 返回会员类型
	 * 
	 * @param user
	 * @return
	 */
	public String getInstiType(User user) {
		String code = user.getInstiCode();
		InstiDetail instiDetail = instiDetailMapper.selectByPrimaryKey(code);
		String institype = instiDetail.getInstiType();
		// 返回会员类型的字典代码
		return institype;
	}

	/**
	 * 通过sinoid获取这笔贷款的所有还款时间，并拼接成字符串返回
	 * 
	 * @param sinoid
	 * @return
	 */
	private String getStringHis(ContractAcceptDetail contractAcceptDetail) {
		List<PaidMonthlyAmount> paidMonthlyAmounts = paidMonthlyAmountMapper
				.selectByPrimaryKey(contractAcceptDetail.getSinoid());
		if (CollectionUtils.isNotEmpty(paidMonthlyAmounts)) {
			String his = "";
			for (PaidMonthlyAmount paidMonthlyAmount : paidMonthlyAmounts) {
				if (paidMonthlyAmount.getPaidTime()!=null) {
					his = his + DateUtils.dateToStr(paidMonthlyAmount.getPaidTime()) + ",";
				}
			}
			if (-1 != his.toString().lastIndexOf(",")) {
				his = his.substring(0, his.toString().length() - 1);
			}
			if ("2".equals(contractAcceptDetail.getContractStatus())) {
				his = his + "," + DateUtils.dateToStr(contractAcceptDetail.getSettleTime());
			}
			return his;
		} else {
			return "--";
		}
	}

	/**
	 * 是否隐藏该记录
	 * 
	 * @param tagRepositories
	 * @return
	 */
	private boolean isHideRecord(List<TagRepository> tagRepositories, String table_code) {
		boolean flag = false;
		for (TagRepository tagRepository : tagRepositories) {
			String tagCode = tagRepository.getTagCode();
			String tableName = tagRepository.getTableName();
			if ("020201".equals(tagCode) && StringUtils.isEmpty(tableName)) {
				flag = true;
				logger.info("这条债权被隐藏");
				break;
			}
			if ("030102".equals(tagCode) && table_code.equals(tableName)) {
				flag = true;
				logger.info("这条记录被隐藏");
				break;
			}
		}
		return flag;
	}

	@Override
	public String getIdentityAuth(String cardid, String name) {
		String identityAuthResult = "3";
		try {
			/*
			 * Map<String, String> params = new HashMap<>(); params.put("name",
			 * name); params.put("cardId", cardid); params.put("cellPhoneNum",
			 * "");
			 * 
			 * PageFetcher pf = new PageFetcher(); String responseJson =
			 * pf.dopost(service_identity_url, params); JSONObject jsonObject =
			 * new JSONObject(responseJson); String code = (String)
			 * jsonObject.get("code"); //0认证通过1认证不通过2认证失败3未调用 if
			 * ("C0".equals(code)) { String data = (String)
			 * jsonObject.get("data"); if ("0".equals(data) || "1".equals(data))
			 * { identityAuthResult = data; }else { identityAuthResult = "2"; }
			 * } else if ("C1".equals(code)) { identityAuthResult = "2";
			 * logger.info("调用身份认证接口异常"); } else { identityAuthResult = "2"; }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("身份认证接口调用异常{}", e);
		}
		return identityAuthResult;
	}

	// 截取数字
	public String getNumbers(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}

	public List<String> getJudicialAuth(String cardid, String name) {
		List<String> judicialList = new ArrayList<>();
		judicialList.add("3");
		judicialList.add("3");
		judicialList.add("3");
		/*
		 * try { Map<String, String> params = new HashMap<>();
		 * params.put("cardId", cardid); params.put("name", name); PageFetcher
		 * pf = new PageFetcher(); String responseJson =
		 * pf.dopost(service_judicial_url, params); // 解析json try { JSONObject
		 * job = new JSONObject(responseJson); String code =
		 * job.getString("code"); // 现在没有调用司法信息接口 if ("200".equals(code)) { Gson
		 * gson = new Gson(); JudicialInfo judicialInfo =
		 * gson.fromJson(responseJson, JudicialInfo.class);
		 * judicialList.add(judicialInfo.getPanjue());
		 * judicialList.add(judicialInfo.getPanjue());
		 * judicialList.add(judicialInfo.getZhixing()); } else {
		 * judicialList.add("3"); judicialList.add("3"); judicialList.add("3");
		 * } } catch (JSONException e) { e.printStackTrace(); } } catch
		 * (Exception e) { e.printStackTrace(); logger.info("司法认证接口调用异常{}", e);
		 * judicialList.add("2"); judicialList.add("2"); judicialList.add("2");
		 * }
		 */
		return judicialList;
	}

	@Override
	public String getEduAuth(String cardid, String name) {
		String eduAuth = "2";
		try {
			eduAuth = "3";
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("学历认证接口调用异常{}", e);
		}
		return eduAuth;
	}

}
