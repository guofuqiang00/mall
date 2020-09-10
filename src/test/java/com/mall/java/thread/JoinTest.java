package com.mall.java.thread;

import com.mall.entity.User;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        // TODO Auto-generated method stub
        /**
         * 主线程在t1.join()方法处停止，并需要等待A线程执行完毕后才会执行t3.start()，然而，并不影响B线程的执行。
         * 因此，可以得出结论，t.join()方法只会使主线程进入等待池并等待t线程执行完毕后才会被唤醒。并不影响同一时刻处在运行状态的其他线程。
         * */
        System.out.println(Thread.currentThread().getName()+" start");
        ThreadA t1=new ThreadA("A");
        ThreadA t2=new ThreadA("B");
        ThreadA t3=new ThreadA("C");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        System.out.println("t1start");
//        t1.start();
//        System.out.println("t1end");
//        System.out.println("t2start");
//        t2.start();
//        System.out.println("t2end");
//        t1.join();
//        System.out.println("t3start");
//        t3.start();
//        System.out.println("t3end");
//        System.out.println(Thread.currentThread().getName()+" end");



    }
}


class ThreadA extends Thread{
    User user1 = new User();
    User user2 = new User();


    private String name;

    public ThreadA(String name){
        this.name =  name ;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            System.out.println(name+"-"+i);
        }
    }
}
