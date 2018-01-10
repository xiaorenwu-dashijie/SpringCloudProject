package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.Blacklist;
import com.sinoway.cisp.entitys.BlacklistExample;

public interface BlacklistMapper {
	int countByExample(BlacklistExample example);

	int deleteByExample(BlacklistExample example);

	int deleteByPrimaryKey(String sinoid);

	int insert(Blacklist record);

	int insertSelective(Blacklist record);

	List<Blacklist> selectByExample(BlacklistExample example);

	Blacklist selectByPrimaryKey(String sinoid);

	int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

	int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

	int updateByPrimaryKeySelective(Blacklist record);

	int updateByPrimaryKey(Blacklist record);

	/**
	 * 通过华道身份证号查询近5年的失信行为记录
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("select * from blacklist where sino_cardid = #{sinoCardid} and ishide = '0' and public_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR) order by public_time DESC")
	@ResultMap("BaseResultMap")
	List<Blacklist> selectBlacListBySinocardid(String sinoCardid);

	/**
	 * 通过华道身份证号和用户账户查询该信息主体在该机构未隐藏的的黑名单
	 * 
	 * @param sinoCardid
	 * @param userAccount
	 * @return
	 */
	@Select("SELECT * from blacklist where sino_cardid=#{arg0} and user_account=#{arg1} AND ishide=0")
	@ResultMap("BaseResultMap")
	List<Blacklist> findBlackBySinocardidAndAccount(String sinoCardid, String userAccount);
}