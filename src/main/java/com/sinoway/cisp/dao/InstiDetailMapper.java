package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.InstiDetail;
import com.sinoway.cisp.entitys.InstiDetailExample;

public interface InstiDetailMapper {
    int countByExample(InstiDetailExample example);

    int deleteByExample(InstiDetailExample example);

    int deleteByPrimaryKey(String instiCode);

    int insert(InstiDetail record);

    int insertSelective(InstiDetail record);

    List<InstiDetail> selectByExample(InstiDetailExample example);

    InstiDetail selectByPrimaryKey(String instiCode);

    int updateByExampleSelective(@Param("record") InstiDetail record, @Param("example") InstiDetailExample example);

    int updateByExample(@Param("record") InstiDetail record, @Param("example") InstiDetailExample example);

    int updateByPrimaryKeySelective(InstiDetail record);

    int updateByPrimaryKey(InstiDetail record);
    
    /**
	 * 查询所有的机构code
	 * 
	 * @return
	 */
	@Select("SELECT insti_code FROM insti_detail")
	List<String> selectAllInstiCode();

	/**
	 * 查询机构全称
	 * 
	 * @param instiCode
	 * @return 机构全称
	 */
	@Select("SELECT insti_name FROM insti_detail WHERE insti_code=#{instiCode}")
	String selectInstiNameByInstiCode(String instiCode);
	@Select("select insti_shortname from insti_detail where insti_code=#{instiCode}")
	String getInstiNameByInstiCode(String valueOf);
    
}