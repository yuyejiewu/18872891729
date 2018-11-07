package com.luow.life.common.test;

import java.util.Arrays;
import java.util.Collection;

public class Customer<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Customer() {
    }

    //从数组到集合复制
    public <T> void copyToCollection(T[] t, Collection<T> c){
        for (T t1 : Arrays.asList(t)) {
            c.add(t1);
        }
    }

    public String getResult(String result){
        return result;
    }
}
