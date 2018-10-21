package com.duoyi.dao;

import com.duoyi.model.po.SkillGenerator;
import com.duoyi.model.po.SkillGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkillGeneratorMapper {
    long countByExample(SkillGeneratorCriteria example);

    int deleteByExample(SkillGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkillGenerator record);

    int insertSelective(SkillGenerator record);

    List<SkillGenerator> selectByExample(SkillGeneratorCriteria example);

    SkillGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkillGenerator record, @Param("example") SkillGeneratorCriteria example);

    int updateByExample(@Param("record") SkillGenerator record, @Param("example") SkillGeneratorCriteria example);

    int updateByPrimaryKeySelective(SkillGenerator record);

    int updateByPrimaryKey(SkillGenerator record);
}