package com.duoyi.web.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoyi.dao.CardGeneratorMapper;
import com.duoyi.model.po.CardGenerator;
import com.duoyi.model.po.CardGeneratorCriteria;
import com.duoyi.web.service.CardService;

/**
 * @author 浩子
 *2018年10月23日
 */
@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardGeneratorMapper cardMapper;

	/* 插入帖子
	 * @see com.duoyi.web.service.CardService#insertCard(com.duoyi.model.po.CardGenerator)
	 */
	@Override  
	public String insertCard(CardGenerator card) {
		Date date = new Date();
		card.setTime(date);
		String message = "";
		try{
			cardMapper.insert(card);
			message = "发表帖子成功";
		}catch (Exception e) {
			e.printStackTrace();
			message="发表贴子失败";
		}
		return message;
	}

	/* 
	 * @see com.duoyi.web.service.CardService#updateCardByCardId(com.duoyi.model.po.CardGenerator)
	 */
	@Override
	public String updateCardByCardId(CardGenerator card) {
		
		try{
			cardMapper.updateByCardId(card);
			return "修改帖子成功";
		}catch (Exception e){
			e.printStackTrace();
			return "修改帖子失败";
		}
	}

	/* 查看用户发的贴子
	 * @see com.duoyi.web.service.CardService#findUserCard(int)
	 */
	@Override
	public List<CardGenerator> findUserCard(int id) {
		return cardMapper.selectByUserId(id);
	}

	/* 查看所有帖子
	 * @see com.duoyi.web.service.CardService#findAllCards()
	 */
	@Override
	public List<CardGenerator> findAllCards() {
		return cardMapper.selectByExample(new CardGeneratorCriteria());
	}

	/* 删除帖子
	 * @see com.duoyi.web.service.CardService#delectCard(int)
	 */
	@Override
	public String delectCard(int id) {
		cardMapper.deleteByPrimaryKey(id);
		return "删除帖子成功";
	}

}
