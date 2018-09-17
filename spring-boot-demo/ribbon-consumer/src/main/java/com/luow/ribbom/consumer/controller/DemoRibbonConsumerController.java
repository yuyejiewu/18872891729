package com.luow.ribbom.consumer.controller;

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

    @RequestMapping("helloConsumer")
    public String helloConsumer(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hello-demo/bookInfo/getBookName", String.class);
        return "hello-service->bookName:" + forEntity.getBody();
    }
}
