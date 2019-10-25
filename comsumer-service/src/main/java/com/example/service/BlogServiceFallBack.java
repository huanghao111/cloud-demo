package com.example.service;

import com.example.bean.Blog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* blogservice的熔断降级处理类，用于处理blogservice由于访问失败导致的阻塞的降级方案
* */
@Service //feign的熔断降级处理类，
public class BlogServiceFallBack implements BlogService{
    @Override
    public Blog findByTitle(String title) {
        return new Blog("服务器挂了","");
    }

    @Override
    public List<Blog> findList() {
        return null;
    }
}
