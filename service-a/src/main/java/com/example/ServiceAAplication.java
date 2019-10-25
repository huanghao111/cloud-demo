package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceAAplication {
    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServiceAAplication.class,args);
    }
    //访问其他服务的http客户端
    @Bean
    @LoadBalanced //通过ribbon实现负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    /*
    * 服务a作为服务消费者通过访问服务器B获得数据交给前台
    * */
    @RequestMapping("/proxyHello")
    public String proxyHello(){
        //需要通过restTemlate访问服务B,url用的是访问的服务器的名称
        String result = restTemplate.getForObject("http://service-b/hello", String.class);
        return result;
    }
}
