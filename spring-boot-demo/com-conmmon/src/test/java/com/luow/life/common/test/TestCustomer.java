package com.luow.life.common.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

public class TestCustomer {
    public static void main(String[] args) {
        Customer<String> c =  new Customer<>();
        c.setT("大话西游");

        Customer<Integer> c1 = new Customer<>();
        c1.setT(20);

        System.out.println(c.getT() + ":" + c1.getT() + "年");

        Integer [] arr = {1,2,3};
        Customer<Integer> c2 = new Customer<>();
        Collection<Integer> collection = new ArrayList<>();
        c2.copyToCollection(arr, collection);
        System.out.println(collection);


    }

    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Customer> classzz = Customer.class;
        Customer<String> customer = classzz.newInstance();
        Field t = classzz.getDeclaredField("t");
        t.setAccessible(true);
        t.set(customer, "李雷");
        System.out.println(customer.getT());

        Method method = classzz.getMethod("getResult",String.class);
        Object o = method.invoke(customer, "我是阿里巴巴旗下天猫");
        System.out.println(o);

    }
}
