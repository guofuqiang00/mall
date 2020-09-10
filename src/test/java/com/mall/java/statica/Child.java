package com.mall.java.statica;

import java.nio.IntBuffer;

public class Child extends Base {

    public Child(){
        System.out.println("子类构造函数");
    }
    {
        System.out.println("子类代码块");
    }
    static {
        System.out.println("子类静态代码块");
    }
    void test(){
        System.out.println("子类test普通方法");
    }
    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(2048);
        intBuffer.put(555);
        System.out.println();
        Base child = new Child();
        child.test();
        Base b = new Base();
        b.test();
    }
}

class Base {

    public Base() {
        System.out.println("父类构造函数");
    }

     void test(){
        System.out.println("父类test普通方法");
    }

    static {
        System.out.println("父类静态方法");
    }

    {
        System.out.println("父类普通代码块");
    }


}
