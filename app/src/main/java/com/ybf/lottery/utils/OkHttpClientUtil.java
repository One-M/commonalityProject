package com.ybf.lottery.utils;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Poison_Y on 2017/8/28.
 * description: 带data拦截器的okhttp
 */

public class OkHttpClientUtil {
    public static HttpLoggingInterceptor getLogInterceptor(){
        //日志显示级别
        HttpLoggingInterceptor.Level bodyLevel = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("project_tag","OkHttp====Message:"+message);
            }
        });
        httpLoggingInterceptor.setLevel(bodyLevel);
        return httpLoggingInterceptor;
    }

}
