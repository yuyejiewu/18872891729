package com.luow.life.common.test;

class Titck implements Runnable{

    int titck = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (titck > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票,票号为:" + titck --);
                }
            }
        }
    }
}

public class TitckThread {
    public static void main(String[] args) {
        Titck titck = new Titck();
        Thread t1 = new Thread(titck);
        Thread t2 = new Thread(titck);
        Thread t3 = new Thread(titck);
        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");
        t1.start();
        t2.start();
        t3.start();
    }
}
