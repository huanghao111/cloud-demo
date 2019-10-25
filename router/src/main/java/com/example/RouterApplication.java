package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy //表明该服务具有路由功能
@SpringBootApplication
public class RouterApplication {
    //注解
    public static void main(String[] args) {
        SpringApplication.run(RouterApplication.class,args);
    }
}
