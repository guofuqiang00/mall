package com.mall.java.mianshi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String a ="a";
        String b = "b";
        String c = a+b;
        String d = "ab";
        String f = "a"+"";
        System.out.println(a==f);
        System.out.println(a.equals(f));
        System.out.println(c==d);
        System.out.println(c.equals(d));


    }
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }

    private String getFormatText(String str, String[] paramAry) {
        //格式化模版内容
        for (int i = 0; i < paramAry.length; i++) {
            str = str.replaceAll(String.format("\\{%d\\}", i), paramAry[i]);
        }
        return str;
    }
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");

        }
        return dest;

    }
}

