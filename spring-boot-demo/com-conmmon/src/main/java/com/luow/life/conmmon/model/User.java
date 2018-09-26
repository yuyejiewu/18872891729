package com.luow.life.conmmon.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    private String name;
    private String age;
}
