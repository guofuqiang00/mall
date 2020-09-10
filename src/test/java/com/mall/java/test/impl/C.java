package com.mall.java.test.impl;

import com.mall.java.test.service.InterfaceA;

public class C implements InterfaceA {
    @Override
    public String read() {
        return "read C";
    }

    @Override
    public String write() {
        return "write C";
    }
}
