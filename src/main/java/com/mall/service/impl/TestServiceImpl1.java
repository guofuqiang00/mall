package com.mall.service.impl;

import com.mall.service.TestService1;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl1 implements TestService1 {
    @Override
    public String read() {
        return "TestServiceImpl1";
    }
}
