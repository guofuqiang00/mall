package com.mall.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringTest {


    static class MyDate{
        int year;
        int mouth;
        int day;
    }

    private static String parse(String date){
        String[] split = date.split("/");
        String dateTime = "";
        if(split.length>=3){
          int year = Integer.parseInt(split[2]);
          int mouth = Integer.parseInt(split[1]);
          int day = Integer.parseInt(split[0]);
          dateTime = year+"/"+mouth+"/"+day;
        }
        return  dateTime;
    }


    public static void main(String[] args) throws ParseException {



        String apStr =null,code =null;

        String str = "11/11/2020";

        System.out.println(StringTest.parse(str));


        String ss = "2018年03月18日";
        String str1 = ss.substring(0, ss.indexOf("年"));
        String str2 = ss.substring(str1.length()+1,ss.indexOf("月"));
        String str3 = ss.substring(str1.length()+str2.length()+2,ss.indexOf("日"));
        System.out.println("str1=="+str1);
        System.out.println("str2=="+str2);
        System.out.println("str3=="+str3);


        String name = "监事单位";
        if(name.contains("副会长")){
            System.out.println("副会长");
        }else if(name.contains("理事")){
            System.out.println("理事");
        }else if(name.contains("监事")){
            System.out.println("监事");
        }else if(name.contains("一般")||name.contains("会员")){
            System.out.println("一般");
        }else{
            System.out.println("其他");
        }


        Calendar instance = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        instance.set(Calendar.YEAR,instance.get(Calendar.YEAR)+1);
        Date time = instance.getTime();
        String format = sdf.format(time);
        System.out.println(format);
    }

}
