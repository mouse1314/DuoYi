package com.duoyi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(){
		
		return null;
	}
}
