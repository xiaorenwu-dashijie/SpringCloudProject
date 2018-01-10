package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.ContractAcceptDetail;
import com.sinoway.cisp.entitys.ContractAcceptDetailExample;

public interface ContractAcceptDetailMapper {
	int countByExample(ContractAcceptDetailExample example);

	int deleteByExample(ContractAcceptDetailExample example);

	int deleteByPrimaryKey(String sinoid);

	int insert(ContractAcceptDetail record);

	int insertSelective(ContractAcceptDetail record);

	List<ContractAcceptDetail> selectByExample(ContractAcceptDetailExample example);

	ContractAcceptDetail selectByPrimaryKey(String sinoid);

	int updateByExampleSelective(@Param("record") ContractAcceptDetail record,
			@Param("example") ContractAcceptDetailExample example);

	int updateByExample(@Param("record") ContractAcceptDetail record,
			@Param("example") ContractAcceptDetailExample example);

	int updateByPrimaryKeySelective(ContractAcceptDetail record);

	int updateByPrimaryKey(ContractAcceptDetail record);

	/**
	 * 通过身份证号查询该信息主体的近2年的交易记录明细，按照合同结束时间算并排序
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("SELECT * FROM contract_accept_detail c LEFT JOIN id_mapper i ON c.sinoid = i.sinoid "
			+ "WHERE i.sino_cardid = #{sinoCardid} AND c.stop_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR) ORDER BY c.start_time DESC")
	@ResultMap("BaseResultMap")
	List<ContractAcceptDetail> selectBySinoCardid(String sinoCardid);

	/**
	 * 查询SIONID对应的开始时间与结束时间的间隔天数
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("SELECT DATEDIFF(stop_time, start_time) FROM contract_accept_detail WHERE sinoid = #{sinoid}")
	int selectIntervalDaysBySinoid(String sinoid);

	/**
	 * 定时任务：查询上一周的数据
	 * 
	 * @return
	 */
	@Select("select * from contract_accept_detail where sinotime  > DATE_SUB(CURDATE(), INTERVAL 7 DAY)")
	@ResultMap("BaseResultMap")
	List<ContractAcceptDetail> findLastWeek();

	/**
	 * 查询SINOID对应的还款开始时间/结束时间/还款期数信息
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("SELECT start_time,stop_time,pay_period,contract_sum FROM contract_accept_detail WHERE sinoid=#{sinoid} ")
	@ResultMap("BaseResultMap")
	ContractAcceptDetail selectRepaymentInfoBySinoid(String sinoid);

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='1' ")
	List<String> selectcreditLoanList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='1' AND contract_status!='4' ")
	List<String> selectnormalCreditLoanList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='2' ")
	List<String> selectmortgageLoanNumList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='2' AND contract_status!='4' ")
	List<String> selectnormalMortgageLoanList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='4' ")
	List<String> selectguaranteeLoanNumList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='4' AND contract_status!='4' ")
	List<String> selectnormarlGuaranteeLoanList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='3' or guara_type='5' or guara_type='6' or guara_type='7' ")
	List<String> selectotherLoanNumList();

	@Select("SELECT sinoid FROM contract_accept_detail WHERE guara_type='3' or guara_type='5' or guara_type='6' or guara_type='7' AND contract_status!='4' ")
	List<String> selectnormalOtherLoanList();

	List<ContractAcceptDetail> selectAllBySinoid(List<String> sinoidList);

	@Select("SELECT COUNT(*) FROM contract_accept_detail WHERE sinoid LIKE #{sinoid}")
	int selectacceptCountBySinoid(String sinoid);

	@Select("SELECT COUNT(*) FROM contract_accept_detail WHERE sinoid LIKE #{sinoid} AND (contract_sum is  null or  start_time is  null or stop_time is null or pay_period is null)")
	int selectacceptBadCountBySinoid(String sinoid);

	List<String> selectByGuaraType1(List<String> sinoidList);

	List<String> selectByGuaraType2(List<String> sinoidList);

	List<String> selectByGuaraType4(List<String> sinoidList);

	List<String> selectByGuaraTypeOther(List<String> sinoidList);

	List<ContractAcceptDetail> selectOverdueBySinoid(List<String> sinoidList);

	/**
	 * 查询逾期状态的合同，才能进行催收
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("SELECT * from contract_accept_detail WHERE sinoid=#{sinoid} AND contract_status=4")
	ContractAcceptDetail findContOfOverdure(String sinoid);

}