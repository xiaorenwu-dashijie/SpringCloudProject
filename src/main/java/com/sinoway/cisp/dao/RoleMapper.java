package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.sinoway.cisp.entitys.Role;
import com.sinoway.cisp.entitys.RoleExample;

public interface RoleMapper {
	int countByExample(RoleExample example);

	int deleteByExample(RoleExample example);

	int deleteByPrimaryKey(String roleCode);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(String roleCode);

	int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * 删除所有的角色
	 * 
	 * @return
	 */
	@Delete("DELETE from role")
	int deleteAllRole();
}