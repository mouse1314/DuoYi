package com.duoyi.dao;

import com.duoyi.model.po.ResourceGenerator;
import com.duoyi.model.po.ResourceGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceGeneratorMapper {
    long countByExample(ResourceGeneratorCriteria example);

    int deleteByExample(ResourceGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResourceGenerator record);

    int insertSelective(ResourceGenerator record);

    List<ResourceGenerator> selectByExample(ResourceGeneratorCriteria example);

    ResourceGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResourceGenerator record, @Param("example") ResourceGeneratorCriteria example);

    int updateByExample(@Param("record") ResourceGenerator record, @Param("example") ResourceGeneratorCriteria example);

    int updateByPrimaryKeySelective(ResourceGenerator record);

    int updateByPrimaryKey(ResourceGenerator record);
}