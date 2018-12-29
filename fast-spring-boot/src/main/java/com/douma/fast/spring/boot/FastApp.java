package com.douma.fast.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.douma"})
public class FastApp {

    public static void main(String[] args) {
        SpringApplication.run(FastApp.class, args);
    }

}