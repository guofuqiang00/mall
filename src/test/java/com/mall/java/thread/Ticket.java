package com.mall.java.thread;

public class Ticket {
    private static int ticket =100;

    public void reduct(){
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
