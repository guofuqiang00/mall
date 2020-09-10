package com.mall.java.thread;

public class MyThread extends Thread {

    MyThread(){}
    MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName());
    }
}
