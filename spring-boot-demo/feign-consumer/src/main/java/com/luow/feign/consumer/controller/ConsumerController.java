package com.luow.feign.consumer.controller;

import com.luow.didispace.model.User;
import com.luow.feign.consumer.service.HelloService;
import com.luow.feign.consumer.service.RefactorApiHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feignDemo")
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorApiHelloService refactorHelloService;

    @RequestMapping("helloConsumer2")
    public String helloConsumer2(){
        StringBuffer sb = new StringBuffer();
        sb.append(helloService.hello("张子健")).append("\n");
        sb.append(helloService.hello("李一","30")).append("\n");
        sb.append(helloService.hello(new User("张健", "23"))).append("\n");
        return sb.toString();
    }

    @RequestMapping("helloConsumer3")
    public String helloConsumer3(){
        StringBuffer sb = new StringBuffer();
        sb.append(refactorHelloService.hello("张子健")).append("\n");
        sb.append(refactorHelloService.hello("李一","30")).append("\n");
        sb.append(refactorHelloService.hello(new User("张健", "23"))).append("\n");
        return sb.toString();
    }
}
