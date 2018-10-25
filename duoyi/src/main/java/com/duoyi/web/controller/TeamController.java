package com.duoyi.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.SkillGenerator;
import com.duoyi.model.po.TeamGenerator;
import com.duoyi.web.service.TeamService;

import net.sf.json.JSONObject;

/**关于寻找组队功能的controller
 * @author 浩子
 *2018年10月24日
 */
@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@PostMapping("/findTeam")
	@ResponseBody  //队伍寻求人员
	public JSONObject findTeam(@RequestBody TeamGenerator team,HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		team.setUserId(userid);
		int result = teamService.saveTeam(team);
		json.put("status", result);
		if(result == 1){
			json.put("message", "发布组队申请成功");
		}else if (result == 0) {
			json.put("message", "队伍描述，比赛名称，需要人员的技能等信息不能为空");
		}else{
			json.put("message", "发布组队申请失败");
		}
		return json;
	}
	
	@PostMapping("/findSkill")
	@ResponseBody  //个人寻找队伍去比赛
	public JSONObject findSkill(@RequestBody SkillGenerator skill,HttpServletRequest request){
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		skill.setUserId(userid);
		int result = teamService.saveSkill(skill);
		json.put("status", result);
		
		if(result == 1){
			json.put("message", "发布寻求组队成功");
		}else if (result == 0) {
			json.put("message", "个人技能，技能描述等信息不能为空");
		}else{
			json.put("message", "发布寻求组队失败");
		}
		return json;
	}
	
	@PostMapping("/findAllTeam")
	@ResponseBody //查看我发布的所有组队申请
	public JSONObject findAllTeam(HttpServletRequest request){
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		
		List<TeamGenerator> list= teamService.findAllTeam(userid);
		
		
		if(list.size()>0){
			json.put("status", 1);
			json.put("message", "success");
			json.put("result", list);
		}else{
			json.put("status", -1);
			json.put("message", "你还没有发布过任何组队消息");
		}
		return json;
	}
	
	@PostMapping("/findAllSkill")
	@ResponseBody //查看我发布的所有寻求组队申请
	public JSONObject findAllSkill(HttpServletRequest request){
		JSONObject json = new JSONObject();
		int userid = (int) request.getSession().getAttribute("userid");
		
		List<SkillGenerator> list = teamService.findAllSkill(userid);
		if(list.size()>0){
			json.put("status", 1);
			json.put("message", "success");
			json.put("result", list);
		}else{
			json.put("status", -1);
			json.put("message", "你还没有发布过任何寻求组队消息");
		}
		return json;
	}
	
	
	@PostMapping("/findAllTeams")
	@ResponseBody //查看所有所有组队申请
	public JSONObject findAllTeam(){
		JSONObject json = new JSONObject();
		
		
		List<TeamGenerator> list= teamService.findAllTeam();
		
		
		if(list.size()>0){
			json.put("status", 1);
			json.put("message", "success");
			json.put("result", list);
		}else{
			json.put("status", -1);
			json.put("message", "你还没有发布过任何组队消息");
		}
		return json;
	}
	
	@PostMapping("/findAllSkills")
	@ResponseBody //查看所有寻求组队申请
	public JSONObject findAllSkill(){
		JSONObject json = new JSONObject();
		
		List<SkillGenerator> list = teamService.findAllSkill();
		if(list.size()>0){
			json.put("status", 1);
			json.put("message", "success");
			json.put("result", list);
		}else{
			json.put("status", -1);
			json.put("message", "你还没有发布过任何寻求组队消息");
		}
		return json;
	}
	
	
	
	
}
