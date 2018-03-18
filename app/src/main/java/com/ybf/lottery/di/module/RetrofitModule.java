package com.ybf.lottery.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ybf.lottery.di.interceptor.DataInterceptor;
import com.ybf.lottery.di.interceptor.SignInterceptor;
import com.ybf.lottery.utils.OkHttpClientUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Module是告诉Component，可以从这里获取依赖对象。Component就会去找被@Provide标注的方法，相当于构造器的@Inject，可以提供依赖。
 *  @Provides 在Module中使用，告诉Dagger我们想要构造对象并提供这些依赖
 *  @Singleton 当前提供的对象将是单例模式 ,一般配合@Provides一起出现
 */

/**
 * Created by XQyi on 2018/3/10.
 * Use: retrofit + okhttp 相关的Moudle ps:okhttp拦截器等也在这里添加处理
 */
@Module
public class RetrofitModule {

    private final String baseUrl;
    private static final int DEFAULT_TIMEOUT = 5;

    public RetrofitModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(DataInterceptor dataInterceptor, SignInterceptor signInterceptor) { //拦截器添加公共参数暂时不加
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder()
//                .addInterceptor(dataInterceptor)
//                .addInterceptor(signInterceptor)
                .addInterceptor(OkHttpClientUtil.getLogInterceptor())
                ;

        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return httpClientBuilder.build();
    }
    @Provides
    @Singleton
    DataInterceptor providesDataInterceptor() {
        DataInterceptor dataInterceptor = new DataInterceptor();
        return dataInterceptor;
    }


    @Provides
    @Singleton
    SignInterceptor providesSignInterceptor() {
        SignInterceptor signInterceptor = new SignInterceptor();
        return signInterceptor;
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
}
