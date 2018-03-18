package com.ybf.lottery.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by XQyi on 2018/3/3.
 * Use:含有解析参数的数据返回
 */

public class HttpResult<T> {
    private int code;
    private String msg;
    @SerializedName(value = "result")
    private T data;

    public int getCode() {
        return code;
    }

    public HttpResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public HttpResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public HttpResult setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "HttpResult{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }

}
