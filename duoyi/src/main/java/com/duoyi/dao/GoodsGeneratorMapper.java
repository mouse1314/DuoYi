package com.duoyi.dao;

import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.model.po.GoodsGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsGeneratorMapper {
    long countByExample(GoodsGeneratorCriteria example);

    int deleteByExample(GoodsGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsGenerator record);

    int insertSelective(GoodsGenerator record);

    List<GoodsGenerator> selectByExample(GoodsGeneratorCriteria example);

    GoodsGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsGenerator record, @Param("example") GoodsGeneratorCriteria example);

    int updateByExample(@Param("record") GoodsGenerator record, @Param("example") GoodsGeneratorCriteria example);

    int updateByPrimaryKeySelective(GoodsGenerator record);

    int updateByPrimaryKey(GoodsGenerator record);
    
    List<GoodsGenerator> getAll();
    
    List<GoodsGenerator> getAllByUserid(int userid);

}