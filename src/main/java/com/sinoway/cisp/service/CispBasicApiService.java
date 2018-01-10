package com.sinoway.cisp.service;

import org.springframework.stereotype.Service;
import com.sinoway.cisp.entitys.User;
@Service
public interface CispBasicApiService {
	public String pushLoanInfo(
			User user,
			String cmd, 
			String isgetreport, 
			String version,
			String reportId,
			String sinoCardid,
			String crid,
			String data) throws Exception;
}
