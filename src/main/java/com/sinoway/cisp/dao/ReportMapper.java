package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.LoanApplication;

public interface ReportMapper {

	/**
	 * 通过华道身份证号，按照合同开始时间查询该信息主体近两年正常未清的合同Sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT c.sinoid from contract_accept_detail c LEFT JOIN id_mapper i ON c.sinoid = i.sinoid "
			+ "WHERE i.sino_cardid = #{sinoCardid} AND c.contract_status IN (1, 3) "
			+ "AND c.start_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR)")
	List<String> findSinoidByNormalOutSettle(String sinoCardid);

	/**
	 * 通过华道身份证号，按照合同开始时间查询该信息主体近两年正常结清的合同Sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT c.sinoid from contract_accept_detail c LEFT JOIN id_mapper i ON c.sinoid = i.sinoid "
			+ "WHERE i.sino_cardid = #{sinoCardid} AND c.contract_status=2 "
			+ "AND c.start_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR)")
	List<String> findSinoidByNormalSettle(String sinoCardid);

	/**
	 * 通过华道身份证号，按照合同开始时间查询该信息主体近两年异常未清的合同Sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT c.sinoid from contract_accept_detail c LEFT JOIN id_mapper i ON c.sinoid = i.sinoid "
			+ "WHERE i.sino_cardid = #{sinoCardid} AND c.contract_status=4 "
			+ "AND c.start_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR)")
	List<String> findSinoidByAbnormalOutSettle(String sinoCardid);

	/**
	 * 通过华道身份证号，按照合同开始时间查询该信息主体近两年异常结清的合同Sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT c.sinoid from contract_accept_detail c LEFT JOIN id_mapper i ON c.sinoid = i.sinoid "
			+ "WHERE i.sino_cardid = #{sinoCardid} AND c.contract_status IN (5, 6) "
			+ "AND c.start_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR)")
	List<String> findSinoidByAbnormalSettle(String sinoCardid);

	/**
	 * 通过华道身份证号，按照申请时间查询最近六个月待审记录的sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT sinoid FROM loan_application where sino_cardid=#{sinoCardid} and request_result IN (0,3) "
			+ "and request_time > DATE_SUB(CURDATE(), INTERVAL 6 MONTH)")
	List<String> findSinoidByWaitCheck(String sinoCardid);

	/**
	 * 通过华道身份证号，按照申请时间查询最近六个月审批通过记录的sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT sinoid FROM loan_application where sino_cardid = #{sinoCardid} and request_result = 1 and request_time > DATE_SUB(CURDATE(), INTERVAL 6 MONTH)")
	List<String> findSinoidByPassCheck(String sinoCardid);

	/**
	 * 通过华道身份证号，按照申请时间查询最近六个月审批未通过记录的sinoid
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT sinoid FROM loan_application WHERE sino_cardid = #{sinoCardid} AND request_result = 2 AND request_time > DATE_SUB(CURDATE(), INTERVAL 6 MONTH)")
	List<String> findSinoidByUnpassCheck(String sinoCardid);

	/**
	 * 通过华道身份证号，按照申请时间查询最近六个月客户取消记录数
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT sinoid FROM loan_application WHERE sino_cardid = #{sinoCardid} and request_result = 4 AND request_time > DATE_SUB(CURDATE(), INTERVAL 6 MONTH)")
	List<String> findSinoidByCancel(String sinoCardid);

	/**
	 * 最近两年内查询记录条数--个人征信报告，不包含个人信用的查询记录条数
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("select sinoid from search_detail where sino_cardid = #{sinoCardid} AND sinoid NOT LIKE '%SINOWAY-R%' AND req_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR)")
	List<String> findSinoidBySear(String sinoCardid);

	/**
	 * 通过华道身份证号，按照申请时间查询最近六个月所有申请并排序
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("select sinoid,request_time,request_location,request_type,request_money,request_result from loan_application "
			+ "where sino_cardid=#{sinoCardid} and request_time>DATE_SUB(CURDATE(), INTERVAL 6 MONTH) ORDER BY request_time DESC")
	@ResultMap("BaseResultMap")
	List<LoanApplication> selectLoanAppOfSixMonth(String sinoCardid);
}
