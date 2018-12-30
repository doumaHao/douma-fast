
## redis 的应用 ##

引入需要的依赖
> 
    <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    
配置文件增加 redis 的配置 
```  
spring:
  redis:
    host: 192.168.199.212
    port: 6379
    password: haoxijun123
    database: 1
```          
依赖 jar 包中已经有 redisTemplate 这个 bean 了，我们可以直接使用
````$xslt
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
````