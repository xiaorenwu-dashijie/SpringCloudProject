package com.sinoway.cisp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinoway.cisp.dao.AuthMapper;
import com.sinoway.cisp.dao.InstiDetailMapper;
import com.sinoway.cisp.dao.RoleAuthMapper;
import com.sinoway.cisp.dao.RoleMapper;
import com.sinoway.cisp.dao.UserMapper;
import com.sinoway.cisp.entitys.Auth;
import com.sinoway.cisp.entitys.InstiDetail;
import com.sinoway.cisp.entitys.Role;
import com.sinoway.cisp.entitys.RoleAuth;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.utils.DateUtils;
import com.sinoway.cisp.utils.HttpClientUtils;
import com.sinoway.cisp.utils.JsonUtils;

@Component
public class SyncService {

	private static Logger LOGGER = LoggerFactory.getLogger(SyncService.class);

	@Autowired
	private InstiDetailMapper instiDetailMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleAuthMapper roleAuthMapper;
	@Autowired
	private AuthMapper authMapper;
	@Value("${crm_instidetail_url}")
	private String crm_instidetail_url;
	@Value("${crm_instiuser_url}")
	private String crm_instiuser_url;
	@Value("${cispweb_role_auth_url}")
	private String cispweb_role_auth_url;

//	 @Async
//	 @Scheduled(cron = "${crm_instidetail_cron}")
	public void syncInstiDetail() {
		Map<String, String> params = new HashMap<>();
		String result = HttpClientUtils.sendPostRequest(crm_instidetail_url, params, null, null);
		if (StringUtils.isEmpty(result)) {
			LOGGER.info("昨天{}没有机构信息变更", DateUtils.dateToStr(new Date()));
		} else {
			List<InstiDetail> instiDetails = JsonUtils.jsonToList(result, InstiDetail.class);
			for (InstiDetail crmInstiDetail : instiDetails) {
				String serviceIdString = crmInstiDetail.getServiceIdString();
				InstiDetail cispInstiDetail = instiDetailMapper.selectByPrimaryKey(crmInstiDetail.getInstiCode());
				if (serviceIdString.contains("B001")) {
					if (cispInstiDetail == null) {
						instiDetailMapper.insert(crmInstiDetail);
					} else {
						instiDetailMapper.updateByPrimaryKey(crmInstiDetail);
					}
				} else {
					if (cispInstiDetail != null) {
						instiDetailMapper.deleteByPrimaryKey(crmInstiDetail.getInstiCode());
					}
				}
			}
		}
	}

//	 @Async
//	 @Scheduled(cron = "${crm_instiuser_cron}")
	public void syncInstiUser() {
		Map<String, String> params = new HashMap<>();
		String result = HttpClientUtils.sendPostRequest(crm_instiuser_url, params, null, null);
		System.out.println(result);
		if (StringUtils.isEmpty(result)) {
			LOGGER.info("昨天{}没有用户信息变更", DateUtils.dateToStr(new Date()));
		} else {
			List<User> crmInstiUsers = JsonUtils.jsonToList(result, User.class);
			for (User crmInstiUser : crmInstiUsers) {
				String funCodeFormat = crmInstiUser.getFunCodeFormat();
				User cispUser = userMapper.selectByPrimaryKey(crmInstiUser.getUserId());
				if (funCodeFormat.contains("B001")) {
					if (cispUser == null) {
						userMapper.insert(crmInstiUser);
					} else {
						userMapper.updateByPrimaryKey(crmInstiUser);
					}
				} else {
					if (cispUser != null) {
						userMapper.deleteByPrimaryKey(cispUser.getUserId());
					}
				}
			}
		}
	}

//	@Async
//	@Scheduled(cron = "${cispweb_role_auth_cron}")
	public void syncRoleAndAuth() {

		int a = roleMapper.deleteAllRole();
		int b = roleAuthMapper.deleteAllRoleAuth();
		int c = authMapper.deleteAllAuth();
		LOGGER.info("删除{}条角色", a);
		LOGGER.info("删除{}权限", c);
		LOGGER.info("删除{}条角色&权限中间表", b);

		String result = HttpClientUtils.sendPostRequest(cispweb_role_auth_url, "", false);
		List<String> jsonToList = JsonUtils.jsonToList(result, String.class);
		String roleListStr = jsonToList.get(0);
		List<Role> roleList1 = JsonUtils.jsonToList(roleListStr, Role.class);
		for (Role role : roleList1) {
			roleMapper.insert(role);
		}

		String roleAuthListStr = jsonToList.get(1);
		List<RoleAuth> roleAuthList = JsonUtils.jsonToList(roleAuthListStr, RoleAuth.class);
		for (RoleAuth roleAuth : roleAuthList) {
			roleAuthMapper.insert(roleAuth);
		}

		String authListStr = jsonToList.get(2);
		List<Auth> authList = JsonUtils.jsonToList(authListStr, Auth.class);
		for (Auth auth : authList) {
			authMapper.insert(auth);
		}
	}

}
