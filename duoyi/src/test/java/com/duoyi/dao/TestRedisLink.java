package com.duoyi.dao;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/ApplicationContext-redis.xml", 
    "classpath:spring/ApplicationContext-main.xml"})
public class TestRedisLink {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Test
    public void testSave() {
        redisTemplate.boundValueOps("key").set("value", 10, TimeUnit.MINUTES);
    }
    
}
