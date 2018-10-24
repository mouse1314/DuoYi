package com.duoyi.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.BuildGeneratorMapper;
import com.duoyi.model.po.BuildGenerator;
import com.duoyi.web.service.BuildService;

/**
 * @author 浩子
 *2018年10月24日
 */
@Service
public class BuildServiceImpl implements BuildService {

	
	@Autowired
	private BuildGeneratorMapper buildMapper;
	
	@Override
	public int saveBuild(BuildGenerator build) {
		
		Date date = new Date();
		build.setTime(date); //设置当前盖楼的时间
		try {
			buildMapper.insert(build);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	
	@Override
	public List<BuildGenerator> findBuildByCardId(int id) {
		
		List<BuildGenerator> list = buildMapper.selectByCardId(id);
		return list;
	}

}
