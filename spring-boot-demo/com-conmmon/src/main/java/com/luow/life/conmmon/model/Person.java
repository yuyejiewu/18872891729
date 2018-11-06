package com.luow.life.conmmon.model;

import lombok.Data;

public class Person {
    private String name;
    private int age;

    static {
        System.out.println("Person....");
    }

    public Person(){
        System.out.println("Person instance...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("**Age = " + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
