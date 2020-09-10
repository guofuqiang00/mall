package com.mall.java.thread;

import lombok.Data;

@Data
public class SingleDemo {

    private static SingleDemo singleDemo = null;

    private String name;

    public SingleDemo(){}

    public static SingleDemo getSingleDemo(){
        if(null==singleDemo){
            singleDemo = new SingleDemo();

        }
        return singleDemo;
    }

}
