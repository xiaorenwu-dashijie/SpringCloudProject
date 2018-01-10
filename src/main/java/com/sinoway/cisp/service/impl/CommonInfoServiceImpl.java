package com.sinoway.cisp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.CommonInfoMapper;
import com.sinoway.cisp.entitys.CommonInfo;
import com.sinoway.cisp.entitys.CommonInfoVo;
import com.sinoway.cisp.service.CommonInfoService;

@Transactional
@Service
public class CommonInfoServiceImpl implements CommonInfoService {
	
	@Autowired
	private CommonInfoMapper commonInfoMapper;

	@Override
	public List<CommonInfoVo> findInfoListBySinocardid(String sinoCardid) {
		List<CommonInfo> commonInfoList = commonInfoMapper.findInfoListBySinocardid(sinoCardid);
		List<CommonInfoVo> commonInfoVos = new ArrayList<>();
		if (!CollectionUtils.isEmpty(commonInfoList)) {
			for (CommonInfo commonInfo : commonInfoList) {
				CommonInfoVo commonInfoVo = new CommonInfoVo();
				commonInfoVo.setContent(commonInfo.getContent());
				commonInfoVo.setDataFrom(commonInfo.getDataFrom());
				commonInfoVos.add(commonInfoVo);
			}
		}
		return commonInfoVos;
	}

}
