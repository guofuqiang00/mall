package com.mall.java.nio;

import java.nio.IntBuffer;

public class NioTest {
    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(12);
        intBuffer.put(5);
        intBuffer.put(45);
        System.out.println(intBuffer.capacity());
    }
}
