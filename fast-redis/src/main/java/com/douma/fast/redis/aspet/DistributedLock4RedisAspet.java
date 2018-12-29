package com.douma.fast.redis.aspet;

import cn.hutool.core.util.StrUtil;
import com.douma.fast.redis.annotation.DistributedLock;
import com.douma.fast.redis.service.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


/**
 * @description: 基于redis实现的分布式锁
 * @author: Douma | Hao xijun
 * @date: 2018/12/29 14:07
 */
@Aspect
@Component
public class DistributedLock4RedisAspet {

    private final Logger log = LoggerFactory.getLogger(DistributedLock4RedisAspet.class);

    final static private TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    @Autowired
    private RedisService redisService;

    @Pointcut("@annotation(com.douma.fast.redis.annotation.DistributedLock)")
    public void distrdibutedLock() {
    }

    @Around("distrdibutedLock()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("开始分布式锁校验...");
        Long start = System.currentTimeMillis();

        DistributedLock distributedLock = getDistributedLock(joinPoint);
        String key = getkey(joinPoint);
        if (StrUtil.isNotBlank(distributedLock.key())) {
            key = distributedLock.key();
        }
        long time = distributedLock.time();
        long timeOut = distributedLock.timeOut();
        while (redisService.getAndSet(key, key, time, TIME_UNIT) != null) {
            log.info("分布式锁获取中...");
            if (System.currentTimeMillis() - start >= timeOut * 1000) {
                log.info("分布式锁获取超时...");
                throw new RuntimeException("分布式锁获取超时");
            }
        }

        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);

        redisService.delete(key);
        return result;
    }

    private String getkey(ProceedingJoinPoint joinPoint) {
        String longString = joinPoint.getSignature().toLongString();
        String className = longString.split(" ")[longString.split(" ").length - 1];
        String[] classNames = className.split("\\(");
        String funcName = classNames[0];
        String paramName = classNames[1];
        String key = funcName.replaceAll("\\.", ":") + paramName;
        return key;
    }

    private DistributedLock getDistributedLock(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        return method.getAnnotation(DistributedLock.class);
    }

//    @Before("idempotent()")
//    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//
//        log.debug("before start...");
//
//        Object result = joinPoint.proceed(args);
//
//        log.debug("before end");
//
//        return result;
//    }
//
//    @After("idempotent()")
//    public Object after(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//
//        log.debug("after start...");
//
//        Object result = joinPoint.proceed(args);
//
//        log.debug("after end");
//
//        return result;
//    }

}
