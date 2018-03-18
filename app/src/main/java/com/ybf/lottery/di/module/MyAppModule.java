package com.ybf.lottery.di.module;

import com.ybf.lottery.di.manager.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by XQyi on 2018/3/8.
 * Use: 为Component[MyAppComponent] 提供依赖 定义 DataManager为提供对象
 */
@Module
public class MyAppModule {

    private final String baseUrl;

    public MyAppModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(){
        return new DataManager(baseUrl);
    }
}
