package com.mall.java.a;

public interface InterfaceClass {



    //不可变产量
    public static final int task = 6;

    //抽象方法
    public abstract String getMsg();

    //普通方法
    default String getinfo(){
        return "abc";
    }


}
