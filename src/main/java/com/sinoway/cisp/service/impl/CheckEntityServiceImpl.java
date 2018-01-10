package com.sinoway.cisp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.entitys.IdMapper;
import com.sinoway.cisp.service.CheckEntityService;

@Service
@Transactional
public class CheckEntityServiceImpl<T> implements CheckEntityService<T> {

	public String check(IdMapper idMapper, T entity) {
		
		return null;
	}
}
