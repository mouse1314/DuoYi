package com.duoyi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.AdmireGenerator;
import com.duoyi.web.service.AdmireService;

import net.sf.json.JSONObject;

/**对资源的点赞
 * @author 浩子
 *2018年10月25日
 */
@Controller
@RequestMapping("/admire")
public class AdmireController {

	@Autowired
	private AdmireService admireService;
	
	@PostMapping("/admireResource")
	@ResponseBody
	public JSONObject admireResource(AdmireGenerator admire,HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		int userid = (int)request.getSession().getAttribute("userid");
		admire.setId(userid);
		int result = admireService.saveAdmire(admire);
		json.put("status", result);
		
		if(result == 1){
			json.put("message", "用户点赞成功");
		}else{
			json.put("message", "用户点赞失败，请重试！");
		}
		
		
		
		return json;
		
	}
}
