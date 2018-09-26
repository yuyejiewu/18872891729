package com.didispace.controller;

import com.luow.life.conmmon.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("hello")
public class HelloController {

    private final Logger log = Logger.getLogger(getClass());
    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("index")
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();

        log.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello" + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello2(@RequestHeader String name, @RequestHeader String age){
        return new User(name, age);
    }

    @RequestMapping("hello3")
    public String hello3(@RequestBody User user){
        return "Hello" + user.getName() + ",age:" + user.getAge();
    }
}
