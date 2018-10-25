package com.duoyi.web.service;

import java.util.List;

import com.duoyi.model.po.SkillGenerator;
import com.duoyi.model.po.TeamGenerator;

/**
 * @author 浩子
 *2018年10月24日
 */
public interface TeamService {

	public int saveTeam(TeamGenerator team);
	
	public int saveSkill(SkillGenerator skill);
	
	public List<TeamGenerator> findAllTeam(int id);
	
	public List<SkillGenerator> findAllSkill(int id);
	
	public List<TeamGenerator> findAllTeam();
	
	public List<SkillGenerator> findAllSkill();
	
	public int completeTeam(int id);
	
	public int updateTeam(TeamGenerator team);
	
	public TeamGenerator selectTeamById(int id);
	
}
