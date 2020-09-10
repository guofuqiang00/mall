package com.mall.java.com.proxy;

public class IProducerStaticProxy implements IProducer {

    private IProducer iProducerl;

    public IProducerStaticProxy(IProducer iProducer){
        this.iProducerl = iProducer;
    }



    @Override
    public void saleProduct(Float money) {
        Float money2 = money + 80f;
        iProducerl.saleProduct(money2);
        System.out.println("代理结束之后");
    }
}
