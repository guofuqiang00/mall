package com.mall.java.en;

public enum  EnumTest {

    success_sds("200","success") ;


    private String code;
    private String msg;

    EnumTest(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
