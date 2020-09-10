package com.mall.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class User implements Serializable  {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Status status;
    private String msg;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    public User(Integer id, String username, String password,Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;

    }

    public User(Integer id, String username, String password, Integer age, Status status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.status = status;
    }

    public User() {
    }

    public Integer getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getAge().equals(user.getAge())) return false;
        if (getStatus() != user.getStatus()) return false;
        if (!getMsg().equals(user.getMsg())) return false;
        return getCreateTime().equals(user.getCreateTime());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getAge().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getMsg().hashCode();
        result = 31 * result + getCreateTime().hashCode();
        return result;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }

}

