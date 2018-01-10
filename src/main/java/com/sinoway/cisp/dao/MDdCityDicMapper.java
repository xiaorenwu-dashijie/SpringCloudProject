package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.MDdCityDic;
import com.sinoway.cisp.entitys.MDdCityDicExample;

public interface MDdCityDicMapper {
	int countByExample(MDdCityDicExample example);

	int deleteByExample(MDdCityDicExample example);

	int deleteByPrimaryKey(String cCode);

	int insert(MDdCityDic record);

	int insertSelective(MDdCityDic record);

	List<MDdCityDic> selectByExample(MDdCityDicExample example);

	MDdCityDic selectByPrimaryKey(String cCode);

	int updateByExampleSelective(@Param("record") MDdCityDic record, @Param("example") MDdCityDicExample example);

	int updateByExample(@Param("record") MDdCityDic record, @Param("example") MDdCityDicExample example);

	int updateByPrimaryKeySelective(MDdCityDic record);

	int updateByPrimaryKey(MDdCityDic record);

	@Select("SELECT c_code FROM m_dd_city_dic WHERE c_code=#{cCode}")
	String findcCode(String cCode);

}