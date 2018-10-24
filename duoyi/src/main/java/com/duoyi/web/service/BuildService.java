package com.duoyi.web.service;

import java.util.List;

import com.duoyi.model.po.BuildGenerator;

/**
 * @author 浩子
 *2018年10月24日
 */
public interface BuildService {

	public int saveBuild(BuildGenerator build);
	
	public List<BuildGenerator> findBuildByCardId(int id);
}
