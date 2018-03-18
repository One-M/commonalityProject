package com.ybf.lottery.model.http.api;

import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;
import com.ybf.lottery.model.bean.HttpNoResult;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by XQyi on 2018/3/8.
 * Use: 网络请求接口管理集合(api)
 * --共用Api类--
 */

public interface ManageApi {

    @FormUrlEncoded
    @POST("user/card/info")
    Flowable<HttpNoResult> loginData(@Field("userId") String userId,
                                     @Field("loginToken") String loginToken,
                                     @Field("lang") String lang,
                                     @Field("timeZone") String timeZone,
                                     @Field("version") String version,
                                     @Field("versionCode") String versionCode,
                                     @Field("channelNumber") String channelNumber,
                                     @Field("sign") String sign
    );

    /**
     * 北京赛车历史开奖倒计时接口
     * @param lottery
     * @return
     */
    @GET("trend-api/lottery/findLotteryInfo")    //lottery=PK10
    Flowable<BJRacecarCountDownBean> bjRacecarCountDownLoginData(@Query("lottery") String lottery);

    /**
     * 北京赛车历史开奖数据
     * @param drawDate 日期
     * ps: ResponseBody——retrofit中 返回未解析的原始json数据，这里处理不规范接口数据时单独解析
     * @return
     */
    @GET("trend-api/pk10/findPk10History")
    Flowable<ResponseBody> bjRacecarHistoryResponseBodyLoginData(@Query("drawDate") String drawDate);

}
