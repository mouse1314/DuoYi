package com.duoyi.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.AdmireGeneratorMapper;
import com.duoyi.model.po.AdmireGenerator;
import com.duoyi.web.service.AdmireService;

/**
 * @author 浩子
 *2018年10月25日
 */
@Service
public class AdmireServiceImpl implements AdmireService{

	@Autowired
	private AdmireGeneratorMapper adminMapper;
	
	@Override
	public int saveAdmire(AdmireGenerator admire) {
		return adminMapper.insert(admire);
	}

	
	
}
