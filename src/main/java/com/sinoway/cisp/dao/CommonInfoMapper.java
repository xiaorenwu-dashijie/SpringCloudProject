package com.sinoway.cisp.dao;

import com.sinoway.cisp.entitys.CommonInfo;
import com.sinoway.cisp.entitys.CommonInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface CommonInfoMapper {
	int countByExample(CommonInfoExample example);

	int deleteByExample(CommonInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CommonInfo record);

	int insertSelective(CommonInfo record);

	List<CommonInfo> selectByExample(CommonInfoExample example);

	CommonInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") CommonInfo record, @Param("example") CommonInfoExample example);

	int updateByExample(@Param("record") CommonInfo record, @Param("example") CommonInfoExample example);

	int updateByPrimaryKeySelective(CommonInfo record);

	int updateByPrimaryKey(CommonInfo record);

	/**
	 * 根据华道身份证号查询公共信用信息
	 * 
	 * @param sinoCardid
	 * @return
	 */
	@Select("SELECT * from common_info WHERE sino_cardid=#{sinoCardid}")
	@ResultMap("BaseResultMap")
	List<CommonInfo> findInfoListBySinocardid(String sinoCardid);
}