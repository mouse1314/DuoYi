package com.duoyi.web.service;

import java.util.List;

import com.duoyi.model.po.ResourceGenerator;

public interface ResourceService {

	public List<ResourceGenerator> getAll();
	
	public List<ResourceGenerator> getAllByUserId(int id);
	
	public void add(ResourceGenerator record);
	
}
