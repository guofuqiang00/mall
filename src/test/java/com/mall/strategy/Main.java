package com.mall.strategy;

import lombok.Data;

public class Main extends AbstractClass {


    @Override
    public boolean isFlag(String uname, String upwd) {
        if(uname.equals(upwd)){
            return  true;
        }else{
            return false;
        }
    }
}
