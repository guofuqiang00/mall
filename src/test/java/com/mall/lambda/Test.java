package com.mall.lambda;

public class Test {

    public static void main(String[] args) {

        new Thread(()-> System.out.println("线程")).start();
    }
}
