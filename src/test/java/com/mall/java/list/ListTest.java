package com.mall.java.list;

import com.mall.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

        List<Student> stus = new ArrayList<>();
                stus.add(new Student("zhangsan"));
                stus.add(new Student("lisi"));
                 stus.add(new Student("zhangsan"));
                 stus.add(new Student("zhangsan"));
                 stus.add(new Student("wangwu"));
         //   第一种
         //        for (int i = 0; i < stus.size() - 1; i++) {
         //            for (int j = i + 1; j < stus.size()-1; j++) {
         //                if (stus.get(i).getName().equals(stus.get(j).getName())) {
         //                    stus.remove(stus.get(i));
         //                }
         //            }
         //        }
         //        System.out.println(stus);
         //        第二种
         //        定义一个新集合
                 List<Student> stus2 = new ArrayList<>();
                 for (int i = 0; i < stus.size(); i++) {
                         if (!stus2.contains(stus.get(i))) {// 内部调用了equals方法，所以比的是栈中的引用地址，所以要重写equals方法
                                 stus2.add(stus.get(i));
                             }
                     }
                 System.out.println(stus2);


                 String str ="张三";
                 String str2 = "张三";
                 String str3 = new String("张三");
                 String str4 = new String("张三");

                System.out.println(str.equals(str4));
                System.out.println(str3.equals(str4));
                System.out.println(str3==str4);



                User user = new User(1,"'张三'","admin",10);
                User user2 = new User();
                System.out.println(user.getUsername().equals("张三"));


                Student stt = new Student("张三");
                System.out.println("------------------");
                System.out.println(stt.getName().equals("张三"));

             }

}

class Student implements Serializable {
   private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }



    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }*/

}

