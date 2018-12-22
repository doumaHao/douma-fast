
## 多环境和多配置 ##

首先在 resources 目录下搞3个配置文件，

application.yml

application-dev.yml

application-test.yml

这里只用到了开发和测试，准生产和生产我没弄，你去弄弄也是同样的玩法

application.yml 中得指定当前的配置使用的是哪个环境的，我这里用的是 `dev` 环境
>
    spring:
      profiles:
        active: dev

除了这种方法 还有2种方法可以改变当前运行环境

方法1： 用jar运行的时候 指定 `spring.profiles.active` 的参数
>
    java -jar 你要运行的文件.jar --spring.profiles.active=dev
方法2： idea启动的时候 在 `Program arguments` 中指定 `spring.profiles.active` 的参数
>
    --spring.profiles.active=dev
    
然后再分别在 application-dev.yml 和 application-test.yml 使用不同的配置信息

application-dev.yml 中说这是开发环境
>
    profile: dev_envrimont
application-test.yml 中说着是测试环境
>
    profile: test_envrimont
    
然后代码中获取配置 profile 时，他都肯定是 dev_envrimont ，你如果把环境换成 test ， 那拿到的就是 test_envrimont 了

获取配置的方式1：
> 
        @Value("${profile}")
        private String profile;
获取配置的方式2：
>
        @Autowired
        private Environment environment;
        
        environment.getProperty("profile");
    