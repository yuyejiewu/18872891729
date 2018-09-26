package com.luow.feign.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.luow.life.conmmon.model.User;

@FeignClient("hello-demo")
public interface HelloService {

    @RequestMapping("hello/index")
    String hello();

    @RequestMapping("bookInfo/getBookName")
    String getBookName();

    @RequestMapping(value = "hello/hello", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") String age);

    @RequestMapping(value = "hello/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
