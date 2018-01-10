package com.sinoway.cisp.service;

import org.aspectj.lang.JoinPoint;

public interface SaveReportService {

	/**
	 * 切面调用方法：保存请求报文和响应报文到文件
	 * 
	 * @param joinPoint
	 * @param returnValue
	 * @return
	 */
	public void saveReqAndRes(JoinPoint joinPoint, String returnValue);

	/**
	 * 切面调用方法：保存黑名单的请求报文和响应报文到文件
	 * 
	 * @param joinPoint
	 * @param returnValue
	 */
	void saveBlackListReport(JoinPoint joinPoint, String returnValue);

	public void savePersonReport(JoinPoint joinPoint, String returnValue);

}
