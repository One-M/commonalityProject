package com.ybf.lottery.di.module;

import com.ybf.lottery.model.http.api.ManageApi;
import com.ybf.lottery.model.http.repository.ManageRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by XQyi on 2018/3/10.
 * Use: api + repository 的moudle
 */
@Module
public class ApiMoudle {

    public ApiMoudle(){}

    @Provides
    @Singleton
    ManageApi providesManageApi(Retrofit retrofit){
        return retrofit.create(ManageApi.class);
    }

    @Provides
    @Singleton
    ManageRepository providesManageRepository(ManageApi manageApi){
        return new ManageRepository(manageApi);
    }
}
