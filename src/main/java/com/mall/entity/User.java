package com.mall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;

    private Date createTime;

}