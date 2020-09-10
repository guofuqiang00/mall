package com.mall.java.thread;

public class Test3 {


    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(){
            @Override
            public void run() {
           while (true){
               synchronized (obj){
                   System.out.println("等待买入。。。。");
                   try {
                       obj.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("开吃开吃");
               }
           }

            }
        }.start();

        new Thread(){
            @Override
            public void run() {

                while (true){
                    try {
                        Thread.sleep(5000);
                        System.out.println("做好了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj){
                        obj.notify();

                    }
                }

            }
        }.start();



    }
}
