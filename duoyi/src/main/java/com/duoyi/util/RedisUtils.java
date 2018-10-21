package com.duoyi.util;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtils {

	@Autowired  
    private RedisTemplate<Object,Object> redisTemplate;  
      
    public RedisTemplate<Object,Object> getInstance(){  
        return redisTemplate;  
    }  
    
    /** 
     * 设置 String 类型 key-value 
     * @param key 
     * @param value 
     */  
    public void set(String key,String value){  
        redisTemplate.opsForValue().set(key, value);  
    }  
      
      
    /** 
     * 获取 String 类型 key-value 
     * @param key 
     * @return 
     */  
    public String get(String key){  
        return (String) redisTemplate.opsForValue().get(key);  
    }
    /** 
     * 设置 String 类型 key-value 并添加过期时间 (毫秒单位) 
     * @param key 
     * @param value 
     * @param time 过期时间,毫秒单位 
     */  
    public void setForTimeMS(String key,String value,long time){  
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);  
    }  
      
    /** 
     * 设置 String 类型 key-value 并添加过期时间 (分钟单位) 
     * @param key 
     * @param value 
     * @param time 过期时间,分钟单位 
     */  
    public void setForTimeMIN(String key,String value,long time){  
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);  
    }  
      
      
    /** 
     * 设置 String 类型 key-value 并添加过期时间
     * @param key 
     * @param value 
     * @param time 过期时间,单位 自己设置
     */  
    public void setForTimeCustom(String key,String value,long time,TimeUnit type){  
        redisTemplate.opsForValue().set(key, value, time, type);  
    }

    /** 
     * 给一个指定的 key 值附加过期时间 
     * @param key 
     * @param time 
     * @param type 
     * @return 
     */  
    public boolean expire(String key,long time,TimeUnit type){  
        return redisTemplate.boundValueOps(key).expire(time, type);  
    }  
      
    /** 
     * 移除指定key 的过期时间 
     * @param key 
     * @return 
     */  
    public boolean persist(String key){  
        return redisTemplate.boundValueOps(key).persist();  
    }  
      
      
    /** 
     * 获取指定key 的过期时间 
     * @param key 
     * @return 
     */  
    public Long getExpire(String key){  
        return redisTemplate.boundValueOps(key).getExpire();  
    }
    /** 
     * 修改 key 
     * @param key 
     * @return 
     */  
    public void rename(String key,String newKey){  
        redisTemplate.boundValueOps(key).rename(newKey);  
    }  
      
    /** 
     * 删除 key-value 
     * @param key 
     * @return 
     */  
    public void delete(String key){  
        redisTemplate.delete(key);  
    }

}
