package com.sinoway.cisp.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.SearchDetailMapper;
import com.sinoway.cisp.entitys.SearchDetail;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.SaveReportService;
import com.sinoway.cisp.service.UserService;
import com.sinoway.cisp.utils.Base64Utils;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.JsonValidator;

@Service
@Transactional
public class SaveReportServiceImpl implements SaveReportService {

	private static Logger LOGGER = LoggerFactory.getLogger(SaveReportServiceImpl.class);

	@Autowired
	private SearchDetailMapper searchDetailMapper;
	@Autowired
	private UserService userService;

	@Async
	public void saveReqAndRes(JoinPoint joinPoint, String returnValue) {
		Object[] args = joinPoint.getArgs();
		// 1.获得需要写入文件的内容,时间、请求数据和返回结果
		StringBuffer reqSb = new StringBuffer();
		reqSb.append("{");
		reqSb.append("\"key\":" + "\"" + args[0] + "\"" + ",");
		reqSb.append("\"sign\":" + "\"" + args[1] + "\"" + ",");
		reqSb.append("\"cmd\":" + "\"" + args[2] + "\"" + ",");
		reqSb.append("\"isgetreport\":" + "\"" + args[3] + "\"" + ",");
		reqSb.append("\"version\":" + "\"" + args[4] + "\"" + ",");
		reqSb.append("\"name\":" + "\"" + args[5] + "\"" + ",");
		reqSb.append("\"cardid\":" + "\"" + args[6] + "\"" + ",");
		reqSb.append("\"crid\":" + "\"" + args[7] + "\"" + ",");
		String dest = "";
		String str = args[8].toString();
		if (str != null) {
			Pattern p = Pattern.compile("\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		reqSb.append("\"data\":" + dest);
		reqSb.append("}");
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"time\":" + "\"" + DateUtils.nowFormat("yyyy-MM-dd HH:mm:ss") + "\"" + ",");
		sb.append("\"request\":" + reqSb.toString() + ",");
		sb.append("\"response\":" + returnValue);
		sb.append("}");
		sb.append("\r\n");
		// 2.获得机构代码，如果没找到该用户，则用key值代替
		User user = userService.selectUserByKey(args[0].toString());
		String instiCode = null;
		if (user != null) {
			instiCode = user.getInstiCode();
		} else {
			instiCode = args[0].toString();
		}
		// 3.创建文件夹
		String filePath = "/var/cispJsonReport/creditReport/" + instiCode + "/";
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 4.创建文件,写入数据
		String fileName = DateUtils.nowFormat("yyyy-MM-dd");
		String fileAllPath = filePath + fileName;
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileAllPath, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.write(sb.toString().getBytes());
			randomFile.close();
			LOGGER.info("保存生命周期报文成功", returnValue);
			// 5.更新SearchDetail
			JSONObject jsonObject = new JSONObject(returnValue);
			String string = jsonObject.getString("success");
			if ("true".equals(string)) {
				JSONObject contentObject = new JSONObject(returnValue);
				if (contentObject.has("detail")) {
					JSONObject detailJsonObject = contentObject.getJSONObject("detail");
					if (detailJsonObject.has("report")) {
						JSONObject reportJsonObject = detailJsonObject.getJSONObject("report");
						String encodeReportId = reportJsonObject.getString("report_id");
						String decodeReportId = Base64Utils.decodeReportId(encodeReportId);
						SearchDetail searchDetail = searchDetailMapper.selectByPrimaryKey(decodeReportId);
						searchDetail.setResultAdd(fileAllPath);

						String serviceCode = searchDetail.getServiceCode();
						if (detailJsonObject.has("inclusive_finance_report")) {
							JSONObject inFinReportJsonObject = detailJsonObject
									.getJSONObject("inclusive_finance_report");
							String code = inFinReportJsonObject.getString("code");
							if ("200".equals(code)) {
								String iscreditrecord = inFinReportJsonObject.getString("iscreditrecord");
								if ("1".equals(iscreditrecord)) {
									if (StringUtils.isNotEmpty(serviceCode)) {
										serviceCode = serviceCode + ",71";
									} else {
										serviceCode = "71";
									}
								} else {
									if (StringUtils.isNotEmpty(serviceCode)) {
										serviceCode = serviceCode + ",70";
									} else {
										serviceCode = "70";
									}
								}
							} else {
								LOGGER.info("贷前审核调用失败，错误代码：{}", code);
							}
						} else if (detailJsonObject.has("inventory_warn_report")) {
							JSONObject inWarnReportJsonObject = detailJsonObject.getJSONObject("inventory_warn_report");
							String code = inWarnReportJsonObject.getString("code");
							if ("200".equals(code)) {
								String iscreditrecord = inWarnReportJsonObject.getString("iscreditrecord");
								if ("1".equals(iscreditrecord)) {
									if (StringUtils.isNotEmpty(serviceCode)) {
										serviceCode = serviceCode + ",81";
									} else {
										serviceCode = "81";
									}
								} else {
									if (StringUtils.isNotEmpty(serviceCode)) {
										serviceCode = serviceCode + ",80";
									} else {
										serviceCode = "80";
									}
								}
							} else {
								LOGGER.info("存量预警调用失败，错误代码：{}", code);
							}
						}
						searchDetail.setServiceCode(serviceCode);
						searchDetailMapper.updateByPrimaryKey(searchDetail);
					}
				}
			}
		} catch (JSONException e) {
			LOGGER.warn("解析响应报文异常:{}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.warn("请求/响应 报告保存异常:{}", e.getMessage());
		}
	}

	@Async
	public void saveBlackListReport(JoinPoint joinPoint, String returnValue) {
		Object[] args = joinPoint.getArgs();
		// 1.获得需要写入文件的内容,时间、请求数据和返回结果
		StringBuffer reqSb = new StringBuffer();
		reqSb.append("{");
		reqSb.append("\"key\":" + "\"" + args[0] + "\"" + ",");
		reqSb.append("\"sign\":" + "\"" + args[1] + "\"" + ",");
		reqSb.append("\"datatype\":" + "\"" + args[2] + "\"" + ",");
		reqSb.append("\"version\":" + "\"" + args[3] + "\"" + ",");
		reqSb.append("\"name\":" + "\"" + args[4] + "\"" + ",");
		reqSb.append("\"cardid\":" + "\"" + args[5] + "\"" + ",");
		String dest = "";
		String str = args[6].toString();
		if (str != null) {
			Pattern p = Pattern.compile("\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		boolean validate = JsonValidator.validate(dest);
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(dest);
		boolean matches = isNum.matches();
		boolean isPush = validate && !matches;
		if (isPush) {
			reqSb.append("\"data\":" + dest);
		} else {
			reqSb.append("\"qreason\":" + "\"" + args[6] + "\"");
		}
		reqSb.append("}");
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"time\":" + "\"" + DateUtils.nowFormat("yyyy-MM-dd HH:mm:ss") + "\"" + ",");
		sb.append("\"request\":" + reqSb.toString() + ",");
		sb.append("\"response\":" + returnValue);
		sb.append("}");
		sb.append("\r\n");
		// 2.获得机构代码，如果没找到该用户，则用key值代替
		User user = userService.selectUserByKey(args[0].toString());
		String instiCode = null;
		if (user != null) {
			instiCode = user.getInstiCode();
		} else {
			instiCode = args[0].toString();
		}
		// 3.创建文件夹
		String filePath = null;
		if (isPush) {
			filePath = "/var/cispJsonReport/blackListReport/pushCreditData/" + instiCode + "/";
		} else {
			filePath = "/var/cispJsonReport/blackListReport/getCreditData/" + instiCode + "/";
		}
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 4.创建文件,写入数据
		String fileName = DateUtils.nowFormat("yyyy-MM-dd");
		String fileAllPath = filePath + fileName;
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileAllPath, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.write(sb.toString().getBytes());
			randomFile.close();
			LOGGER.info("保存黑名单报文成功");
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.warn("黑名单报告保存文件异常:{}", e.getMessage());
		}
	}

	@Override
	public void savePersonReport(JoinPoint joinPoint, String returnValue) {
		Object[] args = joinPoint.getArgs();
		// 1.获得需要写入文件的内容,时间、请求数据和返回结果
		StringBuffer reqSb = new StringBuffer();
		reqSb.append("{");
		reqSb.append("\"key\":" + "\"" + args[0] + "\"" + ",");
		reqSb.append("\"sign\":" + "\"" + args[1] + "\"" + ",");
		reqSb.append("\"cmd\":" + "\"" + args[2] + "\"" + ",");
		reqSb.append("\"isgetreport\":" + "\"" + args[3] + "\"" + ",");
		reqSb.append("\"version\":" + "\"" + args[4] + "\"" + ",");
		reqSb.append("\"name\":" + "\"" + args[5] + "\"" + ",");
		reqSb.append("\"cardid\":" + "\"" + args[6] + "\"" + ",");
		reqSb.append("\"cellPhoneNum\":" + "\"" + args[7] + "\"" + ",");
		reqSb.append("}");
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"time\":" + "\"" + DateUtils.nowFormat("yyyy-MM-dd HH:mm:ss") + "\"" + ",");
		sb.append("\"request\":" + reqSb.toString() + ",");
		sb.append("\"response\":" + returnValue);
		sb.append("}");
		sb.append("\r\n");
		// 2.创建文件夹
		String filePath = "/var/cispJsonReport/personReport/";
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 3.创建文件,写入数据
		String fileName = DateUtils.nowFormat("yyyy-MM-dd");
		String fileAllPath = filePath + fileName;
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileAllPath, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.write(sb.toString().getBytes());
			randomFile.close();
			LOGGER.info("保存个人信用报告报文成功", returnValue);
			// 4.更新searchDetail
			JSONObject jsonObject = new JSONObject(returnValue);
			String string = jsonObject.getString("success");
			if ("true".equals(string)) {
				JSONObject contentObject = new JSONObject(returnValue);
				if (contentObject.has("detail")) {
					JSONObject detailJsonObject = contentObject.getJSONObject("detail");
					if (detailJsonObject.has("person_report")) {
						JSONObject reportJsonObject = detailJsonObject.getJSONObject("person_report");
						String personReportId = reportJsonObject.getString("personReportId");
						SearchDetail searchDetail = searchDetailMapper.selectByPrimaryKey(personReportId);
						searchDetail.setResultAdd(fileAllPath);
						searchDetailMapper.updateByPrimaryKey(searchDetail);
					}
				}
			}
		} catch (JSONException e) {
			LOGGER.warn("解析响应报文异常:{}", e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.warn("个人信用报告保存文件异常:{}", e.getMessage());
		}
	}
}
