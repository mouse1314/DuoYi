package com.duoyi.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.ResourceGeneratorMapper;
import com.duoyi.model.po.ResourceGenerator;
import com.duoyi.util.COSUtil;
import com.duoyi.web.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceGeneratorMapper resourceMapper;
	
	@Override
	public List<ResourceGenerator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceGenerator> getAllByUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ResourceGenerator record) {
		resourceMapper.insertSelective(record);
	}

}
