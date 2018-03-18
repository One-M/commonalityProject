package com.ybf.lottery.di.component;

import com.ybf.lottery.MyApplication;
import com.ybf.lottery.di.module.MyAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by XQyi on 2018/3/8.
 * Use: dagger初始化入口 inject Application时指向Module(MyAppModule)
 */
@Component(modules = {MyAppModule.class})
@Singleton
public interface MyAppComponent {
    void inject(MyApplication application);
}
