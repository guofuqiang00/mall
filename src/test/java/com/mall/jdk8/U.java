package com.mall.jdk8;

public class U {

    private  Integer id;
    private  String sex;

    public U(Integer id, String sex) {
        this.id = id;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "U{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }
}
