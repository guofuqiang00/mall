package com.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class Response<T> {
    @ApiModelProperty(value = "返回对象")
    private T data;
    @ApiModelProperty(value = "响应的代码，200为正常返回")
    private int code = 200;
    @ApiModelProperty(value = "信息")
    private String msg = "OK";

    public Response() {
    }

    public Response(T data)  {
        this.data = data;

        if (data==null){
            this.msg=ErrorCode.没有相关数据.name();
            this.code=ErrorCode.没有相关数据.getCode();
        }

    }

    public T getData() {
        return data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        if (code != 1) {
            this.msg = ErrorCode.errorCode(code).name();
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
