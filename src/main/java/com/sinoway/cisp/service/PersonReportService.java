package com.sinoway.cisp.service;

import org.springframework.stereotype.Service;

import com.sinoway.cisp.entitys.PersonReport;
import com.sinoway.cisp.entitys.User;

@Service
public interface PersonReportService {

	PersonReport getPersonReport(String name, String cardid, String cellPhoneNum, User user) throws Exception;
	
}
