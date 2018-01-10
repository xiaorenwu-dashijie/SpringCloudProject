package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.PaidMonthlyAmount;
import com.sinoway.cisp.entitys.PaidMonthlyAmountExample;

public interface PaidMonthlyAmountMapper {
	int countByExample(PaidMonthlyAmountExample example);

	int deleteByExample(PaidMonthlyAmountExample example);

	int deleteByPrimaryKey(String sinoid);

	int insert(PaidMonthlyAmount record);

	int insertSelective(PaidMonthlyAmount record);

	List<PaidMonthlyAmount> selectByExample(PaidMonthlyAmountExample example);

	List<PaidMonthlyAmount> selectByPrimaryKey(String sinoid);

	int updateByExampleSelective(@Param("record") PaidMonthlyAmount record,
			@Param("example") PaidMonthlyAmountExample example);

	int updateByExample(@Param("record") PaidMonthlyAmount record, @Param("example") PaidMonthlyAmountExample example);

	int updateByPrimaryKeySelective(PaidMonthlyAmount record);

	int updateByPrimaryKey(PaidMonthlyAmount record);

	/**
	 * 通过sinoid查询还款信息，并根据还款次数倒序排列
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("SELECT * from paid_monthly_amount WHERE sinoid=#{sinoid} ORDER BY paymentNumber DESC")
	@ResultMap("BaseResultMap")
	List<PaidMonthlyAmount> selectPaidMonthlyAmountListBySinoid(String sinoid);

	/**
	 * 根据SINOID查询PaidMonthlyAmount对象(近一个月内)
	 * 
	 * @param sinoid
	 * @return PaidMonthlyAmount
	 */
	@Select("SELECT sinoid,paymentNumber,paid_money,paid_time,sinotime,remark FROM paid_monthly_amount "
			+ "WHERE sinoid=#{sinoid} AND sinotime > DATE_SUB(SYSDATE(),INTERVAL 1 MONTH) "
			+ "ORDER BY paymentNumber ASC ")
	@ResultMap("BaseResultMap")
	List<PaidMonthlyAmount> selectPaidMonthlyAmountBySinoid(String sinoid);

}