package com.duoyi.dao;

import com.duoyi.model.po.PhotoGenerator;
import com.duoyi.model.po.PhotoGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoGeneratorMapper {
    long countByExample(PhotoGeneratorCriteria example);

    int deleteByExample(PhotoGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(PhotoGenerator record);

    int insertSelective(PhotoGenerator record);

    List<PhotoGenerator> selectByExample(PhotoGeneratorCriteria example);

    PhotoGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PhotoGenerator record, @Param("example") PhotoGeneratorCriteria example);

    int updateByExample(@Param("record") PhotoGenerator record, @Param("example") PhotoGeneratorCriteria example);

    int updateByPrimaryKeySelective(PhotoGenerator record);

    int updateByPrimaryKey(PhotoGenerator record);
    
    List<String> getImgByGoodsId(@Param("goodsid") int goodsid);
}