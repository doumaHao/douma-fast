
## Spring Boot 入门 ##

首先创建一个maven项目，就是当前工程了

然后编写这个maven项目的pom文件

指定一些全局版本
>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>
    
指定 parent 为 spring-boot-starter-parent
>      
    <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>1.4.7.RELEASE</version>
       <relativePath/>
    </parent>
    
再依赖一下Spring Boot的jar包

spring-boot-starter-web 是要用的

spring-boot-starter-test 是单元测试用的
    
>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

编译的时候也需要 Spring-boot 帮忙
>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

这样pom配置就好了

再写个启动类 使用@SpringBootApplication注解
>
    package com.douma.springboot;
    
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    
    @SpringBootApplication
    public class SpringApp {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringApp.class, args);
        }
    
    }

再用个controller试试效果
>
    package com.douma.springboot.web.controller;
    
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class HelloController {
    
        @GetMapping("hello")
        public String helloWold(String name) {
            return "Hello World, " + name;
        }
    }

页面请求 http://localhost:8080/hello?name=张三

可以看到结果 Hello World, 张三 说明干活了

