package com.mall.java.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class RequestTest {

    @Autowired
    private HttpServletRequest request;

    @Test
    public void test(){
        System.out.println(request);
    }
}
