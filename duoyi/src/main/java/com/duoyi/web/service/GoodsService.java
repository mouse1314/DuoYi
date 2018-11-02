package com.duoyi.web.service;

import java.util.List;

import com.duoyi.model.po.GoodsGenerator;

public interface GoodsService {

	public List<GoodsGenerator> getAll();
	
	public List<GoodsGenerator> getAllByUserid(int userid);
	
	public int add(GoodsGenerator goodsGenerator);
	
	public int delete(int goodsid);
	
	public int update(GoodsGenerator goodsGenerator);
	
	public List<GoodsGenerator> searchGoods(String msg);
	
}
