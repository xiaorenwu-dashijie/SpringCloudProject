package com.sinoway.cisp.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IPUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(IPUtil.class);

	public static String getIP(HttpServletRequest request) {
		String ip = null;
		try {
			ip = NetworkUtil.getIpAddress(request);
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.warn("获取IP异常");
		}
		return ip;
	}

}
