package com.duoyi.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.BuildGenerator;
import com.duoyi.web.service.BuildService;

import net.sf.json.JSONObject;

/**用户对帖子进行盖楼的Controller
 * @author 浩子
 *2018年10月24日
 */
@Controller
@RequestMapping("/build")
public class BuildController {

	@Autowired
	private BuildService buildService;
	
	@PostMapping("/saveBuild") // 用户对帖子发表进行盖楼
	@ResponseBody
	public JSONObject saveBulid(@RequestBody BuildGenerator build,HttpServletRequest request){
	
		HttpSession session = request.getSession();
		int userid = (int)session.getAttribute("userid");
		build.setUserId(userid);
		build.setUserId(2);
		
		JSONObject json = new JSONObject();
		int result = buildService.saveBuild(build);
		if(result == 1){
			json.put("status", result);
			json.put("message", "盖楼成功");
		}else{
			json.put("status", result);
			json.put("message", "盖楼失败");
		}
		
		return json;
	}
	
	@PostMapping("/findBuild")
	@ResponseBody
	public JSONObject findBuild(@RequestBody BuildGenerator build){
		JSONObject json = new JSONObject();
		List<BuildGenerator> list = buildService.findBuildByCardId(build.getCardId());
		
		if(list.size()>0){
			json.put("status", 1);
			json.put("result", list);
		}else{
			json.put("status", 0);
			json.put("message", "该帖子暂时没有用户盖楼");
		}
		return json;
	}
}
