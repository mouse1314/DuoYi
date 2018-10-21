package com.duoyi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/ApplicationContext-main.xml", 
"classpath:spring/ApplicationContext-dataSource.xml"})
public class TestTransaction {

   
    
    @Test
    @Transactional
    @Rollback(false)
    public void testTransaction() {
    	
    }
}
