package com.duoyi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.UserGenerator;
import com.duoyi.model.vo.UserVo2;
import com.duoyi.web.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject get(HttpServletRequest request){
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
//		int userid = 1;
		UserVo2 user = userService.getUser(userid);
		System.out.println(user);
		json.put("status", 1);
		json.put("result",JSONObject.fromObject(user));
		return json;
	}
	

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject update(@RequestBody UserGenerator user,HttpServletRequest request){
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
//		int userid = 2 ;
		user.setId(userid);
		int result = userService.updateUser(user);
		if(result<=0){
			json.put("status", -1);
			json.put("message","编辑失败");
		}else {
			json.put("status", 1);
			json.put("message","编辑成功");
		}
		
		return json;
	}
	
}
