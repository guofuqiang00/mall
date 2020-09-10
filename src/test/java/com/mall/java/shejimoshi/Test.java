package com.mall.java.shejimoshi;

public class Test {
    public static void main(String[] args) {
        CarFactory carFactory =new CarFactory();
        Car c = carFactory.getCar("C");
        Car d = carFactory.getCar("D");
        c.run();
        d.run();
    }
}

class C implements Car{
    @Override
    public void run() {
        System.out.println("c车");
    }
}
class D implements Car{
    @Override
    public void run() {
        System.out.println("D车");
    }
}

class CarFactory{
    public Car getCar(String type){
        if(type.equals("C")){
            return new C();
        }else{
            return new D();
        }
    }
}
