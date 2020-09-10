package com.mall.java.thread;

public class Test {
    public static void main(String[] args) {

        MyThread myThread = new MyThread("Thread->>>01");
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(new MyRunnadble2()).start();
        //匿名内部类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    Thread.currentThread().setName("Thread-2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                }
            }
        }.start();

        Runnable r3 = new Runnable() {

            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        new Thread(r3).start();
    }
}

class MyRunnadble2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            Thread.currentThread().setName("Thread-1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}