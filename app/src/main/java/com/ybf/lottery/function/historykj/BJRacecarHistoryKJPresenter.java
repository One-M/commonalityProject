package com.ybf.lottery.function.historykj;

import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;

/**
 * Created by XQyi on 2018/3/15.
 * Use:北京赛车历史开奖的Presenter
 */

public class BJRacecarHistoryKJPresenter extends BaseMvpPresenter<BJRacecarHistoryKJContract.IView> implements BJRacecarHistoryKJContract.Presenter{

    ManageRepository manageRepository;

    public BJRacecarHistoryKJPresenter(BJRacecarHistoryKJContract.IView view) {
        super(view);
        this.manageRepository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String drawDate) {
       Flowable<ResponseBody> flowable = manageRepository.bjRacecarHistoryResponseBodyLoginData(drawDate);
       addSubscribe(flowable, new MySubscriber<ResponseBody>() {
           @Override
           public void onNext(ResponseBody responseBody) {
               /**
                * ResponseBody 接口返回不规范数据时这里需要得到 原始json数据 手动解析
                */
               try {
                   //原始json数据
                   String jsonString = responseBody.string();

                   if (jsonString == null || jsonString.equals("") || jsonString.equals("[]")){
                        baseView.sereverError();
                   }else {
                       //json 解析,  TypeToken直接解析 list对象
                       Type type = new TypeToken<List<BJRacecarHistoryKJBean>>() {}.getType();
                       List<BJRacecarHistoryKJBean> listData = new Gson().fromJson(jsonString, type);

                       baseView.loadSuccess(listData);
                       Log.d("retrofit_json: ", jsonString);
                       Log.d("isMainThread: ", isMainThread() + "");
                   }

               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           @Override
           public void onError(Throwable t) {
               super.onError(t);
               baseView.loadFailed();
           }
       });
    }

    @Override
    public void loadTimeData() {
        Flowable<BJRacecarCountDownBean> flowable = manageRepository.bjRacecarCountDownLoginData("PK10");
        addSubscribe(flowable, new MySubscriber<BJRacecarCountDownBean>() {
            @Override
            public void onNext(BJRacecarCountDownBean countDownBean) {
                if (countDownBean.getCode() == 200) {
                    baseView.loadTimeSuccess(countDownBean);
                }else{
                    baseView.loadTimeFailed(countDownBean);
                }
            }
        });
    }

    private boolean isMainThread(){//是否主线程
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
