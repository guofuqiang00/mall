package lambda.test;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * 方法引用:若Lambda 体中的内容有方法已经实现了 可以使用方法引用（方法引用时Lambda表达式的另一种表现形式）
 * 三种语法形式
 *
 *  对象：实力方法名
 *  类：静态方法名
 *  类：实例方法名  参数列表相同
 *
 * */
public class LambdaTest2 {

    //实例方法
    public void out(String username){
        System.out.println("结果"+username);
    }
    //静态放啊
    public static  void run(String username){
        System.out.println("result"+username);
    }

    @Test
    public void Test(){
        Consumer<String> consumer = (x)-> System.out.println(x);
        LambdaTest2 lambdaTest2 = new LambdaTest2();
        PrintStream out = System.out;

        Consumer<String> consumer2 = out::println;
        Consumer<String> consumer3 = lambdaTest2::out;
        Consumer<String> consumer4 = LambdaTest2::run;
        consumer2.accept("sss");
        consumer3.accept("admin");
        consumer.accept("123456");

        BiPredicate<String, String> biPredicate = (x, y)->x.equals(y);
        BiPredicate<String, String> biPredicate2 = String::equals;
        boolean test = biPredicate2.test("admin", "123");
        System.out.println(test);





    }



}
