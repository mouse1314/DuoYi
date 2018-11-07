package com.duoyi.web.service;

import java.util.List;

import com.duoyi.model.po.PhotoGenerator;

public interface PhotoService {

	public void insert(PhotoGenerator Photo);
	
	public List<String> getImgByGoodsId(int goodsid);
	
	
}
