package com.sinoway.cisp.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.sinoway.cisp.entitys.User;

@Service
public interface SearchService {
	/**
	 * 
	 * @param reportId
	 *            报告编号
	 * @param user
	 *            用户
	 * @param sinoid
	 *            唯一标识
	 * @param reqReason
	 *            查询原因
	 * @param reqTime
	 *            查询时间
	 * @param sinoCardid
	 *            华道身份证号
	 * @param sinotime
	 *            操作时间
	 */
	public void insSearchReport(String reportId, User user, String sinoid, String reqReason, Date reqTime,
			String sinoCardid, Date sinotime);
}