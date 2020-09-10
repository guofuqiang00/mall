package com.mall.java.com.proxy;

public class IProducerImpl implements IProducer {
    @Override
    public void saleProduct(Float money) {
        System.out.println("获得"+money+"元");
    }
}
