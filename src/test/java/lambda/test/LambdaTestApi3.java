package lambda.test;

import com.mall.entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 排序
 * */
public class LambdaTestApi3 {



    List<User> userList = Arrays.asList(
            new User(1,"admin1","admin1",20),
            new User(2,"admin2","admin2",18),
            new User(3,"admin3","admin3",30)
    );


    /**
     * sorted()-自然排序（Comparable)
     * sorted(Comparable com) 定制排序
     * */


    @Test
    public void test(){

        List<String> list = Arrays.asList("aaa","fff","dddd","bbb","ccc");


        //自然排序
       /* list.stream()
                .sorted()
                .forEach(System.out::println);*/







       //定制排序

        //先根据 年龄 再根据 姓名

        User user = new User();

        Comparator<User> comparator = Comparator.comparingInt(User::getAge);
        userList.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getUsername().compareTo(e2.getUsername());
                    }else{
                        return e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);


    /*    List<String> list2 = Arrays.asList("ccc","eee","bbb","fff","aaa");
        Collections.sort(list2); //自然排序
        System.out.println(list2);

        Comparator<User> comparator3 = Comparator.comparingInt(User::getAge);
        Collections.sort(userList,comparator3);
        System.out.println(userList);*/
    }

}
