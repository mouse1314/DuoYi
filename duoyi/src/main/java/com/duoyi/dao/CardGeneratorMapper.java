package com.duoyi.dao;

import com.duoyi.model.po.CardGenerator;
import com.duoyi.model.po.CardGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardGeneratorMapper {
    long countByExample(CardGeneratorCriteria example);

    int deleteByExample(CardGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardGenerator record);

    int insertSelective(CardGenerator record);

    List<CardGenerator> selectByExample(CardGeneratorCriteria example);

    CardGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardGenerator record, @Param("example") CardGeneratorCriteria example);

    int updateByExample(@Param("record") CardGenerator record, @Param("example") CardGeneratorCriteria example);

    int updateByPrimaryKeySelective(CardGenerator record);

    int updateByPrimaryKey(CardGenerator record);
}