package com.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User2 {
    private Integer id;
    private String username;
    private String password;
    private int age;
    private int sex;
    private Date createTime;
}
