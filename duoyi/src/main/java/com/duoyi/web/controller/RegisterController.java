package com.duoyi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.UserGenerator;
import com.duoyi.web.service.UserSerivice;

/**
 * @author 浩子
 *
 */
@Controller
public class RegisterController {

	@Autowired
	private UserSerivice userSerivice;
	
	public @ResponseBody String register(@RequestBody UserGenerator user){
		
		boolean result = userSerivice.saveUser(user);
		
		if(result){
			return "注册成功";
		}else{
			return "注册失败";
		}
		
	}
	
}
