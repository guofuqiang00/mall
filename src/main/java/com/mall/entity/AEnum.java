package com.mall.entity;

public enum  AEnum {

    success("success","200"),
    error("error","202"),
    ;


    private String msg;
    private String code;


    AEnum( String msg, String code) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
