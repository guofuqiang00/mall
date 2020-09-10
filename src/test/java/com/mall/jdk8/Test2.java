package com.mall.jdk8;

import com.mall.entity.User;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<U> us = Arrays.asList(
                new U(11, "男"),
                new U(10, "男"),
                new U(22, "女")
        );

        us.stream().filter(x->x.getSex().equals("男")).forEach(System.out::println);

        us.stream().filter((x)->{
            if(x.getSex().equals("男")){
                return  true;
            }else{
                return  false;
            }
        }).forEach(System.out::println);


        String [] arrays = new String[]{"a","b","c","d","e"};

        for (int i = 0; i < arrays.length; i++) {
            int j = 1;
            int length = arrays.length-j ;
            String temp = arrays[i];
             String last =  arrays[length];
            j++;
           if(i>length){
               break;

           }else{
               arrays[i]=arrays[length];
               arrays[length]=temp;

           }

        }

        for (String s:arrays
             ) {
            System.out.println(s);

        }







    }
}
