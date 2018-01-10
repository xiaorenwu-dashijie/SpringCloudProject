package com.sinoway.cisp.service;

import com.sinoway.cisp.entitys.User;

public interface DataControllerService {

	/**
	 * 获取贷前审核报告
	 * 
	 * @param user
	 * @param sinoCardid
	 * @param cellPhoneNum
	 * @param reportId
	 * @return
	 */
	String getInFinReport(User user, String sinoCardid, String cellPhoneNum);

	/**
	 * 获取存量预警报告
	 * 
	 * @param cellPhoneNum
	 * @param sinoCardid
	 * @param user
	 * @return
	 */
	String getPostLoanReport(User user, String sinoCardid, String cellPhoneNum);

}
