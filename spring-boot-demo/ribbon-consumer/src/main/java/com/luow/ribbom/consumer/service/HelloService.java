package com.luow.ribbom.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String helloService(){
        long start = System.currentTimeMillis();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hello-demo/bookInfo/getBookName", String.class);
        long end = System.currentTimeMillis();
        log.info("end - start = {}", end - start);
        return forEntity.getBody();
    }

    public String helloFallback(){
        return "error";
    }
}
