package com.mall.strategy;

public class Test {
    public static void main(String[] args) {
        Main main = new Main();
        boolean flag = main.isFlag(main.uname,main.upwd);
        System.out.println(flag);
    }
}
