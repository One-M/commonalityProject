package com.ybf.lottery.di.component;

import com.ybf.lottery.di.manager.DataManager;
import com.ybf.lottery.di.module.ApiMoudle;
import com.ybf.lottery.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by XQyi on 2018/3/8.
 * Use:dagger初始化DataManager入口 ，指定 DataModule提供依赖
 */
@Component(modules = {ApiMoudle.class , RetrofitModule.class})
@Singleton
public interface DataComponent {
    void inject(DataManager dataManager);
}
