package com.duoyi.web.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.UserGeneratorMapper;
import com.duoyi.model.po.UserGenerator;
import com.duoyi.web.service.UserSerivice;

/**
 * @author 浩子
 *2018年10月22日
 */
@Service(value="UserServiceImpl")
public class UserServiceImpl implements UserSerivice {
	
	@Autowired
	private UserGeneratorMapper userMapper;
	
	
	@Override
	public boolean saveUser(UserGenerator user) {
		boolean result = false;
		
		try {
			userMapper.insert(user);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
