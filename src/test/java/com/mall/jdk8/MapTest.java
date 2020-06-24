package com.mall.jdk8;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {


        /**
         *  url: https://blog.csdn.net/u014231523/article/details/100624932
         *  getOrDefault(Object key, V defaultValue)  如果存在key返回对应的值否则返回默认值
         *  forEach(BiConsumer<? super K, ? super V> action) 遍历map
         *  putIfAbsent(K key, V value) 只有在不存在key值的映射或者映射值为null，才将value值赋值给key。否则不做修改。该方法将条件判断和赋值合二为一
         *  remove(Object key, Object value) 只有在当前Map中key映射的值等于value时才删除该映射，否则什么也不做。
         * */

        Map<String,Object> map = new HashMap<String, Object>(){{
            put("uname","admin");
        }};
        Object orDefault = map.getOrDefault("uname", "默认值");
        System.out.println(orDefault);



        Map<String,Object> map1 = new HashMap<>();
        map.forEach((k,v)->{
            System.out.println("key="+k+"\t"+"value="+v);
            map1.put(k,v);
        });

        map1.forEach((k,v)->{
            System.out.println("key1="+k+"\t"+"value1="+v);
        });

        System.out.println("-------putIfAbsent------");
        Object uname = map.putIfAbsent("uname", "123456");
        Object upwd = map.putIfAbsent("upwd", "123456");
        System.out.println(uname); //null
        System.out.println(upwd); //123456
        System.out.println(map.get("upwd"));


        System.out.println("------remove-----");
        /**remove(Object key, Object value) 只有在当前Map中key映射的值等于value时才删除该映射，否则什么也不做。*/
        boolean upwd1 = map.remove("upwd", "789"); //true
        boolean upwd2 = map.remove("upwd", "123456"); //true
        System.out.println(upwd1); //false
        System.out.println(upwd2); //true


        System.out.println("===========replace(K key, V oldValue, V newValue)===========");
        Map<String,Object> map2 = new HashMap<String, Object>(){{
            put("a","A");
            put("b","B");
        }};

        //map2.replace("a","new A"); // return {a:new A}
        //map2.replace("a","A","new A"); // return {a:new A}
        map2.replace("a","B","new A"); //因为映射的值不对不做更新

        map2.forEach((k,v)->{
            System.out.println("key2="+k+"\t"+"value2="+v);
        });



    }
}
