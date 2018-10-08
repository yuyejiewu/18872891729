package com.luow.feign.consumer.service.impl;

import com.luow.didispace.model.User;
import com.luow.didispace.service.ApiHelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ApiHelloServiceFallback implements ApiHelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "服务降级测试:error";
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") String age) {
        return new User("服务降级测试:error","0");
    }

    @Override
    public String hello(@RequestBody User user) {
        return "服务降级测试:error";
    }
}
