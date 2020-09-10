package com.mall.java.thread;

public class Test4 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer a = null;
                System.out.println(a);
                System.out.println(Thread.currentThread().getName());
            }
        };

        new Thread(runnable).start();



      new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
