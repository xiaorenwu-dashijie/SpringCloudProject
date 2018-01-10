package com.sinoway.cisp.service;

import org.springframework.stereotype.Service;

@Service
public interface CheckSignService {

	/**
	 * 检查各种信息，并将提取信息主体信息插入数据库中
	 * 
	 * @param key
	 *            公钥
	 * @param sign
	 *            签名
	 * @param cmd
	 *            查询类型
	 * @param isgetreport
	 *            是否需要返回报告
	 * @param version
	 *            接口版本号
	 * @param name
	 *            姓名
	 * @param cardid
	 *            身份证号
	 * @param crid
	 *            会员编号
	 * @return
	 */
	public String check(String key, String sign, String cmd, String isgetreport, String version, String name,
			String cardid, String crid);

	/**
	 * 
	 * @param key
	 *            公钥
	 * @param sign
	 *            签名
	 * @param datatype
	 *            数据类型
	 * @param version
	 *            接口版本号
	 * @param name
	 *            姓名
	 * @param cardid
	 *            身份证号
	 * @return
	 */
	// public String check(String key, String sign, String datatype, String
	// version, String name, String cardid);

	// public String checkAuth(String key, String sign, String cmd, String
	// isgetreport, String version, String name,
	// String cardid, String cellPhoneNum);
}
