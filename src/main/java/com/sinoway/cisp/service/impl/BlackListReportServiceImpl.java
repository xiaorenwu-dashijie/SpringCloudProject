package com.sinoway.cisp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.BlacklistMapper;
import com.sinoway.cisp.entitys.BlackListVo;
import com.sinoway.cisp.entitys.Blacklist;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.BlackListReportService;
import com.sinoway.cisp.utils.DateUtils;

@Service
@Transactional
public class BlackListReportServiceImpl implements BlackListReportService {
	@Autowired
	private BlacklistMapper blackListMapper;

	@Override
	public List<BlackListVo> getBlackListReport(String sinoCardid, User user) {
		List<Blacklist> blacklists = blackListMapper.selectBlacListBySinocardid(sinoCardid);
		List<BlackListVo> bLackListVos = new ArrayList<>();
		for (Blacklist blacklist : blacklists) {
			BlackListVo bLackListVo = new BlackListVo();
			Date publicTime = blacklist.getPublicTime();
			if (publicTime != null) {
				bLackListVo.setPublic_time(DateUtils.dateToStr(publicTime));
			}
			Date overdueStartTime = blacklist.getOverdueStartTime();
			if (overdueStartTime != null) {
				bLackListVo.setOverdue_start_time(DateUtils.dateToStr(overdueStartTime));
			}
			String[] split = blacklist.getSinoid().split("-");
			String instiCode = split[2];
			if (user.getInstiCode().equals(instiCode)) {
				bLackListVo.setComment("1");// 备注：本机构
			} else {
				bLackListVo.setComment("3");// 备注：--
			}
			bLackListVo.setData_source("会员机构");
			bLackListVo.setEmail(blacklist.getEmail());
			bLackListVo.setLive_address(blacklist.getLiveAddress());
			bLackListVo.setLoan_location(blacklist.getLoanLocation());
			bLackListVo.setOverdue_duration(blacklist.getOverdueDuration());
			bLackListVo.setOverdue_money(blacklist.getOverdueMoney());
			bLackListVo.setPersonal_address(blacklist.getPersonalAddress());
			bLackListVo.setPhone(blacklist.getPhone());
			bLackListVo.setReason(blacklist.getReason());
			bLackListVos.add(bLackListVo);
		}
		return bLackListVos;
	}
}