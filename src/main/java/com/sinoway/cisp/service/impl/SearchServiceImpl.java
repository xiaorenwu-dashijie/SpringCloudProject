package com.sinoway.cisp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.SearchDetailMapper;
import com.sinoway.cisp.entitys.SearchDetail;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.SearchService;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDetailMapper searchDetailMapper;

	public void insSearchReport(String reportId, User user, String sinoid, String reqReason, Date reqTime,
			String sinoCardid, Date sinotime) {

		SearchDetail searchDetail = new SearchDetail();
		int count = searchDetailMapper.findSearCountBySinocardid(sinoCardid);
		if (count > 0) {
			searchDetail.setIschecked("1");
		} else {
			searchDetail.setIschecked("0");
		}
		searchDetail.setReportId(reportId);
		searchDetail.setSinoid(sinoid);
		searchDetail.setUserAccount(user.getUserAccount());
		searchDetail.setReqReason(reqReason);
		searchDetail.setReqTime(reqTime);
		searchDetail.setSinoCardid(sinoCardid);
		searchDetail.setSinotime(sinotime);

		searchDetailMapper.insert(searchDetail);
	}
}