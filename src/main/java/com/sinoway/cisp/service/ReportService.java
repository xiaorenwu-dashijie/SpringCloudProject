package com.sinoway.cisp.service;

import com.sinoway.cisp.entitys.User;

public interface ReportService {

	/**
	 * 获取个人征信报告
	 * 
	 * @param reportId
	 * @param sinoCardid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String getReport(String reportId, String sinoCardid, User user) throws Exception;

}
