package com.duoyi.web.service;


import java.util.List;

import com.duoyi.model.po.CardGenerator;

/**
 * @author 浩子
 *2018年10月23日
 */
public interface CardService {

	public String insertCard(CardGenerator card);
	public String updateCardByCardId(CardGenerator card);
	
	public List<CardGenerator> findUserCard(int id);
	
	public List<CardGenerator> findAllCards();
	
	public String delectCard(int id);
}
