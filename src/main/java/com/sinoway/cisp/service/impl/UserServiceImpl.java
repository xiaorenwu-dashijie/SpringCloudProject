package com.sinoway.cisp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinoway.cisp.dao.UserMapper;
import com.sinoway.cisp.entitys.User;
import com.sinoway.cisp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过key查找用户
	 */
	public User selectUserByKey(String key) {
		User user = userMapper.findUserByKey(key);
		return user;
	}

}
