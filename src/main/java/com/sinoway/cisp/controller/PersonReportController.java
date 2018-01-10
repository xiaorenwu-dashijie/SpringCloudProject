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

import com.sinoway.cisp.entitys.PersonReport;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.CheckSignService;
import com.sinoway.cisp.service.PersonReportService;
import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.service.UserService;
import com.sinoway.cisp.utils.IPUtil;
import com.sinoway.cisp.utils.JsonUtils;

@Controller
@RequestMapping("/CISPReport")
public class PersonReportController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PersonReportController.class);

	@Resource
	private PersonReportService personReportService;
	@Autowired
	private ResponseJsonService responseJsonService;
	@Autowired
	private CheckSignService checkSignService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getPersonReport", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getPersonReport(@RequestParam(value = "key", required = false) String key,
			@RequestParam(value = "sign", required = false) String sign,
			@RequestParam(value = "cmd", required = false) String cmd,
			@RequestParam(value = "isgetreport", required = false) String isgetreport,
			@RequestParam(value = "version", required = false) String version,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "cardid", required = false) String cardid,
			@RequestParam(value = "cellPhoneNum", required = false) String cellPhoneNum,HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		String ip = IPUtil.getIP(req);
		if (ip!=null) {
			MDC.put("ip", ip);
		}
		if (StringUtils.isBlank(key) || StringUtils.isBlank(sign) || StringUtils.isBlank(cmd)
				|| StringUtils.isBlank(version) || StringUtils.isBlank(name) || StringUtils.isBlank(cardid)
				|| StringUtils.isBlank(cardid) || StringUtils.isBlank(cellPhoneNum)) {
			LOGGER.error(key + " 请求参数有空值");
			return responseJsonService.creaRespJson(false, "1003", null, null, null, null);
		}      
		String errorCode = checkSignService.check(key, sign, cmd, isgetreport, version, name, cardid, cellPhoneNum);
		String result;
		if (null != errorCode) {
			result = responseJsonService.creaRespJson(false, errorCode, null, null, null, null);
			LOGGER.info(key + " 调用个人信用报告成功,用户检验失败,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			return result;
		} else {
			User user = userService.selectUserByKey(key);
			PersonReport personReportResult = personReportService.getPersonReport(name, cardid, cellPhoneNum, user);
			String reportJson = "{\"success\":\"true\",\"detail\":{\"person_report\":"
					+ JsonUtils.objectToJson(personReportResult) + "}}";
			LOGGER.info("调用个人信用报告成功,总耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
			return reportJson;
		}

	}

}
