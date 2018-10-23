package com.duoyi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.vo.UserVo;
import com.duoyi.web.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userSerivice;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody UserVo user){
		JSONObject json = new JSONObject();
		int result = userSerivice.selectPassByUsername(user);
		if(result==0){
			json.put("state",0);
			json.put("message", "无账号");
		}else if(result==-1){
			json.put("state",-1);
			json.put("message", "密码错误");
		}else if(result==1){
			json.put("state",1);
			json.put("message", "正确");
		}
		return json;
	}
}
