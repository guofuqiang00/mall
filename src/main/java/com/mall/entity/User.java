package com.mall.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String msg;

    private static final long serialVersionUID = 1L;
}