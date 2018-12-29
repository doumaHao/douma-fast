package com.douma.fast.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description 启动类
 * @Author haoxijun | doumaHao
 * @Create 2018-12-16 17:24
 */
@SpringBootApplication(scanBasePackages = {"com.douma"})
public class DoumaFastApp {

    public static void main(String[] args) {
        SpringApplication.run(DoumaFastApp.class, args);
    }

}