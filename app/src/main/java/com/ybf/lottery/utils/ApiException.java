package com.ybf.lottery.utils;

/**
 * Created by XQyi on 2018/3/3.
 * Use:接口异常判断处理
 */

public class ApiException extends Exception{
    private int code;

    @SuppressWarnings("unused")
    public ApiException(int code) {
        this.code = code;
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public ApiException setCode(int code) {
        this.code = code;
        return this;
    }
}
