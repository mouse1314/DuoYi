package com.duoyi.dao;

import com.duoyi.model.po.BuildGenerator;
import com.duoyi.model.po.BuildGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildGeneratorMapper {
    long countByExample(BuildGeneratorCriteria example);

    int deleteByExample(BuildGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuildGenerator record);

    int insertSelective(BuildGenerator record);

    List<BuildGenerator> selectByExample(BuildGeneratorCriteria example);
    
    List<BuildGenerator> selectByCardId(Integer id);//根据帖子id去查看帖子的盖楼

    BuildGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuildGenerator record, @Param("example") BuildGeneratorCriteria example);

    int updateByExample(@Param("record") BuildGenerator record, @Param("example") BuildGeneratorCriteria example);

    int updateByPrimaryKeySelective(BuildGenerator record);

    int updateByPrimaryKey(BuildGenerator record);
}