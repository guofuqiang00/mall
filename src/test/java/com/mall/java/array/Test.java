package com.mall.java.array;

import com.mall.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { //>是从小到大 <从大到小
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {

        int[] arr = {8, 4, 6, 1, 5, 2, 9};
        int[] sort = Test.sort(arr);
        System.out.println(Arrays.toString(sort));


        String[] arrays = new String[]{"a", "b", "c", "d", "e"};
        Collections.reverse(Arrays.asList(arrays));
//        for (int min = 0, max = arrays.length - 1; min < max; min++, max--) {
//            String temp = arrays[min];
//            arrays[min] = arrays[max];
//            arrays[max] = temp;
//        }
        List<String> collect = Arrays.stream(arrays).collect(Collectors.toList());
        System.out.println(collect); //[e, d, c, b, a]

        List<User> list = Arrays.asList(
                new User(1001,"admin","admin",18, User.Status.BUSY),
                new User(1001,"12345","123456",18, User.Status.BUSY),
                new User(1001,"root","root",18, User.Status.BUSY)
        );
        Collection<String> collect1 = list.stream().map(User::getUsername).collect(Collectors.toList());
        System.out.println(collect1); //[admin, 12345, root]

    }
}
