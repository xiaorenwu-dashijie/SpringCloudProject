package com.sinoway.cisp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.SinoBodyMapper;
import com.sinoway.cisp.service.SinoBodyService;

@Service
@Transactional
public class SinoBodyServiceImpl implements SinoBodyService {

	@Autowired
	private SinoBodyMapper sinoBodyMapper;

	@Override
	public String findSinoCardidByCardid(String name, String cardid) {
		String sinoCardid = sinoBodyMapper.findSinoCardidByCardid(name, cardid);
		return sinoCardid;
	}

}
