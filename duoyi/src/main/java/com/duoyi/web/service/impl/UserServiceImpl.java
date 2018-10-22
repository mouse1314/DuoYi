package com.duoyi.web.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import com.duoyi.dao.UserGeneratorMapper;
import com.duoyi.model.po.UserGenerator;
import com.duoyi.util.DateTimeUtils;
import com.duoyi.util.MD5Util;
import com.duoyi.web.service.UserSerivice;


/**
 * @author 浩子
 *2018年10月22日
 */
@Service
public class UserServiceImpl implements UserSerivice {
	
	@Autowired
	private UserGeneratorMapper userMapper;
	
	private MD5Util md5 = new MD5Util();
	
	@Override
	public boolean saveUser(UserGenerator user) {
		boolean result = false;
		Date date = new Date();
		
		try {
			//对用户进行MD5加密
			String password = md5.getMD5(user.getPassword(),user.getUsername());
			if(password == null){
				return false;
			}
			user.setPassword(password);
			
			//设置用户当前注册时间
			user.setRegisterTime(date);
			userMapper.insert(user);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
