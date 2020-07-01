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
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;


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

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        return getAge() != null ? getAge().equals(user.getAge()) : user.getAge() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION
    }

}

