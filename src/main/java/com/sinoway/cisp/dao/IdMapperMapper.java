package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.entitys.IdMapperExample;

public interface IdMapperMapper {
	int countByExample(IdMapperExample example);

	int deleteByExample(IdMapperExample example);

	int deleteByPrimaryKey(String sinoid);

	int insert(IdMapper record);

	int insertSelective(IdMapper record);

	List<IdMapper> selectByExample(IdMapperExample example);

	IdMapper selectByPrimaryKey(String sinoid);

	int updateByExampleSelective(@Param("record") IdMapper record, @Param("example") IdMapperExample example);

	int updateByExample(@Param("record") IdMapper record, @Param("example") IdMapperExample example);

	int updateByPrimaryKeySelective(IdMapper record);

	int updateByPrimaryKey(IdMapper record);

	/**
	 * 通过申请编号和用户账户查询该机构是否已经有申请编号为crid的进件
	 * 
	 * @param crid
	 * @param userAccount
	 *            目前按照一个机构一个用户查询的，如果是多个用户可以用机构代码进行查询
	 * @return
	 */
	@Select("SELECT sinoid from id_mapper WHERE instiid=#{arg0} and user_account=#{arg1} LIMIT 1")
	String findSinoidByInstiid(String crid, String userAccount);

	/**
	 * 通过申请编号和用户账户查询本机构进件的id_mapper
	 * 
	 * @param crid
	 * @param userAccount
	 *            目前按照一个机构一个用户查询的，如果是多个用户可以用机构代码进行查询
	 * @return
	 */
	@Select("SELECT * from id_mapper WHERE instiid=#{arg0} and user_account=#{arg1} order by sinotime DESC LIMIT 1")
	@ResultMap("BaseResultMap")
	IdMapper findIdmapperByInstiid(String crid, String userAccount);

	/**
	 * 通过合同编号和用户账户查询该机构是否有该合同
	 * 
	 * @param contractid
	 * @param userAccount
	 *            目前按照一个机构一个用户查询的，如果是多个用户可以用机构代码进行查询
	 * @return
	 */
	@Select("SELECT sinoid from id_mapper WHERE contract_id=#{arg0} and user_account=#{arg1} order by sinotime DESC LIMIT 1")
	String findContSinoidByContId(String contractid, String userAccount);

	/**
	 * 通过合同编号和用户账户查询该机构是否有该合同
	 * 
	 * @param contractid
	 * @param userAccount
	 *            目前按照一个机构一个用户查询的，如果是多个用户可以用机构代码进行查询
	 * @return
	 */
	@Select("SELECT * from id_mapper WHERE contract_id=#{arg0} and user_account=#{arg1} order by sinotime DESC LIMIT 1")
	@ResultMap("BaseResultMap")
	IdMapper findidMapperByContId(String crid, String userAccount);

	/**
	 * 通过身份证号查询所有的sinoid
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("SELECT sinoid FROM id_mapper WHERE sino_cardid=#{sinoCardid} ")
	List<String> findSinoidsBySinocardid(String sinoCardid);

	/**
	 * 根据机构代码查找所有的SINOID
	 * 
	 * @param instiCode
	 * @return SINOIDLIST
	 */
	@Select("SELECT sinoid FROM id_mapper WHERE insti_code=#{instiCode} ")
	List<String> selectSinoidsByInstiCode(String instiCode);

}