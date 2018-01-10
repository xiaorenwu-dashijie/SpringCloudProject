package com.sinoway.cisp.service;

import java.util.List;

import com.sinoway.cisp.entitys.ApplyDetail;
import com.sinoway.cisp.entitys.Dissent;
import com.sinoway.cisp.entitys.TransactionsDetail;
import com.sinoway.cisp.entitys.TwoYearSearchDetail;
import com.sinoway.cisp.entitys.User;

public interface ReportDetailService {

	/**
	 * 最近6个月贷款申请记录明细
	 * 
	 * @param cardId
	 * @param user
	 * @return
	 */
	public List<ApplyDetail> applyHistoryDetail(String sinoCardid, User user);

	/**
	 * 近两年交易记录明细，按照合同开始时间算
	 * 
	 * @param cardId
	 * @param user
	 * @return
	 */
	public List<TransactionsDetail> transactionsHistoryDetail(String sinoCardid, User user);

	/**
	 * 最近两年内查询记录统计，按照查询时间算
	 * 
	 * @param cardId
	 * @param user
	 * @return
	 */
	public List<TwoYearSearchDetail> Last2yearsSearchDetail(String sinoCardid, User user);

	/**
	 * 本人异议申诉明细
	 * 
	 * @param cardId
	 * @return
	 */
	public List<Dissent> getDissents(String sinoCardid);

	/**
	 * 获取身份认证信息
	 * 
	 * @param cardid
	 * @param name
	 * @return
	 */
	public String getIdentityAuth(String cardid, String name);

	/**
	 * 学历认证
	 * 
	 * @param cardid
	 * @param name
	 * @return
	 */
	public String getEduAuth(String cardid, String name);

	/**
	 * 身份认证
	 * 
	 * @param cardid
	 * @param name
	 * @return
	 */
	public List<String> getJudicialAuth(String cardid, String name);

}
