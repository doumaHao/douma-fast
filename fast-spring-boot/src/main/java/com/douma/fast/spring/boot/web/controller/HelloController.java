package com.douma.fast.spring.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author haoxijun | doumaHao
 * @Create 2018-12-23 0:09
 */
@RestController
public class HelloController {

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

}