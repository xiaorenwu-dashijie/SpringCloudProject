package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.entitys.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer userId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 通过公钥查询用户账户名
	 * 
	 * @param key
	 * @return
	 */
	@Select("select user_account from user where user_key=#{key} LIMIT 1")
	String selectCountByKey(String key);

	/**
	 * 通过公钥查询用户
	 * 
	 * @param key
	 * @return
	 */
	@Select("SELECT * from user WHERE user_key=#{key} LIMIT 1")
	@ResultMap("BaseResultMap")
	User findUserByKey(String key);
	@Select("SELECT insti_shortname from user where user_account=#{userAccount}")
	String selectInstiNameByUserAccount(String userBlackAccount);

}