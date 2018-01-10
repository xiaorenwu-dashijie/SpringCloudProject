package com.sinoway.cisp.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvoInclFinaAPIUtil {

	/**
	 * 日志 写入到 工作空间/log/CISPTest.txt 文件中
	 */
	private final static Logger logger = LoggerFactory.getLogger(InvoInclFinaAPIUtil.class);

	/**
	 * 调用接口 获取普惠金融风控报告基础版/专业版数据
	 * 
	 * @param URL
	 *            CISPCredit/InclusiveFinance/QueryInclusiveFinanceData
	 * @param userAccount
	 *            用户账户
	 * @param userPwd
	 *            用户密码
	 * @param basOrPro
	 *            基础版(0)或者专业版(1)
	 * @param name
	 *            姓名
	 * @param idCard
	 *            身份证号
	 * @param phone
	 *            手机号
	 * @param queryPurpose
	 *            查询目的 1:信贷审批/2:贷后管理
	 * @param token
	 *            token
	 * @return 调用接口返回值
	 * @throws Exception
	 */
	public static String connectInclFinaAPI(String URL, String userAccount, String userPwd, String basOrPro,
			String name, String idCard, String phone, String queryPurpose, String token) throws Exception {

		name = URLEncoder.encode(name, "utf-8"); // 转译中文姓名
		String strURL = URL + "?userName=" + userAccount + "&userPwd=" + userPwd + "&basOrPro=" + basOrPro + "&name="
				+ name + "&idCard=" + idCard + "&phone=" + phone + "&queryPurpose=" + queryPurpose + "&token=" + token;

		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setConnectTimeout(1000);// 连接主机的超时时间（单位：毫秒）
		httpConn.setReadTimeout(1000);// 从主机读取数据的超时时间（单位：毫秒）
		httpConn.setRequestMethod("POST");
		httpConn.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		httpConn.disconnect();
		return buffer.toString();
	}

	/**
	 * 调用接口 获取token
	 * 
	 * @param URL
	 *            CISPCredit/InclusiveFinance/GetToken
	 * @param userAccount
	 *            用户账户(对应数据库中的user_account字段)
	 * @param userpwd
	 *            用户密码
	 * @return token 获取的token值
	 */
	public static String getToken(String URL, String userAccount, String userpwd) {
		try {
			String strURL = URL + "?userName=" + userAccount + "&userPwd=" + userpwd;
			URL url = new URL(strURL);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");
			httpConn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			httpConn.disconnect();
			return buffer.toString();
		} catch (Exception e) {
			logger.info("InvoInclFinaAPIUtil异常捕获:\n{}", e.toString());
		}
		return null;
	}

}
