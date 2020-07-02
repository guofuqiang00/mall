package com.mall.java.a;
public class Test {

    public static void main(String[] args) {

        A a = new A();
        a.setName("小小");
        B b = new B();
        b.setId(124667885);


        System.out.println(a);
        System.out.println(b);
        String run = a.run();
        System.out.println(run);

        //抽象类
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public String show(String msg) {
                return null;
            }
        };
        String run1 = abstractClass.run();
        System.out.println(run1);


    }


    //接口
    @org.junit.Test
    public void test(){
        C c = new C();
        String msg = c.getMsg();
        String getinfo = c.getinfo();
        System.out.println(msg);
        System.out.println(getinfo);
        InterfaceClass interfaceClass = new C();
    }

    public static final int task = 6;
    @org.junit.Test
    public void test2(){


    }


}
