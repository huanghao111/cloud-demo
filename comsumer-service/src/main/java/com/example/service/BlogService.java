package com.example.service;


import com.example.bean.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
* 这是一个访问blog的feign的客户端
* */
@FeignClient(name = "producer-service",fallback = BlogServiceFallBack.class) //name属性必须是服务的名称，也就是spring。application。name
public interface BlogService {

    @RequestMapping("/blog/{title}")
    public Blog findByTitle(@PathVariable("title") String title);

    @RequestMapping("/blog/findList")
    public List<Blog> findList();
}
