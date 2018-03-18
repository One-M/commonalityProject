package com.ybf.lottery.di.interceptor;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by XQyi on 2018/3/9.
 * Use:拦截器
 */

public class DataInterceptor implements Interceptor {

    public DataInterceptor(){}
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
