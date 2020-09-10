package com.mall.java.test.impl;

import com.mall.java.test.service.InterfaceA;
import lambda.service.A;

public class B implements InterfaceA {
    @Override
    public String read() {
        return "read b";
    }

    @Override
    public String write() {
        return "write b";
    }
}
