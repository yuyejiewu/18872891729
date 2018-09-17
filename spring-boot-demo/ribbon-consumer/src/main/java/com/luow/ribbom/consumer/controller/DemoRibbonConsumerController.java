package com.luow.ribbom.consumer.controller;

import com.luow.ribbom.consumer.service.HelloService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("ribbonConsumer")
public class DemoRibbonConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping("helloConsumer")
    public String helloConsumer(){
        /*ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hello-demo/bookInfo/getBookName", String.class);
        return "hello-service->bookName:" + forEntity.getBody();*/
        return helloService.helloService();
    }
}
