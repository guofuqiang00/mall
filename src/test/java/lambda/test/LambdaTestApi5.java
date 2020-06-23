package lambda.test;

import com.mall.entity.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaTestApi5 {

    List<User> userList = Arrays.asList(
            new User(1,"admin","admin",18, User.Status.BUSY),
            new User(2,"admin2","admin2",20, User.Status.VOCATION),
            new User(3,"admin3","admin3",30, User.Status.FREE),
            new User(4,"admin4","admin4",16, User.Status.VOCATION),
            new User(4,"admin4","admin4",16, User.Status.VOCATION)
    );

    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


    /**
     * 归约
     * reduce(T identity,BinaryOperator) /reduce(BinaryOperator) 可以将流中的元素反复结合起来,得到一个值
     * */

    /**
     * 收集
     * collect 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     * */

    @Test
    public void test(){

        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        Optional<Integer> reduce1 = userList.stream()
                .map(x -> x.getAge())
                .reduce(Integer::sum);
        System.out.println(reduce);
        System.out.println(reduce1.get());



        //收集
        List<String> collect = userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
        System.out.println(collect);

        Set<String> collect1 = userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toSet());
        System.out.println(collect1);


        HashSet<String> collect2 = userList.stream()
                .map(User::getUsername)
                .collect(Collectors.toCollection(() -> new HashSet<String>()));
        System.out.println(collect2);

        Supplier<String> stringSupplier = ()-> "adc";

        //统计
        long count = userList.stream().count();
        System.out.println(count);

        //平均值
        Double avg = userList.stream().collect(Collectors.averagingInt((x) -> x.getAge()));
        System.out.println(avg);

        //总和
        Integer sum = userList.stream().collect(Collectors.summingInt((x) -> x.getAge()));
        System.out.println(sum);

        //最大值
        Optional<User> maxValue = userList.stream().collect(Collectors.maxBy((e1, e2)-> Integer.compare(e1.getAge(),e2.getAge())));
        System.out.println(maxValue.get());

        //最小值
        Optional<User> minValue = userList.stream().collect(Collectors.minBy((x, y) -> x.getAge().compareTo(y.getAge())));
        System.out.println(minValue.get());

        //分组
        Map<User.Status, List<User>> group = userList.stream()
                .collect(Collectors.groupingBy(User::getStatus));
        /*for (User.Status user:group.keySet()
             ) {
            System.out.println(group.get(user));
        }*/
        System.out.println(group);

        System.out.println("多级分组-------------");


        //多级分组
        Map<User.Status, Map<String, List<User>>> collect3 = userList.stream()
                .collect(Collectors.groupingBy(User::getStatus, Collectors.groupingBy(e -> {
                    if (e.getAge() > 20) {
                        return "aaa";
                    } else {
                        return "bbb";
                    }
                })));
        System.out.println(collect3);


        //分区
        Map<Boolean, List<User>> collect4 = userList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() < 20));
        System.out.println("--------分区--------");
        System.out.println(collect4);


        //其他方式 获取平均值 最大值 最小值等
        IntSummaryStatistics collect5 = userList.stream()
                .collect(Collectors.summarizingInt(e -> e.getAge()));
        collect5.getAverage();
        collect5.getCount();
        collect5.getMax();
        collect5.getSum();



        //连接字符串
        String collect6 = userList.stream()
                .map(e -> e.getUsername())
              //  .collect(Collectors.joining());
                .collect(Collectors.joining(","));
        System.out.println(collect6);


        Optional<Integer> reduce2 = userList.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce2.get());

    }


    @Test
    public void tt(){
        Optional<String> s = userList.stream()
                .max(Comparator.comparing(e->e.getAge()))
                .map((x) -> x.getUsername());
        System.out.println(s.get());


    }



}
