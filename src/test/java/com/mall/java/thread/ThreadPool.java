package com.mall.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池 JDK1.5之后提供的
 * java.util.concurrent.Excutors:线程池的工厂类 用来生成线程池
 * */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new myRunnableImpl());
        es.submit(new myRunnableImpl());
        es.submit(new myRunnableImpl());
        es.shutdown(); //销毁线程池
        es.submit(new myRunnableImpl());
    }
}

class myRunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
