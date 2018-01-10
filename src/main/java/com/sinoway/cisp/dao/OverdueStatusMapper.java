package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.OverdueStatus;
import com.sinoway.cisp.entitys.OverdueStatusExample;
import com.sinoway.cisp.entitys.OverdueStatusKey;

public interface OverdueStatusMapper {
	int countByExample(OverdueStatusExample example);

	int deleteByExample(OverdueStatusExample example);

	int deleteByPrimaryKey(OverdueStatusKey key);

	int insert(OverdueStatus record);

	int insertSelective(OverdueStatus record);

	List<OverdueStatus> selectByExample(OverdueStatusExample example);

	OverdueStatus selectByPrimaryKey(OverdueStatusKey key);

	int updateByExampleSelective(@Param("record") OverdueStatus record, @Param("example") OverdueStatusExample example);

	int updateByExample(@Param("record") OverdueStatus record, @Param("example") OverdueStatusExample example);

	int updateByPrimaryKeySelective(OverdueStatus record);

	int updateByPrimaryKey(OverdueStatus record);

	/**
	 * 根据合同的sinoid查询催收信息，并根据催收次数倒序排列
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("SELECT * from overdue_status WHERE sinoid=#{sinoid} ORDER BY col_sn DESC")
	@ResultMap("BaseResultMap")
	List<OverdueStatus> findOverdueListBySinoid(String sinoid);

	/**
	 * 查询逾期表中的所有sinoid
	 * 
	 * @return
	 */
	@Select("SELECT sinoid FROM overdue_status")
	List<String> selectLoanList();

	List<OverdueStatus> selectOverAllBySinoid(List<String> sinoidList);

}