package com.luow.didispace.service;


import com.luow.didispace.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface ApiHelloService {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") String age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
