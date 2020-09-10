package com.mall.java.mianshi;

public class Test {

    private String name;
    public Test(){
        System.out.println("构造函数");
    }
    public Test(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
