package com.mall.java.b;

import com.mall.entity.User;

import java.util.Optional;

public class Test {

    private static String name="admin";


    public static void main(String[] args) {

        Test.name="123456";
        System.out.println(Test.name);

        Optional<User> optionalS = Optional.empty();


    }
}
