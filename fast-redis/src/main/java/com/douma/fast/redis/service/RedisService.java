package com.douma.fast.redis.service;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-23 0:25
 */
@Service
public class RedisService {

    private final Logger log = LoggerFactory.getLogger(RedisService.class);

    /**
     * 默认过期时间 60分钟
     */
    private final static long DEFALUT_TIMEOUT = 60L;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    /**
     * 保存
     *
     * @param key
     * @param value
     */
    public void put(final String key, final Object value) {
        put(key, value, DEFALUT_TIMEOUT);
    }

    /**
     * 保存
     *
     * @param key
     * @param value
     * @param timeout
     */
    public void put(final String key, final Object value, final long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MINUTES);
    }

    /**
     * 保存
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void put(final String key, final Object value, final long timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取保存
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public Object getAndSet(final String key, final Object value, final long timeout, final TimeUnit timeUnit) {
        Object obj = redisTemplate.opsForValue().getAndSet(key, value);
        redisTemplate.expire(key, timeout, timeUnit);
        return obj;
    }

    /**
     * 删除
     *
     * @param key
     */
    public void delete(final String key) {
        redisTemplate.delete(key);
    }

    /**
     * 获取
     *
     * @param key
     */
    public Object get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(final String key, final long seconds) {
        if (StrUtil.isBlank(key)) {
            throw new IllegalArgumentException("redis key为空");
        }
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

}