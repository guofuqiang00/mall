package com.mall.b;

import java.util.stream.IntStream;

public class Test2 {

    public static void main(String[] args) {

        IntStream.range(-15, 15).map(y -> -y).forEach(y -> IntStream.range(-30, 30).
                forEach(x ->
                        System.out.print(Math.pow(Math.pow((x * 0.05), 2)
                                + Math.pow((y * 0.1), 2) - 1, 3) - Math.pow(x * 0.05, 2)
                                * Math.pow(y * 0.1, 3) <= 0 ? "心".charAt(Math.abs((y - x) % 4)) : " " + (x == 40 ? "\n" : ""))));
    }
}
