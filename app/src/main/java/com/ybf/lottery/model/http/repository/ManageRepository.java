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

    /**
     * /**
     * 北京赛车历史开奖倒计时接口
     * @param lottery
     * @return
     */
    public Flowable<BJRacecarCountDownBean> bjRacecarCountDownLoginData(String lottery){
        return manageApi.bjRacecarCountDownLoginData(lottery);
    }

    /**
     * 北京赛车历史开奖数据
     * @param drawDate 日期
     * ps: ResponseBody——retrofit中 返回未解析的原始json数据，这里处理不规范接口数据时单独解析
     * @return
     */
    public Flowable<ResponseBody> bjRacecarHistoryResponseBodyLoginData(String drawDate){
        return manageApi.bjRacecarHistoryResponseBodyLoginData(drawDate);
    }

}
