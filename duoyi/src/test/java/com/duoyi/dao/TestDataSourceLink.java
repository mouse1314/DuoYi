package com.duoyi.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/ApplicationContext-main.xml", 
    "classpath:spring/ApplicationContext-dataSource.xml"})
public class TestDataSourceLink {

    
    @Test
    public void testLink() {
    	
    }
}
