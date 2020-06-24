package com.mall.strategy;

import lombok.Data;

public abstract class AbstractClass {

    public String uname = "admin";
    public String upwd = "123456";

    public abstract boolean isFlag(String uname,String upwd);

}
