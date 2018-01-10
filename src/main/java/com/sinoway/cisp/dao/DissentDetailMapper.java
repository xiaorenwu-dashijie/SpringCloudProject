package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.DissentDetail;
import com.sinoway.cisp.entitys.DissentDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface DissentDetailMapper {
	int countByExample(DissentDetailExample example);

	int deleteByExample(DissentDetailExample example);

	int deleteByPrimaryKey(String dissentId);

	int insert(DissentDetail record);

	int insertSelective(DissentDetail record);

	List<DissentDetail> selectByExample(DissentDetailExample example);

	DissentDetail selectByPrimaryKey(String dissentId);

	int updateByExampleSelective(@Param("record") DissentDetail record, @Param("example") DissentDetailExample example);

	int updateByExample(@Param("record") DissentDetail record, @Param("example") DissentDetailExample example);

	int updateByPrimaryKeySelective(DissentDetail record);

	int updateByPrimaryKey(DissentDetail record);

	/**
	 * 根据华道身份证号查询所有异议信息
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT * from dissent_detail WHERE sino_cardid=#{sinoCardid}")
	@ResultMap("BaseResultMap")
	List<DissentDetail> selectDissentListBySinocardid(String sinoCardid);
}