package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.SinoBody;
import com.sinoway.cisp.entitys.SinoBodyExample;

public interface SinoBodyMapper {
	int countByExample(SinoBodyExample example);

	int deleteByExample(SinoBodyExample example);

	int deleteByPrimaryKey(String sinoCardid);

	int insert(SinoBody record);

	int insertSelective(SinoBody record);

	List<SinoBody> selectByExample(SinoBodyExample example);

	SinoBody selectByPrimaryKey(String sinoCardid);

	int updateByExampleSelective(@Param("record") SinoBody record, @Param("example") SinoBodyExample example);

	int updateByExample(@Param("record") SinoBody record, @Param("example") SinoBodyExample example);

	int updateByPrimaryKeySelective(SinoBody record);

	int updateByPrimaryKey(SinoBody record);

	/**
	 * 通过身份证号查询信息主体
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("SELECT * from sino_body WHERE name=#{arg0} and cardid=#{arg1} ORDER BY sinotime DESC LIMIT 1")
	@ResultMap("BaseResultMap")
	SinoBody findSinobodyByCardid(String name, String cardid);

	/**
	 * 通过身份证号查询华道身份证号
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("SELECT sino_cardid from sino_body WHERE name=#{arg0} and cardid=#{arg1} ORDER BY sinotime DESC LIMIT 1")
	String findSinoCardidByCardid(String name, String cardid);

}