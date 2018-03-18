package com.ybf.lottery.di.manager;

import com.ybf.lottery.di.component.DaggerDataComponent;
import com.ybf.lottery.di.module.ApiMoudle;
import com.ybf.lottery.di.module.RetrofitModule;
import com.ybf.lottery.model.http.repository.ManageRepository;

import javax.inject.Inject;

/**
 * Created by XQyi on 2018/3/8.
 * Use: 初始化DataModule ，在DataModule中已经被注入，dataManager里面可以直接使用【@Inject】对象
 */

public class DataManager {

    @Inject
    public ManageRepository manageRepository;

    public DataManager(String baseurl){

        DaggerDataComponent.builder()
                .apiMoudle(new ApiMoudle())
                .retrofitModule(new RetrofitModule(baseurl))
                .build()
                .inject(this);
    }
}
