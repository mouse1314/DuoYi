package com.duoyi.dao;

import com.duoyi.model.po.CardGenerator;
import com.duoyi.model.po.CardGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CardGeneratorMapper {
    long countByExample(CardGeneratorCriteria example);

    int deleteByExample(CardGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardGenerator record);

    int insertSelective(CardGenerator record);

    List<CardGenerator> selectByExample(CardGeneratorCriteria example);
    
    List<CardGenerator> selectByUserId(Integer id);//查询用户发的贴子
    
    CardGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardGenerator record, @Param("example") CardGeneratorCriteria example);

    int updateByExample(@Param("record") CardGenerator record, @Param("example") CardGeneratorCriteria example);

    int updateByPrimaryKeySelective(CardGenerator record);

    int updateByPrimaryKey(CardGenerator record);
    
    int updateByCardId(CardGenerator record);
}