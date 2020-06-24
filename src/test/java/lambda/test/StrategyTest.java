package lambda.test;

import lambda.service.A;
import lambda.service.impl.B;
import lambda.service.impl.C;
import lambda.service.impl.Context;

import java.util.function.Function;

/**
 * 策略模式
 * */
public class StrategyTest {
    public static void main(String[] args) {

        //选择并创建需要使用的策略对象
        C c = new C();

        A a = new B();
        Context context = new Context(a);
        int ss = context.contextInterface(4, 5);
        System.out.println(ss);

        Function<String,String> function =   (x)->x;
        String sdsad = function.apply("sdsad");
        System.out.println(sdsad);


    }
}
