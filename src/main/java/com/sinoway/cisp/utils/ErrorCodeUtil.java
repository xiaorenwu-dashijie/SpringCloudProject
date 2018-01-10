package com.sinoway.cisp.utils;
/**
 * 获取错误码的字符串
 * @author dell
 *
 */
public class ErrorCodeUtil {

	/**
	 * 获取大数据风控项接口的错误码
	 * @param code
	 * @return
	 */
	public static String getErrorCodeJson4DataCtrl(String code) {
		return "{\"code\":\""+code+ "\"}";
	}
}
