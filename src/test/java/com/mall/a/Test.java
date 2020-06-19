package com.mall.a;

import com.mall.base.BaseCaseTest;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String str = "";
        boolean empty = StringUtils.isEmpty(str);
        String str2 = null;
        System.out.println(empty);
        boolean empty2 = StringUtils.isEmpty(str2);
        System.out.println(empty2);

        boolean notEmpty = StringUtils.isNotEmpty(str);
        boolean notEmpty2 = StringUtils.isNotEmpty(str2);
        System.out.println(notEmpty);
        System.out.println(notEmpty2);

        String strs = "15888548885,789521555";
        String[] split = strs.split(",");
        Arrays.stream(split).forEach(System.out::println);

        StringBuffer sb = new StringBuffer();
        for(String ss:split){
            sb.append(ss+",");
        }

        System.out.println("aa-------------->>>>>>>>>>>>>");
        String substring = sb.substring(0, sb.length() - 1);







    }
}
