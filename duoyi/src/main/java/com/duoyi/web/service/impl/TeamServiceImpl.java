package com.duoyi.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.SkillGeneratorMapper;
import com.duoyi.dao.TeamGeneratorMapper;
import com.duoyi.model.po.SkillGenerator;
import com.duoyi.model.po.SkillGeneratorCriteria;
import com.duoyi.model.po.TeamGenerator;
import com.duoyi.model.po.TeamGeneratorCriteria;
import com.duoyi.util.StringUtils;
import com.duoyi.web.service.TeamService;

import ch.qos.logback.access.servlet.Util;

/**关于个人组队以及队伍招募人功能的实现
 * @author 浩子 2018年10月24日
 */
@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamGeneratorMapper teamMapper;
	@Autowired
	private SkillGeneratorMapper skillMapper;

	private static StringUtils sUtil = new StringUtils();

	@Override
	// 用户发表组队信息，请求招募队员
	public int saveTeam(TeamGenerator team) {
		// 判断输入是否合法，name describe,needKill为空
		try {
			if (StringUtils.isEmpty(team.getName()) || StringUtils.isEmpty(team.getDescribe())
					|| StringUtils.isEmpty(team.getNeedSkill())) {
				return 0;
			}
			team.setResult(0);
			teamMapper.insert(team);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入组队信息失败");
			return -1;
		}

	}

	@Override
	public int saveSkill(SkillGenerator skill) {

		try {
			// 判断输入的内容是否合法
			if (StringUtils.isEmpty(skill.getName()) || StringUtils.isEmpty(skill.getDescribe())) {
				return 0;
			}
			skillMapper.insert(skill);
			return 1;

		} catch (Exception e) {
		
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<TeamGenerator> findAllTeam(int id) {
		
		List<TeamGenerator> list=new ArrayList<TeamGenerator>();
		try{
			list = teamMapper.selectByUserId(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SkillGenerator> findAllSkill(int id) {
		List<SkillGenerator> list = new ArrayList<SkillGenerator>();
		try{
			list = skillMapper.selectByUserId(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TeamGenerator> findAllTeam() {
		List<TeamGenerator> list=new ArrayList<TeamGenerator>();
		try{
			list = teamMapper.selectByExample(new TeamGeneratorCriteria());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SkillGenerator> findAllSkill() {
		List<SkillGenerator> list = new ArrayList<SkillGenerator>();
		try{
			list = skillMapper.selectByExample(new SkillGeneratorCriteria());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int completeTeam(int id) {
		
		return teamMapper.updateTeamResult(id);
	}

	@Override
	public int updateTeam(TeamGenerator team) {
		
		return teamMapper.updateByPrimaryKey(team);
	}

	@Override
	public TeamGenerator selectTeamById(int id) {
		
		return teamMapper.selectByPrimaryKey(id);
	}

}
