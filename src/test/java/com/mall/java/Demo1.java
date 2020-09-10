package com.mall.java;

import org.junit.Test;

public class Demo1 {


    @Test
    public void test1(){

        String a = "你";
        String b = "你";
        String c = new String("你");
        String d = new String("你");
        int n1 = 10;
        int n2 = 10;
        System.out.println(a==b); //true 堆 字面值
        System.out.println(n1==n2); //true 堆 字面值
        System.out.println(a.equals(b)); //true

        System.out.println(c==d); //false 内存地址
        System.out.println(c.equals(d)); // true 因为String的方法是重写过的所以比较的是值
        //object 中的equals方法比较的对象的内存地址

        System.out.println(a==c); //false 内存地址不同
        System.out.println(a.equals(c)); //true 比较的是值




    }

}
