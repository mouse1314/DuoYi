package com.duoyi.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.GoodsGeneratorMapper;
import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.model.po.GoodsGeneratorCriteria;
import com.duoyi.web.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsGeneratorMapper goodsMapper;
	
	
	@Override
	public List<GoodsGenerator> getAll() {
		// TODO Auto-generated method stub
//		GoodsGeneratorCriteria record = new GoodsGeneratorCriteria();
		return goodsMapper.selectByExample(new GoodsGeneratorCriteria());
	}


	@Override
	public List<GoodsGenerator> getAllByUserid(int userid) {
		// TODO Auto-generated method stub
		return goodsMapper.getAllByUserid(userid);
	}


	@Override
	public int add(GoodsGenerator goodsGenerator) {
		return goodsMapper.insert(goodsGenerator);
	}

	@Override
	public int delete(int goodsid){
		return goodsMapper.deleteByPrimaryKey(goodsid);
	}


	@Override
	public int update(GoodsGenerator goodsGenerator) {
		// TODO Auto-generated method stub
		return goodsMapper.updateByPrimaryKeySelective(goodsGenerator);
	}


	@Override
	public GoodsGenerator getOne(int id) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByPrimaryKey(id);
	}
}
