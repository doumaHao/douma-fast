package com.douma.fast.spring.boot.web.controller;

import com.douma.fast.redis.service.AspetService;
import com.douma.fast.redis.service.RedisService;
import com.douma.fast.spring.boot.service.EnvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-23 0:09
 */
@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EnvService envService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private AspetService aspetService;

    /**
     * 测试spring-boot
     *
     * @param name
     * @return
     */
    @GetMapping("spring-boot")
    public String helloWold(String name) {
        return "Hello World, " + name;
    }

    /**
     * 测试当前环境
     *
     * @return
     */
    @GetMapping("env")
    public String getConfig() {
        return envService.getNowConfig();
    }

    /**
     * 测试当前环境的配置
     *
     * @return
     */
    @GetMapping("get-config")
    public String get() {
        return envService.get();
    }

    /**
     * 测试 redis
     *
     * @return
     */
    @GetMapping("redis")
    public String redis() {
        String key = "key";
        String value = "value";
        redisService.put(key, value);
        log.debug("存入缓存成功 key={},value={}", key, value);
        value = (String) redisService.get(key);
        return value;
    }

    /**
     * 测试 aspect
     *
     * @return
     */
    @GetMapping("aspect")
    public int aspect() {
        return aspetService.testAspect(1, "bbbb");
    }

    @GetMapping("aspect-err")
    public int testAspectWithException() {
        return aspetService.testAspectWithException(1);
    }

}