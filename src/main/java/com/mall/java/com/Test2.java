package com.mall.java.com;

import com.mall.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    private void test(int a){
        a = 7;
        System.out.println("test-a-->"+a);
    }
    public void test2(User user){
        user.setAge(20);
        System.out.println("test2--->>"+user.getAge());
    }
    public static void main(String[] args) {
        Test2 t = new Test2();
        User u = new User();
        u.setAge(10);
        t.test2(u); //10

        System.out.println(u.getAge());

        int a = 4;
        t.test(a);  // 7  test
        System.out.println(a); //4



        int [] array = new int[]{1,2,3,4,5};
        for(int min=0,max =array.length-1;min<max;min++,max--){
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }

        for (int i : array) {
            System.out.println(i);
        }



        User user = new User(1,"a","c",18);
        List<User> list = new ArrayList<>();
        list.add(user);
        System.out.println(list);

        String aa ="中";
        String cc= aa;
        System.out.println(aa);
        aa = "中";
        System.out.println(aa);
        System.out.println(aa==cc);




    }
}
