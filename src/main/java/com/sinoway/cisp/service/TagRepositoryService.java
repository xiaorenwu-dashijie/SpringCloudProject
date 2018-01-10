package com.sinoway.cisp.service;

import java.util.List;

import com.sinoway.cisp.entitys.TagRepository;

public interface TagRepositoryService {

	/**
	 * 通过sinoid集合查询出对应的标签集合
	 * 
	 * @param sinoidList
	 * @return
	 */
	List<TagRepository> findTagBySinoidList(List<String> sinoidList);

}
