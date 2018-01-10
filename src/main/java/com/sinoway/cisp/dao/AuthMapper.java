package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.Auth;
import com.sinoway.cisp.entitys.AuthExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface AuthMapper {
	int countByExample(AuthExample example);

	int deleteByExample(AuthExample example);

	int deleteByPrimaryKey(String code);

	int insert(Auth record);

	int insertSelective(Auth record);

	List<Auth> selectByExample(AuthExample example);

	Auth selectByPrimaryKey(String code);

	int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

	int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

	int updateByPrimaryKeySelective(Auth record);

	int updateByPrimaryKey(Auth record);

	/**
	 * 删除所有权限
	 * 
	 * @return
	 */
	@Delete("DELETE FROM auth")
	int deleteAllAuth();
}