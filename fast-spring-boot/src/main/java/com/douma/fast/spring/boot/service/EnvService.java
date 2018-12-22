package com.douma.fast.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-23 0:18
 */
@Service
public class EnvService {

    @Value("${spring.profiles.active}")
    private String active;

    @Value("${profile}")
    private String profile;

    @Autowired
    private Environment environment;

    /**
     * 获取当前运行环境
     *
     * @return
     */
    public String getNowConfig() {
        return active;
    }

    /**
     * 获取配置环境的值
     *
     * @return
     */
    public String get() {
//        return environment.getProperty("profile");
        return profile;
    }
}