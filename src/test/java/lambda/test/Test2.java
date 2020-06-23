package lambda.test;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test2 {

  List<Transaction> transactions = null;

   @Before
    public void before(){
       Trader trader = new Trader("Raoul","Cambridge");
       Trader trader2 = new Trader("Mario","Milan");
       Trader trader3 = new Trader("Alan","Cambridge");
       Trader trader4 = new Trader("Brian","Cambridge");

       transactions = Arrays.asList(
               new Transaction(trader,2011,300),
               new Transaction(trader2,2012,1000),
               new Transaction(trader2,2011,400),
               new Transaction(trader3,2012,710),
               new Transaction(trader3,2012,700),
               new Transaction(trader4,2012,950)
       );

   }

   @Test
    public void test(){
       //找出2011年发生的所有交易，并按交易额排序（从低到高）
        transactions.stream()
               .filter(x -> x.getYear() == 2011)
               .sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
               .forEach(System.out::println);
        //交易员都在那些不同的城市工作过
       transactions.stream()
               .map(e->e.getTrader().getCity())
               .distinct()
               .forEach(System.out::println);


       //查询来自剑桥的所有交易 并按姓名排序
       transactions.stream()
               .filter(x->x.getTrader().getCity().equals("Cambridge"))
               .map(Transaction::getTrader)
               .sorted(Comparator.comparing(x->x.getName()))
               .forEach(System.out::println);

       //返回所有交易员的姓名字符串，按字母顺序排序
       transactions.stream()
               .map(e->e.getTrader().getName())
               .sorted(String::compareTo)
               .forEach(System.out::println);

       //有没有交易员是米兰工作的
       /*transactions.stream()
               .filter(e->e.getTrader().getCity().equals("Milan"))
               .forEach(System.out::println);*/
       boolean milan = transactions.stream()
               .anyMatch(e -> e.getTrader().getCity().equals("Milan"));
       System.out.println(milan);

       //打印生活在剑桥的 交易员的所有交易额
       Optional<Integer> cambridge = transactions.stream()
               .filter(e -> e.getTrader().getCity().equals("Cambridge"))
               .map(e -> e.getValue())
               .reduce(Integer::sum);
       System.out.println("总交易额="+cambridge.get());

       System.out.println("---------");

       //所有交易中，最高的交易额是多少
       Optional<Integer> max = transactions.stream()
               .map(e -> e.getValue())
               .max(Comparator.comparingInt(e->e));
       System.out.println(max.get());

       //交易额最小的交易
       Optional<Integer> min = transactions.stream()
               .map(e -> e.getValue())
               .min(Comparator.comparingInt(e -> e));
       System.out.println(min.get());


   }



}
