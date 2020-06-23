package lambda.test;

import com.mall.entity.User;
import lambda.AbstractClass;
import lambda.service.LambdaService;
import lambda.service.LambdaService2;
import lambda.service.impl.LambdaServiceImpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    List<String> ll = new ArrayList<>();


    List<User> userList = Arrays.asList(
            new User(1001,"admin","password",35),
            new User(1002,"123456","123456",35),
            new User(1003,"qqqwww","qqqwww",35)
    );


    public List<User> lambdaTest(List<User> list, LambdaService<User> us){
        List list1  = new ArrayList();
        for (User user:list) {
           if(us.show(user)){
               list1.add(user);
           }
        }
        return list1;
    }




    @org.junit.Test
    public void test1(){
        List<User> users = lambdaTest(userList, new LambdaServiceImpl());
        System.out.println(users);
    }


    /**匿名内部类*/
    @org.junit.Test
    public void test2(){
        List<User> users = lambdaTest(userList, new LambdaService<User>() {
            @Override
            public boolean show(User user) {
                return user.getUsername().equals("123456");
            }
        });

        System.out.println(users);
    }

    /**lambda表达式*/
    @org.junit.Test
    public void test3(){
        List<User> users = lambdaTest(userList, (e) -> e.getUsername().equals("admin"));
        users.forEach(System.out::println);
    }

     /**lambda 过滤*/
    @org.junit.Test
    public void test4(){
        List<User> list = new ArrayList<>();
        userList.stream()
                .filter((e)->!e.getUsername().equals("qqqwww"))
                . forEach(e->list.add(e));
        System.out.println(list);
    }

    /**匿名内部类*/
    @org.junit.Test
    public void test5(){
        LambdaService<User> admin = new LambdaService<User>() {
            @Override
            public boolean show(User user) {
                return user.getUsername().equals("qqqwww");
            }
        };

        for (User us:userList) {

            if(admin.show(us)){
                System.out.println(us);
                break;
            }
        }

    }
    /**new  一个抽象类*/
    @org.junit.Test
    public void test6(){
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void run() {
                System.out.println("抽象方法");
            }
        };

        abstractClass.run();
        abstractClass.run2();


        /**new  一个实现类  实现类已经做了业务处理*/
        LambdaServiceImpl lambdaService = new LambdaServiceImpl();
        boolean show = lambdaService.show(new User());

        /**new  一个接口**/
        LambdaService<User> lambdaService1 = new LambdaService<User>() {
            @Override
            public boolean show(User user) {
                return false;
            }
        };

    }


    public Long testLambda(long l1, long l2, LambdaService2<Long, Long> lambdaService2){
        Long show = lambdaService2.show(l1, l2);
        return show;
    }

    @org.junit.Test
    public void test7() {
        long x = 10L;
        long y = 5L;

        Long aLong = testLambda(x, y, (e1, e2) -> x + y);
        System.out.println(aLong);
    }

    /**lambda函数接口*/




}
