package com.duoyi.dao;

import com.duoyi.model.po.TeamGenerator;
import com.duoyi.model.po.TeamGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeamGeneratorMapper {
    long countByExample(TeamGeneratorCriteria example);

    int deleteByExample(TeamGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeamGenerator record);

    int insertSelective(TeamGenerator record);

    List<TeamGenerator> selectByExample(TeamGeneratorCriteria example);

    List<TeamGenerator> selectByUserId(Integer id);
    
    TeamGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeamGenerator record, @Param("example") TeamGeneratorCriteria example);

    int updateByExample(@Param("record") TeamGenerator record, @Param("example") TeamGeneratorCriteria example);

    int updateByPrimaryKeySelective(TeamGenerator record);

    int updateByPrimaryKey(TeamGenerator record);
}