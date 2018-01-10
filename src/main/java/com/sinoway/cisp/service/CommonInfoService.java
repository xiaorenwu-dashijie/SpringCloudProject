package com.sinoway.cisp.service;

import java.util.List;

import com.sinoway.cisp.entitys.CommonInfoVo;

public interface CommonInfoService {

	/**
	 * 根据姓名、身份证号查询公共信用信息
	 * 
	 * @param name
	 * @param cardid
	 * @return
	 */
	List<CommonInfoVo> findInfoListBySinocardid(String sinoCardid);

}
