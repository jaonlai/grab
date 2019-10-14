package com.example.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     */
    public boolean setStr(final String key, String value, Integer time) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量写入hash缓存
     */
    public boolean setAllHash(final String key, Map value, Integer time) {
        boolean result = false;
        try {
            redisTemplate.opsForHash().putAll(key, value);
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入hash缓存
     */
    public boolean setHash(final String key, String hashKey, Object value, Integer time) {
        boolean result = false;
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入hash缓存
     */
    public Object getHash(final String key, String hashKey) {
        Object object =null;
        try {
           object=  redisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 更新缓存
     */
    public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
