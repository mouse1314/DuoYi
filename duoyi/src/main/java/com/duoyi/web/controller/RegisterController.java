package com.duoyi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.duoyi.model.po.UserGenerator;
import com.duoyi.web.service.UserService;

import net.sf.json.JSONObject;

/**
 * @author 浩子
 *
 */
@Controller
public class RegisterController {

	@Autowired
	private UserService userSerivice;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody JSONObject register(@RequestBody UserGenerator user){
		
		JSONObject json = new JSONObject();
		boolean result = userSerivice.saveUser(user);
		
		if(result){
			json.put("status", 1);
			json.put("message", "注册成功");
		}else{
			json.put("status", -1);
			json.put("message", "注册失败");
		}
		
		return json;
		
	}
	
}
