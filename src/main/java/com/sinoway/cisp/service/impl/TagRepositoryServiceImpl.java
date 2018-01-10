package com.sinoway.cisp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.TagRepositoryMapper;
import com.sinoway.cisp.entitys.TagRepository;
import com.sinoway.cisp.service.TagRepositoryService;

@Service
@Transactional
public class TagRepositoryServiceImpl implements TagRepositoryService {

	@Autowired
	private TagRepositoryMapper tagRepositoryMapper;

	@Override
	public List<TagRepository> findTagBySinoidList(List<String> sinoidList) {
		List<TagRepository> tagList = tagRepositoryMapper.findTagBySinoidList(sinoidList);
		return tagList;
	}

}
