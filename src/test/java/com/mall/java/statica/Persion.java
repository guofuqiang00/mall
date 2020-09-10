package com.mall.java.statica;

import lombok.Data;

@Data
public class Persion {

    private static  int age;

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Persion.age = age;
    }
}
