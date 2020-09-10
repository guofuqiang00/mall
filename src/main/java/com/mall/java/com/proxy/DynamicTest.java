package com.mall.java.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理模式
 * **/
public class DynamicTest {
    public static void main(String[] args) {
                                                          /**动态代理*/

        //被代理对象
        final IProducer iProducer = new IProducerImpl();

        //动态的创建代理对象
        IProducer  iProducer1 = (IProducer) Proxy.newProxyInstance(iProducer.getClass().getClassLoader(), iProducer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //提高用于增强的代码
                        Object returnValue = null;

                        //获取方法执行的参数
                        Float money = (Float) args[0];

                        //判断是否是销售方法 --该方法是需要增强的方法--
                        if ("saleProduct".equals(method.getName())) {
                            //代理商需要抽取20%的费用,生产商只能获得80%的费用
                            returnValue = method.invoke(iProducer, money * 0.8f);
                        }

                        return returnValue;
                    }
                }
        );
        iProducer1.saleProduct(100f);

    }
}
