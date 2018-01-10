package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.RoleAuth;
import com.sinoway.cisp.entitys.RoleAuthExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoleAuthMapper {
	int countByExample(RoleAuthExample example);

	int deleteByExample(RoleAuthExample example);

	int deleteByPrimaryKey(Long roleAuthId);

	int insert(RoleAuth record);

	int insertSelective(RoleAuth record);

	List<RoleAuth> selectByExample(RoleAuthExample example);

	RoleAuth selectByPrimaryKey(Long roleAuthId);

	int updateByExampleSelective(@Param("record") RoleAuth record, @Param("example") RoleAuthExample example);

	int updateByExample(@Param("record") RoleAuth record, @Param("example") RoleAuthExample example);

	int updateByPrimaryKeySelective(RoleAuth record);

	int updateByPrimaryKey(RoleAuth record);

	/**
	 * 通过角色代码查找权限集合
	 * 
	 * @param string
	 * @return
	 */
	@Select("SELECT auth_code from role_auth where role_code = #{roleCode}")
	List<String> findAuthListByRoleCode(String roleCode);

	/**
	 * 清空表
	 * 
	 * @return
	 */
	@Delete("DELETE from role_auth")
	int deleteAllRoleAuth();
}