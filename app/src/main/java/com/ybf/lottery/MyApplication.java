package com.ybf.lottery;

import android.app.Application;

import com.ybf.lottery.di.component.DaggerMyAppComponent;
import com.ybf.lottery.di.manager.DataManager;
import com.ybf.lottery.di.module.MyAppModule;
import com.ybf.lottery.utils.UrlManage;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

/**
 * Created by XQyi on 2018/3/2.
 * Use: Application 初始化app只用初始化一次的内容(dagger注入)
 */

public class MyApplication extends Application {

    private static MyApplication myApp;
    @Inject
    DataManager dataManager;

    public static MyApplication getMyApp(){
        return myApp;
    }
    public void setMyApp(MyApplication myApplication){
        MyApplication.myApp = myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setMyApp(this);
        initDagger();
        initLeakCanary();
    }

    /**
     * 初始化内存检测工具
     */
    private void initLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    /**
     * 初始化Dagger注入
     */
    public void initDagger() {
        DaggerMyAppComponent.builder()
                .myAppModule(new MyAppModule(UrlManage.url))
                .build()
                .inject(this);
    }

    /**
     * 获取 DataManager
     * @return DataManager
     */
    public static DataManager getDataMamager(){
        return getMyApp().dataManager;
    }

}
