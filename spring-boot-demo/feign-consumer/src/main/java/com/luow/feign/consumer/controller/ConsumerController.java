package com.luow.feign.consumer.controller;

import com.luow.feign.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feignDemo")
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping("helloConsumer")
    public String helloConsumer(){
        return helloService.hello();
    }
}
