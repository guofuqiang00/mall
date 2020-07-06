package com.mall.java.demo;

import com.mall.java.en.EnumTest;
import com.mall.java.en.HonourPkCarouselEnum;

public class Test {

    @org.junit.Test
    public void test(){

        EnumTest success_sds = EnumTest.success_sds;
        HonourPkCarouselEnum honourCarouselDayTop = HonourPkCarouselEnum.HONOUR_CAROUSEL_DAY_TOP;
        System.out.println(honourCarouselDayTop.getCode());

    }
}
