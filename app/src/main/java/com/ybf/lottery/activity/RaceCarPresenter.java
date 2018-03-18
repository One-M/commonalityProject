package com.ybf.lottery.activity;

import android.util.Log;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.HttpNoResult;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/3/9.
 * Use:
 */

public class RaceCarPresenter extends BaseMvpPresenter<RaceCarContract.IView> implements RaceCarContract.Presenter {


    private ManageRepository repository;
    public RaceCarPresenter(RaceCarContract.IView view) {
        super(view);
        repository = dataManager.manageRepository;
    }


    @Override
    public void loadData() {
        baseView.showTipMsg("base");
        Flowable<HttpNoResult> flowable = repository.loginData("HHLY00000196" , "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjAzMDI3OTIsInN1YiI6IntcImlkXCI6XCJISExZMDAwMDAxOTZcIixcInBob25lTnVtXCI6XCIxNTg4MDAxODM4NVwiLFwiaW1hZ2VTcmNcIjpcImh0dHA6Ly9wdWJsaWMuMTMzMjIuY29tLzdiYzAyNDdcIixcIm5pY2tOYW1lXCI6XCJISExZMDAwMDAxOTZcIn0ifQ.ZOWN_WTXWMR3Mr0M606Gh7aKajYXMFoOeUFmIH2QZNQ",
                "zh" , "8","141" , "42" , "BETA" , "180c1d638432840c5a411b2a3b91eb1c3a");
        addSubscribe(flowable, new MySubscriber<HttpNoResult>() {
            @Override
            public void onNext(HttpNoResult httpNoResult) {
                Log.d("code= ",httpNoResult.getCode()+"");
            }

        });
    }
}
