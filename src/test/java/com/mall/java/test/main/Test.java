package com.mall.java.test.main;

import com.mall.java.test.impl.B;
import com.mall.java.test.service.InterfaceA;

public class Test {
    public static void main(String[] args) {

        InterfaceA a = new B();
        String read = a.read();
        System.out.println(read);
    }
}
