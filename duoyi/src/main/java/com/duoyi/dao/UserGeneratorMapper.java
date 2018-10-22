package com.duoyi.dao;

import com.duoyi.model.po.UserGenerator;
import com.duoyi.model.po.UserGeneratorCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserGeneratorMapper {
    long countByExample(UserGeneratorCriteria example);

    int deleteByExample(UserGeneratorCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserGenerator record);

    int insertSelective(UserGenerator record);

    List<UserGenerator> selectByExample(UserGeneratorCriteria example);

    UserGenerator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserGenerator record, @Param("example") UserGeneratorCriteria example);

    int updateByExample(@Param("record") UserGenerator record, @Param("example") UserGeneratorCriteria example);

    int updateByPrimaryKeySelective(UserGenerator record);

    int updateByPrimaryKey(UserGenerator record);
    
    String selectPassByUsername(@Param("username")String username);
}