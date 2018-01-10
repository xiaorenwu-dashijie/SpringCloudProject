package com.sinoway.cisp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.BlacklistMapper;
import com.sinoway.cisp.dao.ContractAcceptDetailMapper;
import com.sinoway.cisp.dao.IdMapperMapper;
import com.sinoway.cisp.dao.InstiDetailMapper;
import com.sinoway.cisp.dao.OverdueStatusMapper;
import com.sinoway.cisp.dao.SearchDetailMapper;
import com.sinoway.cisp.dao.SinoBodyMapper;
import com.sinoway.cisp.dao.UserMapper;
import com.sinoway.cisp.entitys.BlackDetailList;
import com.sinoway.cisp.entitys.Blacklist;
import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.OverRepaymentDetail;
import com.sinoway.cisp.entitys.OverdueStatus;
import com.sinoway.cisp.entitys.PersonReport;
import com.sinoway.cisp.entitys.RepaymentDetailList;
import com.sinoway.cisp.entitys.SearchDetail;
import com.sinoway.cisp.entitys.SinoBody;
import com.sinoway.cisp.entitys.TwoYearsSearchDetail;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.PersonReportService;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.ReportNumberUtil;

@Service
@Transactional
public class PersonReportServiceImpl implements PersonReportService {
	private static Logger LOGGER = LoggerFactory.getLogger(PersonReportServiceImpl.class);
	@Autowired
	private ContractAcceptDetailMapper contractAcceptDetailMapper;
	@Autowired
	private OverdueStatusMapper overdueStatusMapper;
	@Autowired
	private IdMapperMapper idMapperMapper;
	@Autowired
	private BlacklistMapper blacklistMapper;
	@Autowired
	private SearchDetailMapper searchDetailMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SinoBodyMapper sinoBodyMapper;
	@Autowired
	private InstiDetailMapper instiDetailMapper;

	@Override
	public PersonReport getPersonReport(String name, String cardid, String cellPhoneNum, User user) throws Exception {
		SinoBody sinoBody = sinoBodyMapper.findSinobodyByCardid(name, cardid);
		String sinoCardid = sinoBody.getSinoCardid();
		Date today = new Date();
		// 日期号
		String todaydate = DateUtils.formatDate(today);
		String searchdate = DateUtils.dateToStr(today);
		new ReportNumberUtil();
		String finalnumber = ReportNumberUtil.createReportNum();
		String personReportId = "SINOWAY-R-" + todaydate + "-" + finalnumber;
		// 根据传入信息查到的sinoid
		List<String> sinoidList = idMapperMapper.findSinoidsBySinocardid(sinoCardid);
		List<Blacklist> blackList = blacklistMapper.selectBlacListBySinocardid(sinoCardid);
		if (CollectionUtils.isEmpty(blackList)&&CollectionUtils.isEmpty(sinoidList)) {
			LOGGER.info("sinoCardid:{},该信息主体,没有查中", sinoCardid);
			// 留存
			insSearchReport(personReportId, user, personReportId, "13", today, sinoCardid, "90", today);
			// 近两年的查询
			List<SearchDetail> twoyearsSearchNum = searchDetailMapper.findPerSearListBySinocardid(sinoCardid);
			List<TwoYearsSearchDetail> twoYearsSearchDetailList = new ArrayList<TwoYearsSearchDetail>();

			for (int i = 0; i < twoyearsSearchNum.size(); i++) {
				String date1 = DateUtils.dateToStr(twoyearsSearchNum.get(i).getReqTime());
				String date2 = DateUtils.dateToStr(twoyearsSearchNum.get(i).getSinotime());

				TwoYearsSearchDetail element = new TwoYearsSearchDetail();
				element.setReqTime(date1);
				element.setSinotime(date2);
				element.setCardid(sinoBody.getCardid());
				element.setCellPhoneNum(twoyearsSearchNum.get(i).getCellPhoneNum());
				element.setName(sinoBody.getName());
				element.setReportId(twoyearsSearchNum.get(i).getReportId());
				element.setReqReason(twoyearsSearchNum.get(i).getReqReason());
				element.setServiceCode(twoyearsSearchNum.get(i).getServiceCode());
				element.setSinoid(twoyearsSearchNum.get(i).getSinoid());
				element.setUserAccount(twoyearsSearchNum.get(i).getUserAccount());
				element.setResultAdd(twoyearsSearchNum.get(i).getResultAdd());
				twoYearsSearchDetailList.add(i, element);
			}

			PersonReport personReport = new PersonReport();
			personReport.setSearchDate(searchdate);
			personReport.setPersonReportId(personReportId);
			personReport.setName(name);
			personReport.setCardid(cardid);
			personReport.setSinoCardid(sinoCardid);
			personReport.setCellPhoneNum(cellPhoneNum);
			personReport.setCreditLoanNum(0);
			personReport.setNormalCreditLoan(0);
			personReport.setOverCreditLoan(0);
			personReport.setMortgageLoanNum(0);
			personReport.setNormalMortgageLoan(0);
			personReport.setOverMortgageLoan(0);
			personReport.setGuaranteeLoanNum(0);
			personReport.setNormarlGuaranteeLoan(0);
			personReport.setOverGuaranteeLoan(0);
			personReport.setOtherLoanNum(0);
			personReport.setNormalOtherLoan(0);
			personReport.setOverOtherLoan(0);
			personReport.setBlackDetailList(null);
			personReport.setRepaymentDetailList(null);
			personReport.setOverRepaymentDetailList(null);
			personReport.setTwoyearsSearchNum(twoYearsSearchDetailList);
			personReport.setPublicCreditInformation(null);
			personReport.setDissentApplyDetail(null);

			return personReport;
		}
		// 逾期表中的sinoid
		// List<String> overLoanList = overdueStatusMapper.selectLoanList();
		// 查询信用贷款类型的信息
		// 求2个list的交集个数
		List<String> creditLoanList = contractAcceptDetailMapper.selectcreditLoanList();
		creditLoanList.retainAll(sinoidList);
		int creditLoanNum = creditLoanList.size();
		// 创建2个LIST 之后分别于同意表 逾期表 进行对比
		List<String> normalCreditLoanList = contractAcceptDetailMapper.selectnormalCreditLoanList();
		// List<String> normalCreditLoanList_copy = normalCreditLoanList;
		normalCreditLoanList.retainAll(sinoidList);
		int normalCreditLoan = normalCreditLoanList.size();

		// normalCreditLoanList_copy.retainAll(overLoanList);
		// int overCreditLoan=normalCreditLoanList_copy.size();
		// 信用贷款逾期装户数.
		List<String> overCreditList = contractAcceptDetailMapper.selectByGuaraType1(sinoidList);
		int overCreditLoan = overCreditList.size();

		// 查询抵押贷款类型的信息
		List<String> mortgageLoanNumList = contractAcceptDetailMapper.selectmortgageLoanNumList();
		mortgageLoanNumList.retainAll(sinoidList);
		int mortgageLoanNum = mortgageLoanNumList.size();

		List<String> normalMortgageLoanList = contractAcceptDetailMapper.selectnormalMortgageLoanList();
		// List<String> normalMortgageLoanList_copy=normalMortgageLoanList;
		normalMortgageLoanList.retainAll(sinoidList);
		int normalMortgageLoan = normalMortgageLoanList.size();

		// normalMortgageLoanList_copy.retainAll(overLoanList);
		// int overMortgageLoan=normalMortgageLoanList_copy.size();
		List<String> overMortgageList = contractAcceptDetailMapper.selectByGuaraType2(sinoidList);
		int overMortgageLoan = overMortgageList.size();

		// 查询担保类型的信息
		List<String> guaranteeLoanNumList = contractAcceptDetailMapper.selectguaranteeLoanNumList();
		guaranteeLoanNumList.retainAll(sinoidList);
		int guaranteeLoanNum = guaranteeLoanNumList.size();

		List<String> normarlGuaranteeLoanList = contractAcceptDetailMapper.selectnormarlGuaranteeLoanList();
		// List<String> normarlGuaranteeLoanList_copy =
		// normarlGuaranteeLoanList;
		normarlGuaranteeLoanList.retainAll(sinoidList);
		int normarlGuaranteeLoan = normarlGuaranteeLoanList.size();

		// normarlGuaranteeLoanList_copy.retainAll(overLoanList);
		// int overGuaranteeLoan=normarlGuaranteeLoanList_copy.size();
		List<String> overGuaranteeList = contractAcceptDetailMapper.selectByGuaraType4(sinoidList);
		int overGuaranteeLoan = overGuaranteeList.size();

		// 查询其他类型的贷款信息
		List<String> otherLoanNumList = contractAcceptDetailMapper.selectotherLoanNumList();
		otherLoanNumList.retainAll(sinoidList);
		int otherLoanNum = otherLoanNumList.size();

		List<String> normalOtherLoanList = contractAcceptDetailMapper.selectnormalOtherLoanList();
		// List<String> normalOtherLoanList_copy = normalOtherLoanList;
		normalOtherLoanList.retainAll(sinoidList);
		int normalOtherLoan = normalOtherLoanList.size();

		// normalOtherLoanList_copy.retainAll(overLoanList);
		// int overOtherLoan=normalOtherLoanList_copy.size();
		List<String> overOtherList = contractAcceptDetailMapper.selectByGuaraTypeOther(sinoidList);
		int overOtherLoan = overOtherList.size();

		// 严重失信账户数
		List<Blacklist> blackNum = blacklistMapper.selectBlacListBySinocardid(sinoCardid);
		List<BlackDetailList> blackDetailList = new ArrayList<BlackDetailList>();
		for (int i = 0; i < blackNum.size(); i++) {
			System.out.println(blackNum.get(i).getHideTime());
			String date1 = DateUtils.dateToStr(blackNum.get(i).getLoanStartTime());
			String date2 = DateUtils.dateToStr(blackNum.get(i).getOverdueStartTime());
			String date3 = DateUtils.dateToStr(blackNum.get(i).getPublicTime());
			// 判断是否为本机构报送
			String userBlackAccount = blackNum.get(i).getUserAccount();
			String instiName = userMapper.selectInstiNameByUserAccount(userBlackAccount);
			blackNum.get(i).setInstiName(instiName);
			// 报送机构
			String sinoid = blackNum.get(i).getSinoid();
			String[] sinoidArray = sinoid.split("-");
			String instiCode = sinoidArray[2];

			String instiName1 = instiDetailMapper.getInstiNameByInstiCode(instiCode);
			if (instiName1 == instiName) {
				blackNum.get(i).setBeizhu("1");//"1"本机构
			} else {
				blackNum.get(i).setBeizhu("2");//"2"本机构-存量
			}
			BlackDetailList element = new BlackDetailList();
			// if (blackNum.get(i).getHideTime()==null) {
			// element.setHideTime(null);
			// }else {
			// element.setHideTime(DateUtils.dateToStr(blackNum.get(i).getHideTime()));
			// }
			element.setLoanStartTime(date1);
			element.setOverdueStartTime(date2);
			element.setPublicTime(date3);
			element.setCardid(sinoBody.getCardid());
			element.setSinoid(blackNum.get(i).getSinoid());
			element.setName(sinoBody.getName());
			element.setReason(blackNum.get(i).getReason());
			element.setEmail(blackNum.get(i).getEmail());
			element.setLoanType(blackNum.get(i).getLoanType());
			// element.setIshide(blackNum.get(i).getIshide());
			element.setLoanGuarantee(blackNum.get(i).getLoanGuarantee());
			element.setLoanLocation(blackNum.get(i).getLoanLocation());
			element.setOverdueDuration(blackNum.get(i).getOverdueDuration());
			element.setOverdueStatus(blackNum.get(i).getOverdueStatus());
			element.setOverdueMoney(blackNum.get(i).getOverdueMoney());
			element.setPersonalAddress(blackNum.get(i).getPersonalAddress());
			element.setPhone(blackNum.get(i).getPhone());
			element.setOverdueTimes(blackNum.get(i).getOverdueTimes());
			element.setEmail(blackNum.get(i).getEmail());
			element.setLiveAddress(blackNum.get(i).getLiveAddress());

			blackDetailList.add(i, element);
		}
		// 正常还款账户明细
		List<ContractAcceptDetail> repaymentDetail = contractAcceptDetailMapper.selectAllBySinoid(sinoidList);
		List<RepaymentDetailList> repaymentDetailList = new ArrayList<RepaymentDetailList>();

		for (int i = 0; i < repaymentDetail.size(); i++) {
			String date1 = DateUtils.dateToStr(repaymentDetail.get(i).getStartTime());
			String date2 = DateUtils.dateToStr(repaymentDetail.get(i).getStopTime());
			String date3 = DateUtils.dateToStr(repaymentDetail.get(i).getSinotime());

			String sinoid = repaymentDetail.get(i).getSinoid();
			String[] sinoidArray = sinoid.split("-");
			String instiCodes = sinoidArray[2];

			int instiCode = Integer.parseInt(instiCodes);

			String instiName = instiDetailMapper.getInstiNameByInstiCode(String.valueOf(instiCode));
			repaymentDetail.get(i).setInstiName(instiName);

			RepaymentDetailList element = new RepaymentDetailList();
			if (repaymentDetail.get(i).getSettleTime() == null) {
				element.setSettleTime(null);
			} else {
				String date4 = DateUtils.dateToStr(repaymentDetail.get(i).getSettleTime());
				element.setSettleTime(date4);
			}

			element.setStartTime(date1);
			element.setStopTime(date2);
			element.setSinotime(date3);

			element.setSinoid(repaymentDetail.get(i).getSinoid());
			element.setContractId(repaymentDetail.get(i).getContractId());
			element.setContractStatus(repaymentDetail.get(i).getContractStatus());
			element.setContractSum(repaymentDetail.get(i).getContractSum());
			element.setContractType(repaymentDetail.get(i).getContractType());
			element.setPayLocation(repaymentDetail.get(i).getPayLocation());
			element.setGuara_Type(repaymentDetail.get(i).getGuaraType());
			element.setInstiName(instiName);
			element.setPayPeriod(repaymentDetail.get(i).getPayPeriod());
			repaymentDetailList.add(i, element);
		}
		// 发生过逾期的账户明细
		List<OverdueStatus> overdueStatus = overdueStatusMapper.selectOverAllBySinoid(sinoidList);
		List<OverRepaymentDetail> overRepaymentDetail = new ArrayList<OverRepaymentDetail>();
		// 发生过逾期的账户明细
		List<ContractAcceptDetail> overDetailList = contractAcceptDetailMapper.selectOverdueBySinoid(sinoidList);
		for (int i = 0; i < overDetailList.size(); i++) {
			String sinoid = overDetailList.get(i).getSinoid();
			String[] sinoidArray = sinoid.split("-");
			String instiCodes = sinoidArray[2];

			int instiCode = Integer.parseInt(instiCodes);

			String instiName = instiDetailMapper.getInstiNameByInstiCode(String.valueOf(instiCode));
			overDetailList.get(i).setInstiName(instiName);
		}
		for (int i = 0; i < overdueStatus.size(); i++) {
			String date1 = DateUtils.dateToStr(overdueStatus.get(i).getSinotime());
			
			OverRepaymentDetail element = new OverRepaymentDetail();
			element.setSinotime(date1);
			if (overdueStatus.get(i).getOverdueStartTime() == null) {
				element.setOverdueStartTime(null);
			} else {
				String date2 = DateUtils.dateToStr(overdueStatus.get(i).getOverdueStartTime());
				element.setOverdueStartTime(date2);
			}
			element.setColSn(overdueStatus.get(i).getColSn());
			element.setOverdueReason(overdueStatus.get(i).getOverdueReason());
			element.setOverdueStatusMark(overdueStatus.get(i).getOverdueStatusMark());
			element.setPaymentLevel(overdueStatus.get(i).getPaymentLevel().toString());
			element.setSinoid(overdueStatus.get(i).getSinoid());
			overRepaymentDetail.add(i, element);
		}
		// 近两年的查询
		List<SearchDetail> twoyearsSearchNum = searchDetailMapper.findPerSearListBySinocardid(sinoCardid);
		List<TwoYearsSearchDetail> twoYearsSearchDetailList = new ArrayList<TwoYearsSearchDetail>();
		for (int i = 0; i < twoyearsSearchNum.size(); i++) {
			String date1 = DateUtils.dateToStr(twoyearsSearchNum.get(i).getReqTime());
			String date2 = DateUtils.dateToStr(twoyearsSearchNum.get(i).getSinotime());

			String sinoid = twoyearsSearchNum.get(i).getSinoid();
			String[] sinoidArray = sinoid.split("-");
			String instiCodes = sinoidArray[2];

			int instiCode = Integer.parseInt(instiCodes);

			String instiName = instiDetailMapper.getInstiNameByInstiCode(String.valueOf(instiCode));

			twoyearsSearchNum.get(i).setInstiName(instiName);

			TwoYearsSearchDetail element = new TwoYearsSearchDetail();
			element.setReqTime(date1);
			element.setSinotime(date2);
			element.setCardid(sinoBody.getCardid());
			element.setCellPhoneNum(twoyearsSearchNum.get(i).getCellPhoneNum());
			element.setName(sinoBody.getName());
			element.setReportId(twoyearsSearchNum.get(i).getReportId());
			element.setReqReason(twoyearsSearchNum.get(i).getReqReason());
			element.setServiceCode(twoyearsSearchNum.get(i).getServiceCode());
			element.setSinoid(twoyearsSearchNum.get(i).getSinoid());
			element.setUserAccount(twoyearsSearchNum.get(i).getUserAccount());
			element.setResultAdd(twoyearsSearchNum.get(i).getResultAdd());
			twoYearsSearchDetailList.add(i, element);
		}
		// 公共信用信息
		// String publicCreditInformation=0;
		// 本人异议申诉明细
		// int dissentApplyDetail=0;
		// set所有字段

		// 留存
		insSearchReport(personReportId, user, personReportId, "13", today, sinoCardid, "91", today);

		PersonReport personReport = new PersonReport();
		personReport.setSearchDate(searchdate);
		personReport.setPersonReportId(personReportId);
		personReport.setName(name);
		personReport.setCardid(cardid);
		personReport.setSinoCardid(sinoCardid);
		personReport.setCellPhoneNum(cellPhoneNum);
		personReport.setCreditLoanNum(creditLoanNum);
		personReport.setNormalCreditLoan(normalCreditLoan);
		personReport.setOverCreditLoan(overCreditLoan);
		personReport.setMortgageLoanNum(mortgageLoanNum);
		personReport.setNormalMortgageLoan(normalMortgageLoan);
		personReport.setOverMortgageLoan(overMortgageLoan);
		personReport.setGuaranteeLoanNum(guaranteeLoanNum);
		personReport.setNormarlGuaranteeLoan(normarlGuaranteeLoan);
		personReport.setOverGuaranteeLoan(overGuaranteeLoan);
		personReport.setOtherLoanNum(otherLoanNum);
		personReport.setNormalOtherLoan(normalOtherLoan);
		personReport.setOverOtherLoan(overOtherLoan);

		personReport.setBlackDetailList(blackDetailList);
		personReport.setRepaymentDetailList(repaymentDetailList);
		personReport.setOverRepaymentDetailList(overRepaymentDetail);
		personReport.setOverDetailList(overDetailList);
		personReport.setTwoyearsSearchNum(twoYearsSearchDetailList);
		personReport.setPublicCreditInformation(null);
		personReport.setDissentApplyDetail(null);

		System.out.println(personReport);
		return personReport;
	}
	
	private void insSearchReport(String reportId, User user, String sinoid, String reqReason, Date reqTime,String sinoCardid,
			String serviceCode, Date sinotime) {

		SearchDetail searchDetail = new SearchDetail();
		searchDetail.setReportId(reportId);
		searchDetail.setSinoid(sinoid);
		searchDetail.setUserAccount(user.getUserAccount());
		searchDetail.setReqReason(reqReason);
		searchDetail.setReqTime(reqTime);
		searchDetail.setSinoCardid(sinoCardid);
		searchDetail.setSinotime(sinotime);
		searchDetail.setServiceCode(serviceCode);
		searchDetailMapper.insert(searchDetail);
	}

}
