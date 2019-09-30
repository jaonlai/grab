package com.example.springboot.utils;

public class ResponseDto<T> {
    //错误码
    private String code;
    //提示信息
    private String msg;
    //具体的内容
    private T data;
    public ResponseDto() {
    }
    public ResponseDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    //getter和setter方法。。。

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}