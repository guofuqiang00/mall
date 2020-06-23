package lambda.test;

import com.mall.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 集合   数组
 * */
public class LambdaTestApi {


    @Test
    public void test() {


        //1 可以通过Collection 系列集合提供Stream() 或 parallelStream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2 通过Arrays 中的静态方法stream() 获取数组流
        User[] users = new User[10];
        Arrays.stream(users);

        //3通过Stream 类中的静态方法 of()
        Stream<String> aa = Stream.of("aa", "bb", "cc");

        //4创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 3);
        iterate.limit(10).forEach(System.out::println);

        //生成
        Supplier<Double> supplier = ()-> Math.random();
        Stream<Double> generate = Stream.generate(supplier);
        generate.limit(5).forEach(System.out::println);


    }




}
