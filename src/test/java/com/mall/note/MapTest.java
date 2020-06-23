package com.mall.note;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  java中最基本的结构 数组 和 模拟指针(引用)
 *
 *   Map->数组和链表的结合体 链表散列
 *   HashMap是一种支持快速存取的数据结构
 *   HashMap底层实现还是数组 只是数组的每一项都是一条链
 *       指针指向下一个数据的内存地址
 *       因为数据都是分散存储的,所以想要访问数据 只能从第一个数据开始 顺着指针的方向->往下访问（这便是顺序访问）
 *       对于添加数据来说，就很简单 只需要改变添加位置前后的指针指向就可以
 *       https://blog.csdn.net/chongmen1956/article/details/100803758
 *
 *   循环链表 在链表尾部使用指针 指向 链表头部的数据
 *
 *
 *   https://www.cnblogs.com/williamjie/p/9358291.html
 * */
public class MapTest {

    public static void main(String[] args) {

        /**
         * 相邻元素之间通过指针进行连接
         * 最后一个元素的后继指针值为NULL
         * 在程序执行的过程中，链表的长度可以增加或缩小
         * 链表的空间能够按需分配(直到系统内存耗尽)
         * 没有内存空间的浪费(但是链表中的指针需要一些额外的内存开销)
         * */
        /**
         * 结点：链表是通过指针将自足零散的内存块串联在一起，所以，将每个内存块就是链表的一个"结点"
         * 后继指针：每个链表的结点除了存储数据之外，还需要记录链路上下一个节点的地址，将记录下一个结点地址的指针叫做后继指针。
         * 头结点：整个链路中第一个结点称之为“头结点”
         * 尾节点：整个链路中最后一个结点称之为“尾节点”
         * 空地址NULL：当一个指针指向的不是下一个结点，而是空地址NULL，表示这是链路上的最后一个结点。
         * */

        /**
         *
         * */


        Map<String,Object> map = new HashMap<>();
        map.put("a1",1);
        map.put("a2",1);
        map.put("a3",1);
        map.put("a4",1);
        map.put("a5",1);
        map.put("a6",1);
        map.put("a7",1);
        map.put("a8",1);
        map.put("a9",1);
        map.put("a10",1);
        map.put("a11",1);
        map.put("a12",1);
        map.put("a13",1);
        map.put("a14",1);
        map.put("a15",1);
        map.put("a16",1);
        map.put("a17",1);
        map.put("a18",18);
        map.put("a19",19);
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            System.out.println(map.get(next));
        }


    }
}
