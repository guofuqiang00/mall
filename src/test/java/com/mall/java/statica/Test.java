package com.mall.java.statica;



public class Test {
    public static void main(String[] args) {

        Persion persion = new Persion();
        persion.setAge(15);

        Persion persion1 = new Persion();
        persion.setAge(18);

        System.out.println(persion.getAge());
        System.out.println(persion1.getAge());


    }
}
