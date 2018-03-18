package com.ybf.lottery.model.bean;

/**
 * Created by XQyi on 2018/3/3.
 * Use:没有解析数据的接口返回(只需要通过返回码[code]判断接口情况，无需拿具体数值的返回实体)
 */

public class HttpNoResult {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public HttpNoResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public HttpNoResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String toString(){
        return "HttpNoResult {" + "code:" + code + " ,msg:" + msg + '\'' + "}";
    }
}
