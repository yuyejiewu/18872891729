package com.luow.feign.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-demo")
public interface HelloService {

    @RequestMapping("hello/index")
    String hello();
}
