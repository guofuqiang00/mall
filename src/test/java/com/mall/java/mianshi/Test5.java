package com.mall.java.mianshi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String copywriting = "%E4%B8%BD%E6%A0%BC%E8%96%87%E5%B0%94%E5%84%BF%E7%AB%A5%E5%86%85%E8%A3%A4%EF%BC%8C40S%E7%B2%BE%E6%A2%B3%E6%A3%89%E6%9D%90%E8%B4%A8%EF%BC%8C%E5%81%A5%E5%BA%B7%E5%AE%89%E5%85%A8%EF%BC%8C%E4%BA%B2%E8%82%A4%E6%9F%94%E8%BD%AF%E8%88%92%E9%80%82%EF%BC%81%0A%0A%E5%BC%B9%E5%8A%9B%E8%85%B0%E5%A4%B4%EF%BC%8C%E4%B8%8D%E5%8B%92%E5%AE%9D%E5%AE%9D%0A%E5%8F%8C%E6%A1%A3%E8%AE%BE%E8%AE%A1%EF%BC%8C%E4%B8%8D%E5%A4%B9PP%0A%E6%97%A0%E9%AA%A8%E7%BC%9D%E5%88%B6%EF%BC%8C%E4%B8%8D%E7%A3%A8%E8%82%8C%E8%82%A4%0A%0A%E3%80%90%E4%BA%AC%E4%B8%9C%E6%97%97%E8%88%B0%E5%BA%97%E3%80%91%E4%B8%BD%E6%A0%BC%E8%96%87%E5%B0%94%E5%84%BF%E7%AB%A5%E5%86%85%E8%A3%A4%E5%A5%B3%EF%BC%884%E6%9D%A1%E8%A3%85%EF%BC%89%E6%AC%BE%E5%BC%8F%E5%B0%BA%E7%A0%81%E8%87%AA%E9%80%89%0A-----------------%0A%E4%BA%AC%E4%B8%9C%E4%BB%B7%EF%BC%9A46.9%E5%85%83%0A%E5%86%85%E8%B4%AD%E4%BB%B7%EF%BC%9A29.9%E5%85%83%E5%9B%9B%E6%9D%A1%0A%E5%88%92%E7%AE%97%E4%BB%B7%EF%BC%9A49.8%E5%85%83%E5%85%AB%E6%9D%A1%E6%8B%8D%E4%B8%A4%E4%BB%B6%0A%0A%E9%A2%86%E5%88%B8%EF%BC%9Ahttps%3A%2F%2Fcoupon.m.jd.com%2Fcoupons%2Fshow.action%3Fkey%3Dec8a339f025e4103a82201e8fbb035f2%26roleId%3D37145667%26to%3Ditem.jd.com%2F30339731415.html%0A%E6%8A%A2%E8%B4%AD%EF%BC%9A30339731415%20%20%20P20.";

        copywriting = URLDecoder.decode(copywriting, "UTF-8");
        String patt = "[^\\n]*抢购";
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(copywriting);
        System.out.println(m);
        while (m.find()) {
            copywriting=copywriting.replace (m.group(0),"抢券+下单: http");
        }
        System.out.println(copywriting);


//        String shortURL= longLink(skuid,link,flag,unionId);
//        newString=copywriting.replace (link,shortURL);
//        splicing(newString,skuid,shortURL);



        //        String decode = null;
//        try {
//            decode = URLDecoder.decode(str, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        StringBuffer stringBuffer = new StringBuffer(decode);
//
//        System.out.println("---->>>>>>>>>>>>>>>>>>>>>>>");
//        int index = stringBuffer.indexOf("划算价");
//        StringBuffer sb = new StringBuffer();
//        System.out.println(index);
//        sb.append("\n");
//        sb.append("aa");
//        sb.append("+");
//        sb.append("订单:");
//        sb.append("https://coupon.m.jd.com/coupons/show.action?key=ec8a339f003a82201e8fbb03a82201e8fbb03a82201e8fbb03a82201e8fbb25e4103a82201e8fbb035f2&roleId=37145667&to=item.jd.com/30339731415.html");
//        StringBuffer replaceResult = stringBuffer.replace(index+15, stringBuffer.length(), sb.toString());
//        System.out.println(replaceResult);
//        String value = "";
//        try {
//            value  = URLEncoder.encode(String.valueOf(replaceResult), "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }
}
