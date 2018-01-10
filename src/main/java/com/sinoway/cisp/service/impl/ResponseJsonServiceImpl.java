package com.sinoway.cisp.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.service.ResponseJsonService;
import com.sinoway.cisp.utils.IDUtil;

@Service
@Transactional
public class ResponseJsonServiceImpl implements ResponseJsonService {

	@Override
	public String creaRespJson(boolean isCallSuccess, String errorCode, String report, String mulReport, String service,
			String reportId) {
		String result = null;
		result = "{" + "\"success\":";
		if (isCallSuccess) {
			result += "\"true\"";
			if (StringUtils.isNotBlank(report)) {
				String token = IDUtil.getStringRandom(8);
				if (StringUtils.isNotBlank(mulReport)) {
					if ("7".equals(service)) {// 7代表贷前审核报告
						result += ",\"detail\":{\"token\":\"" + token.substring(0, 8) + "\",\"report\":" + report
								+ ",\"inclusive_finance_report\":" + mulReport + "}";
					} else if ("8".equals(service)) {// 8代表存量预警报告
						result += ",\"detail\":{\"token\":\"" + token.substring(0, 8) + "\",\"report\":" + report
								+ ",\"inventory_warn_report\":" + mulReport + "}";
					}
				} else {
					result += ",\"detail\":{\"token\":\"" + token.substring(0, 8) + "\",\"report\":" + report + "}";
				}
			}
		} else {
			result += "\"false\"";
			if (null != errorCode) {
				result += ",\"detail\":{\"ERROR_CODE\":\"" + errorCode + "\"}";
			}
		}
		result += "}";
		return result;
	}

}
