package lambda.test;

import com.mall.entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.ToIntFunction;

/**
 * 终止操作
 * */
public class LambdaTestApi4 {


    /**
     * 查找与匹配
     * allMatch 检查是否匹配所有元素
     * anyMatch 检查是否匹配至少一个元素
     * noneMatch 检查是否没有匹配所有元素
     * findFirst 返回第一个元素
     * findAny 返回当前流中的任意元素
     * count 返回流中元素的总个数
     * max 返回流中最大值
     * min 返回流中最小值
     * */


    List<User> userList = Arrays.asList(
            new User(1,"admin1","admin1",18, User.Status.FREE),
            new User(2,"admin2","admin2",19, User.Status.BUSY),
            new User(3,"admin3","admin3",17, User.Status.VOCATION),
            new User(4,"admin4","admin4",30, User.Status.VOCATION)
    );

    @Test
    public void test(){
        //1
        boolean b = userList.stream()
                .allMatch(e -> e.getStatus().equals(User.Status.BUSY));
        System.out.println(b);

        //2
        boolean b1 = userList.stream()
                .anyMatch(e -> e.getStatus().equals(User.Status.BUSY));
        System.out.println(b1);

        //3
        boolean b2 = userList.stream()
                .noneMatch(e -> e.getStatus().equals(User.Status.BUSY));
        System.out.println(b2);

        //4
        Optional<User> first = userList.stream()
                .sorted(Comparator.comparingInt((e)->{
                    return -e.getAge();
                }))//排序
                .findFirst();
        System.out.println(first.get());

        //5  .stream() 串行流 一个个的找出来    parallelStream()并行流 多个线程共同完成过滤
        Optional<User> any = userList.parallelStream()
                .filter((e) -> e.getStatus().equals(User.Status.VOCATION))
                .findAny();
        System.out.println(any.get());

        //6 count
        long count = userList.stream()
                .count();
        System.out.println(count);

        //7 MAX 最大值
        Optional<User> max = userList.stream()
                .max((x,y)->x.getAge().compareTo(y.getAge()));
        System.out.println(max.get());

        //7 MIN 最小值
        Optional<User> min = userList.stream()
                .min((x,y)->x.getAge().compareTo(y.getAge()));
        System.out.println(min.get());

        //
        Optional<String> s = userList.stream()
                .max(Comparator.comparingInt(x->x.getAge()))
                .map(x->x.getUsername());
        System.out.println(s.get());


    }


    public Integer getInt(Integer a){
        return a;
    }
    public Integer getAge(Integer value) {
        return value;
    }
    int applyAsInt(Integer value){
        return  value;
    };
    @Test
    public void test2(){
        LambdaTestApi4 lambdaTestApi4 = new LambdaTestApi4();

        Comparator<R> comparator = Comparator.comparingInt(R::getAge);
        R r = new R();
        r.setAge(8);
        R r2 = new R();
        r2.setAge(5);
        int compare = comparator.compare(r,r2);
        System.out.println(compare);

        User user = new User();

        ToIntFunction<Integer> toIntFunction = x->x;

        Comparator<Integer> userComparator = Comparator.comparingInt(x->x);
        int compare1 = userComparator.compare(5, 5);
        System.out.println(compare1);


    }

}
