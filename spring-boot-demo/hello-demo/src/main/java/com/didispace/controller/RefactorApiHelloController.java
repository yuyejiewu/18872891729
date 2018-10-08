package com.didispace.controller;

import com.luow.didispace.model.User;
import com.luow.didispace.service.ApiHelloService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RefactorApiHelloController implements ApiHelloService {
    @Override
    public String hello(String name) {
        int num = new Random(3000).nextInt();
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello" + name;
    }

    @Override
    public User hello(String name, String age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
