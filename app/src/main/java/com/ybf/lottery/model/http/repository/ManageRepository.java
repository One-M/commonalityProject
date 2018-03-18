package com.ybf.lottery.model.http.repository;

import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;
import com.ybf.lottery.model.bean.HttpNoResult;
import com.ybf.lottery.model.http.api.ManageApi;

import java.security.PublicKey;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;

/**
 * Created by XQyi on 2018/3/8.
 * Use: 共用Repository类
 */

public class ManageRepository {

    private ManageApi manageApi;
    public ManageRepository(ManageApi api){
        this.manageApi = api;
    }

    public Flowable<HttpNoResult> loginData(String userId, String loginToken, String lang, String timeZone,
                                            String version, String versionCode, String channelNumber, String sign){

        return manageApi.loginData(userId, loginToken, lang, timeZone, version, versionCode, channelNumber, sign);
    }

    public Flowable<BJRacecarCountDownBean> bjRacecarCountDownLoginData(String lottery){
        return manageApi.bjRacecarCountDownLoginData(lottery);
    }

    public Flowable<ResponseBody> bjRacecarHistoryResponseBodyLoginData(String drawDate){
        return manageApi.bjRacecarHistoryResponseBodyLoginData(drawDate);
    }

}
