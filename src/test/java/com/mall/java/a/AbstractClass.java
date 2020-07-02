package com.mall.java.a;

import lombok.Data;

@Data
public abstract class AbstractClass {

    private Integer id;
    private String name;

    public AbstractClass(){

    }

    public AbstractClass(Integer id) {
        this.id = id;
    }

    //方法声明 抽象方法
    public abstract String show(String msg);

    //方法实现
    public String run(){
        return "非抽象方法";
    }


}
