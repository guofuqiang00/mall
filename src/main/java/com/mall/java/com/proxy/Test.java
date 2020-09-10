package com.mall.java.com.proxy;

import com.mall.entity.AEnum;

public class Test {
    public static void main(String[] args) {

        /**
         * 静态代理
         * */
        IProducer iProducer = new IProducerImpl();
        IProducerStaticProxy iProducerProxy = new IProducerStaticProxy(iProducer);
        iProducerProxy.saleProduct(500f);


        //枚举
        AEnum success = AEnum.success;
        System.out.println(success.getCode());
        System.out.println(success.getMsg());

    }
}
