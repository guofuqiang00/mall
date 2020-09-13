package jdk.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * String常用方法
 * */

public class Test {

    public static void main(String[] args) {

        String str = "这是真的吗";

        /**字符串 replace 替换*/
        String newValue = str.replace("是", "一定是");
        System.out.println(newValue); //这一定是真的吗


        //切割n-1次  3-1
        String[] split = str.split("",3);
        String s = Arrays.toString(split);
        System.out.println(s); // [这, 是, 真的吗]


    }
}
