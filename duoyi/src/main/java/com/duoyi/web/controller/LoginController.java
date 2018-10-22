package com.duoyi.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.vo.UserVo;

import net.sf.json.JSONObject;

public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody UserVo user){
		JSONObject json = new JSONObject();
		
		
		
		
		return json;
	}
}
