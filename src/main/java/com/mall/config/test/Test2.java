package com.mall.config.test;

import com.mall.entity.User;

import javax.jws.soap.SOAPBinding;

public class Test2 {

    @CherryAnnotation(name = "cherry-peng",age = 23,score = {99,66,77})
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.study(10);

    }

}
