package com.sinoway.cisp.service;

import java.util.List;

import com.sinoway.cisp.entitys.BlackListVo;
import com.sinoway.cisp.entitys.User;

public interface BlackListReportService {

	/**
	 * 严重失信行为记录，（5年）按照报送时间算
	 * 
	 * @param cardid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<BlackListVo> getBlackListReport(String sinoCardid, User user);
}