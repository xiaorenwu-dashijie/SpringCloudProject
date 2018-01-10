package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.SearchDetail;
import com.sinoway.cisp.entitys.SearchDetailExample;

public interface SearchDetailMapper {
	int countByExample(SearchDetailExample example);

	int deleteByExample(SearchDetailExample example);

	int deleteByPrimaryKey(String reportId);

	int insert(SearchDetail record);

	int insertSelective(SearchDetail record);

	List<SearchDetail> selectByExample(SearchDetailExample example);

	SearchDetail selectByPrimaryKey(String reportId);

	int updateByExampleSelective(@Param("record") SearchDetail record, @Param("example") SearchDetailExample example);

	int updateByExample(@Param("record") SearchDetail record, @Param("example") SearchDetailExample example);

	int updateByPrimaryKeySelective(SearchDetail record);

	int updateByPrimaryKey(SearchDetail record);

	/**
	 * 最近两年内查询记录详情--个人征信报告，不包含个人信用的查询记录
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("select * from search_detail where sino_cardid = #{sinoCardid} AND SUBSTR(report_id,1,10)<>'SINOWAY-R-' "
			+ "AND req_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR) ORDER BY req_time desc")
	@ResultMap("BaseResultMap")
	List<SearchDetail> findSearListBySinocardid(String sinoCardid);

	/**
	 * 最近两年内查询记录详情--个人信用报告，包含该信息主体的所有查询记录
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("select * from search_detail where sino_cardid = #{sinoCardid} AND req_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR) ORDER BY req_time desc")
	@ResultMap("BaseResultMap")
	List<SearchDetail> findPerSearListBySinocardid(String sinoCardid);

	/**
	 * 最近两年内查询记录条数--个人征信报告，不包含个人信用和黑名单的查询记录条数(个人信用报告的report_id是SINOWAY-R-,
	 * 黑名单的report_id是SINOWAY-D-)
	 * 
	 * @param cardid
	 * @return
	 */
	@Select("select count(1) from search_detail where sino_cardid = #{sinoCardid} AND SUBSTR(report_id,1,10)='SINOWAY-Q-' AND req_time > DATE_SUB(CURDATE(), INTERVAL 2 YEAR)")
	int findSearCountBySinocardid(String sinoCardid);

	/**
	 * 通过sinoid模糊查询出某机构对应的签约数量 5,6,7,8
	 * 
	 * @param sinoid
	 * @return 签约数量
	 */
	@Select("SELECT COUNT(1) FROM search_detail WHERE sinoid LIKE #{sinoid} " + "AND req_reason BETWEEN 5 AND 8 ")
	int findContCountBySinoid(String sinoid);

	/**
	 * 通过sinoid模糊查询出某机构对应的贷中数量 2
	 * 
	 * @param sinoid
	 * @return 贷中数量
	 */
	@Select("SELECT COUNT(1) FROM search_detail WHERE sinoid LIKE #{sinoid} AND req_reason = 2")
	int findUpCountBySinoid(String sinoid);

	/**
	 * 通过sinoid查询所有的进件数量
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("SELECT COUNT(1) FROM search_detail WHERE sinoid LIKE #{sinoid} AND req_reason = 1")
	int findLoanCountBySinoid(String sinoid);

}