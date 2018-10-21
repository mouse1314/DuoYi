package com.duoyi.dao;

import com.duoyi.model.po.AdmireGenerator;
import com.duoyi.model.po.AdmireGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmireGeneratorMapper {
    long countByExample(AdmireGeneratorCriteria example);

    int deleteByExample(AdmireGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdmireGenerator record);

    int insertSelective(AdmireGenerator record);

    List<AdmireGenerator> selectByExample(AdmireGeneratorCriteria example);

    AdmireGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdmireGenerator record, @Param("example") AdmireGeneratorCriteria example);

    int updateByExample(@Param("record") AdmireGenerator record, @Param("example") AdmireGeneratorCriteria example);

    int updateByPrimaryKeySelective(AdmireGenerator record);

    int updateByPrimaryKey(AdmireGenerator record);
}