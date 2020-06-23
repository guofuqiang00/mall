package lambda.test;


import com.mall.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 筛选与切片
 *  filter-接收lambda,从流中排除某些元素
 *  limit-截断流 使其元素不超过给定数量
 *  skip(n) 跳过元素，返回一个扔掉了前n个元素的流 若流中元素不足n个则返回一个空流，与limit(n)互补
 *  distinct-筛选 通过流生成元素的hashcode（）和equals() 去除重复元素
 *
 * */
public class LambdaTestApi2 {

    List<User> list = Arrays.asList(
            new User(1,"张三","admin",20),
            new User(1,"李四","admin",35),
            new User(1,"李四","admin",18),
            new User(1,"网二","admin",40),
            new User(1,"小李","admin",36)
    );

    @Test
    public void test(){

        //要有终止操作  才会执行中间操作
        //惰性求值
        //懒加载
        //内部迭代 迭代操作由Stream Api 完成
        Stream<User> userStream = list.stream()
                .filter((e) -> e.getAge() > 10)
                .limit(2);//中间操作

        //终止操作 一次性执行全部操作  即惰性求值
        userStream.forEach(System.out::println);
        }


        @Test
        public void test3(){
        // skip() 跳过满足条件的
            list.stream()
                    .filter(e->e.getAge()>10)
                    .skip(3)  //跳过前三个 取后两个
                    .forEach(System.out::println);

        }

        //去重
        @Test
        public void test4(){
          list.stream()
                  .filter(e->e.getAge()>10)
                  .distinct()
                  .forEach(System.out::println);
        }
        
        //外部迭代
        @Test
        public void test2(){
            Iterator<User> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

        }


        /**
         * 映射
         *  map - 接收lambda 将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上
         *  并将其映射成一个新的元素
         *  flatMap 接收一个函数作为参数，将流中的每个值都换成另一个流 然后把所有流连接成一个流
         *
         * **/
        @Test
        public void test5(){

            List<String> list2 = Arrays.asList("aaa","bbb","ccc","ddd","eee");
            list2.stream()
                    .map(str->str.toUpperCase())
                    .forEach(System.out::println);

            list.stream()
                    .map(User::getUsername)
                    .forEach(System.out::println);


            //flatMap
            Stream<Stream<Character>> streamStream = list2.stream()
                    .map(LambdaTestApi2::filterCharacter);//{ {a,a,a},{b,b,b},{c,c,c}}
            streamStream.forEach(x->x.forEach(System.out::println));

            list2.stream()
                    .flatMap(LambdaTestApi2::filterCharacter) //{a,a,a},{b,b,b},{c,c,c}
                    .forEach(System.out::println);




            char[]cc={'a','b'};
            int []aa = {1,2};
            Arrays.stream(aa);


        }


        public static Stream<Character> filterCharacter(String str){
            List<Character> list = new ArrayList<>();
            for (Character cc:str.toCharArray()) {
                list.add(cc);
            }
            return list.stream();
        }

        @Test
        public void test6(){

            List<String> list = Arrays.asList("aaa","bbb");

            List list2 = new ArrayList();
            list2.add(11);
            list2.add(list);
            System.out.println(list2);
            list2.addAll(list);
            System.out.println(list2);
        }






}
