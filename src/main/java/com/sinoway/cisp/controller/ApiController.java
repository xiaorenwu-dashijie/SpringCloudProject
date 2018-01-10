package com.sinoway.cisp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CheckSignService;
import com.sinoway.cisp.service.CispBasicApiService;
import com.sinoway.cisp.service.CispBasicDataApiService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.SinoBodyService;
import com.sinoway.cisp.service.UserService;
import com.sinoway.cisp.utils.IDUtil;
import com.sinoway.cisp.utils.IPUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/CISPApi")
@Api("ApiController的api")
public class ApiController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

	@Resource(name = "loanService")
	private CispBasicApiService loanService;
	@Resource(name = "contractService")
	private CispBasicApiService contractService;
	@Resource(name = "collectionService")
	private CispBasicApiService collectionService;
	@Resource(name = "debtService")
	private CispBasicApiService debtService;
	@Resource(name = "inventoryService")
	private CispBasicApiService inventoryService;
	@Resource(name = "blackService")
	private CispBasicDataApiService blackListService;

	@Autowired
	private CheckSignService checkSignService;
	@Autowired
	private UserService userService;
	@Autowired
	private ResponseJsonService responseJsonService;

	@Autowired
	private SinoBodyService sinoBodyService;

	@ApiOperation("获取征信报告")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "key", dataType = "String", required = true, value = "用户公钥", defaultValue = "55268679"),
			@ApiImplicitParam(paramType = "query", name = "sign", dataType = "String", required = true, value = "MD5加密串"),
			@ApiImplicitParam(paramType = "query", name = "cmd", dataType = "String", required = true, value = "命令参数"),
			@ApiImplicitParam(paramType = "query", name = "isgetreport", dataType = "String", required = true, value = "是否要报告", defaultValue = "1"),
			@ApiImplicitParam(paramType = "query", name = "version", dataType = "String", required = true, value = "cisp版本号", defaultValue = "V2.0"),
			@ApiImplicitParam(paramType = "query", name = "name", dataType = "String", required = true, value = "姓名"),
			@ApiImplicitParam(paramType = "query", name = "cardid", dataType = "String", required = true, value = "身份证号"),
			@ApiImplicitParam(paramType = "query", name = "crid", dataType = "String", required = true, value = "申请编号/合同编号"),
			@ApiImplicitParam(paramType = "query", name = "data", dataType = "String", required = true, value = "请求参数") })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数错误"), @ApiResponse(code = 404, message = "用户认证失败") })
	@RequestMapping(value = "/pushLoanInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody String pushLoanInfo(@RequestParam(value = "key", required = false) String key,
			@RequestParam(value = "sign", required = false) String sign,
			@RequestParam(value = "cmd", required = false) String cmd,
			@RequestParam(value = "isgetreport", required = false) String isgetreport,
			@RequestParam(value = "version", required = false) String version,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "cardid", required = false) String cardid,
			@RequestParam(value = "crid", required = false) String crid,
			@RequestParam(value = "data", required = false) String data, HttpServletRequest req,
			HttpServletResponse res) {
		long currentTimeMillis = System.currentTimeMillis();
		String ip = IPUtil.getIP(req);
		if (ip != null) {
			MDC.put("ip", ip);
		}
		String result = null;
		if (StringUtils.isBlank(key) || StringUtils.isBlank(sign) || StringUtils.isBlank(cmd)
				|| StringUtils.isBlank(isgetreport) || StringUtils.isBlank(version) || StringUtils.isBlank(name)
				|| StringUtils.isBlank(cardid) || StringUtils.isBlank(crid) || StringUtils.isBlank(data)) {
			LOGGER.error(key + " 请求参数有空值");
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}
		String errorCode = checkSignService.check(key, sign, cmd, isgetreport, version, name, cardid, crid);
		if (null != errorCode) {
			result = responseJsonService.creaRespJson(false, errorCode, null, null, null, null);
			LOGGER.info(key + " 调用CISP成功,用户检验失败,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
		} else {
			User user = userService.selectUserByKey(key);
			try {
				String reportId = IDUtil.getSinoId(user.getInstiCode(), "Q");
				String sinoCardid = sinoBodyService.findSinoCardidByCardid(name, cardid);
				if (cmd.equals("loan")) {
					result = loanService.pushLoanInfo(user, cmd, isgetreport, version, reportId, sinoCardid, crid,
							data);
				} else if (cmd.equals("cont")) {
					result = contractService.pushLoanInfo(user, cmd, isgetreport, version, reportId, sinoCardid, crid,
							data);
				} else if (cmd.equals("up")) {
					result = debtService.pushLoanInfo(user, cmd, isgetreport, version, reportId, sinoCardid, crid,
							data);
				} else if (cmd.equals("over")) {
					result = collectionService.pushLoanInfo(user, cmd, isgetreport, version, reportId, sinoCardid, crid,
							data);
				} else if (cmd.equals("stock")) {
					result = inventoryService.pushLoanInfo(user, cmd, isgetreport, version, reportId, sinoCardid, crid,
							data);
				} else {
					result = responseJsonService.creaRespJson(false, "1003", null, null, null, null);
				}
			} catch (Exception e) {
				result = responseJsonService.creaRespJson(false, "1003", null, null, null, null);
			}
			LOGGER.info("调用CISP成功,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
		}
		return result;
	}

	@RequestMapping(value = "/pushCreditData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String pushCreditData(@RequestParam(value = "key", required = false) String key,
			@RequestParam(value = "sign", required = false) String sign,
			@RequestParam(value = "datatype", required = false) String datatype,
			@RequestParam(value = "version", required = false) String version,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "cardid", required = false) String cardid,
			@RequestParam(value = "data", required = false) String data, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		String ip = IPUtil.getIP(req);
		if (ip != null) {
			MDC.put("ip", ip);
		}
		String result = null;
		if (StringUtils.isBlank(key) || StringUtils.isBlank(sign) || StringUtils.isBlank(datatype)
				|| StringUtils.isBlank(version) || StringUtils.isBlank(name) || StringUtils.isBlank(cardid)
				|| StringUtils.isBlank(data)) {
			LOGGER.error(key + " 请求参数有空值");
			result = responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		} else {
			String errorCode = checkSignService.check(key, sign, datatype, null, version, name, cardid, null);
			if (null != errorCode) {
				result = responseJsonService.creaRespJson(false, errorCode, null, null, null, null);
				LOGGER.info(key + " 调用报送黑名单成功,用户检验失败,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			} else {
				User user = userService.selectUserByKey(key);
				String sinoCardid = sinoBodyService.findSinoCardidByCardid(name, cardid);
				result = blackListService.pushCreditData(user, datatype, version, sinoCardid, data);
				LOGGER.info("调用报送黑名单成功,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			}
		}
		return result;
	}

	@RequestMapping(value = "/getCreditData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getCreditData(@RequestParam(value = "key", required = false) String key,
			@RequestParam(value = "sign", required = false) String sign,
			@RequestParam(value = "datatype", required = false) String datatype,
			@RequestParam(value = "version", required = false) String version,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "cardid", required = false) String cardid,
			@RequestParam(value = "qreason", required = false) String qreason, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		String ip = IPUtil.getIP(req);
		if (ip != null) {
			MDC.put("ip", ip);
		}
		String result = null;
		if (StringUtils.isBlank(key) || StringUtils.isBlank(sign) || StringUtils.isBlank(datatype)
				|| StringUtils.isBlank(version) || StringUtils.isBlank(name) || StringUtils.isBlank(cardid)
				|| StringUtils.isBlank(qreason)) {
			LOGGER.error(key + " 请求参数有空值");
			result = responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		} else {
			String errorCode = checkSignService.check(key, sign, datatype, null, version, name, cardid, null);
			if (null != errorCode) {
				result = responseJsonService.creaRespJson(false, errorCode, null, null, null, null);
				LOGGER.info(key + " 调用查询黑名单成功,用户检验失败,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			} else {
				User user = userService.selectUserByKey(key);
				String sinoCardid = sinoBodyService.findSinoCardidByCardid(name, cardid);
				result = blackListService.getCreditData(user, datatype, version, sinoCardid, qreason);
				LOGGER.info("调用查询黑名单成功,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			}
		}
		return result;
	}
}
