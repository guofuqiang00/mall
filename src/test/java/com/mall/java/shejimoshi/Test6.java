package com.mall.java.shejimoshi;

import com.mall.java.thread.SingleDemo;

/**
 * 单例模式及工厂模式
 * */
public class Test6 {
    public static void main(String[] args) {
        SingleDemo singleDemo = SingleDemo.getSingleDemo();
        singleDemo.setName("aaaa");
        System.out.println(singleDemo);
        A a = new A();
        SingleDemo singleDemo1 = a.singleDemo;
        System.out.println(singleDemo1);
    }
}

class A{
    SingleDemo singleDemo = SingleDemo.getSingleDemo();
}

class B{

}



