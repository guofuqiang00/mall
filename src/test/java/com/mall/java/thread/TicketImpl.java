package com.mall.java.thread;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TicketImpl<ticket> implements Runnable{

    private static  int ticket=100;
    Object object = new Object();

    ReentrantLock lock = new ReentrantLock();




    //1
    public synchronized void reduct(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"正在卖出第"+ticket+"张票");
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void  run() {

        while (true){
           synchronized (this){
               reductLock();
           }
        }
    }



    //2
    public static synchronized void reduct2(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"正在卖出第"+ticket+"张票");
            ticket--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //3
    public static void reduct3(){
       synchronized (TicketImpl.class){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖出第"+ticket+"张票");
                ticket--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //4
    public  void reductLock(){
          lock.lock();
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"正在卖出第"+ticket+"张票");
                ticket--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock(); //无论程序是否异常都会释放锁
                }
            }
           // lock.unlock();
    }


}
