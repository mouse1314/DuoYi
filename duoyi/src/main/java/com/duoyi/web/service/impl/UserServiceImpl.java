package com.duoyi.web.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.List;

import com.duoyi.dao.UserGeneratorMapper;
import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.model.po.UserGenerator;
import com.duoyi.util.DateTimeUtils;
import com.duoyi.util.MD5Util;
import com.duoyi.web.service.UserService;
import com.duoyi.model.vo.UserVo;
import com.duoyi.model.vo.UserVo2;


/**
 * @author 浩子
 *2018年10月22日
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserGeneratorMapper userMapper;
	
	private MD5Util md5 = new MD5Util();
	
	@Override
	public String saveUser(UserGenerator user) {
		boolean result = false;
		Date date = new Date();
		
		
		try {
			//判断用户是否被注册
			UserGenerator user1 = userMapper.selectUserByUsername(user.getUsername());
			if(user1 != null){
				return "此账号已被注册";
			}
			
			if(user.getPassword() == null || "".equals(user.getPassword())){
				return "密码为空";
			}
			
			//对用户进行MD5加密
			String password = md5.getMD5(user.getPassword(),user.getUsername());
			user.setPassword(password);
			
			//进行用户名的校验
			String name = user.getName();
			if(name == null || "".equals(name)){
				return "姓名为空";
			}
			
			if(name.contains("<") || name.contains(">")){
				return "用户名带有非法字符<或者>";
			}
			
			//设置用户当前注册时间
			user.setRegisterTime(date);
			userMapper.insert(user);
		} catch (Exception e) {
			return "注册失败";
		}
		
		return "注册成功";
	}

	@Override
	public int selectPassByUsername(UserVo user) {
		String RealPassword = userMapper.selectPassByUsername(user.getUsername());
		String MD5Pass = null;
		try {
			MD5Pass = MD5Util.getMD5(user.getPassword(), user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(RealPassword==null){
			System.out.println("不存在该账号");
			return 0;
		}else if(!RealPassword.equals(MD5Pass)){
			System.out.println("密码错误");
			return -1;
		}
		return 1;
		
	}

	@Override
	public int getUserId(String username) {
		return userMapper.getUserId(username);
	}

	@Override
	public int updateUser(UserGenerator user) {
		try {
			user.setPassword(null);
//			user.setPassword(md5.getMD5(user.getPassword(), user.getUsername()));
			return userMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
		
	}

	@Override
	public UserVo2 getUser(int userid) {
		UserGenerator user = userMapper.getUser(userid);
		
		return new UserVo2(user);
	}

	@Override
	public String selectNameById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectNameById(id);
	}

	@Override
	public void updateImg(String img,int userid) {
		// TODO Auto-generated method stub
		userMapper.updateImg(img, userid);
	}


	

}
