package com.sinoway.cisp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.sinoway.cisp.entitys.TagRepository;
import com.sinoway.cisp.entitys.TagRepositoryExample;

public interface TagRepositoryMapper {
	int countByExample(TagRepositoryExample example);

	int deleteByExample(TagRepositoryExample example);

	int deleteByPrimaryKey(Integer tagId);

	int insert(TagRepository record);

	int insertSelective(TagRepository record);

	List<TagRepository> selectByExample(TagRepositoryExample example);

	TagRepository selectByPrimaryKey(Integer tagId);

	int updateByExampleSelective(@Param("record") TagRepository record, @Param("example") TagRepositoryExample example);

	int updateByExample(@Param("record") TagRepository record, @Param("example") TagRepositoryExample example);

	int updateByPrimaryKeySelective(TagRepository record);

	int updateByPrimaryKey(TagRepository record);

	/**
	 * 根据sinoid查询标签代码
	 * 
	 * @param sinoid
	 * @return
	 */
	@Select("select tag_code,table_name from tag_repository where sinoid=#{sinoid}")
	@ResultMap("BaseResultMap")
	List<TagRepository> findTagsBySinoid(String sinoid);

	List<TagRepository> findTagBySinoidList(List<String> sinoidList);
}