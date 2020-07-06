package com.mall.java.demo;

import com.mall.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        User user = new User(10001,"admin","123456",18);

        List list = new ArrayList();
        list.add("cccc");
        list.add("dddd");

        List list1 = new ArrayList();
        list1.addAll(list);

        System.out.println(list);
        System.out.println(list1);


    }
}
