package com.douma.fast.redis.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 分布式锁
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface DistributedLock {

    /**
     * 锁的key
     * 默认用全路径包名加方法名作为key
     *
     * @return
     */
    String key() default "";

    /**
     * 设置锁的有效时间 单位秒
     * 防止异常,将默认设置锁的时间
     *
     * @return
     */
    long time() default 10L;

    /**
     * 超时时间 单位秒
     * timeOut秒内没有拿到锁则抛出异常
     *
     * @return
     */
    long timeOut() default 30L;

}
