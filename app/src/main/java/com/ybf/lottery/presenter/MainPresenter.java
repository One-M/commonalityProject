package com.ybf.lottery.presenter;

import android.util.Log;
import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.contract.MainContract;
import com.ybf.lottery.model.bean.HttpNoResult;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/3/3.
 * Use:具体presenter实现
 */

public class MainPresenter extends BaseMvpPresenter<MainContract.IView> implements MainContract.Presenter{

    ManageRepository manageRepository;

    public MainPresenter(MainContract.IView v){
        super(v);
        this.manageRepository = dataManager.manageRepository;
    }

    @Override
    public void loadData() {
        baseView.showTipMsg("数据加载");
        Flowable<HttpNoResult> flowable = manageRepository.loginData("HHLY00000196" , "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MjAzMDI3OTIsInN1YiI6IntcImlkXCI6XCJISExZMDAwMDAxOTZcIixcInBob25lTnVtXCI6XCIxNTg4MDAxODM4NVwiLFwiaW1hZ2VTcmNcIjpcImh0dHA6Ly9wdWJsaWMuMTMzMjIuY29tLzdiYzAyNDdcIixcIm5pY2tOYW1lXCI6XCJISExZMDAwMDAxOTZcIn0ifQ.ZOWN_WTXWMR3Mr0M606Gh7aKajYXMFoOeUFmIH2QZNQ",
                "zh" , "8","141" , "42" , "BETA" , "180c1d638432840c5a411b2a3b91eb1c3a");
        addSubscribe(flowable, new MySubscriber<HttpNoResult>() {
            @Override
            public void onNext(HttpNoResult httpNoResult) {
                Log.d("code= ",httpNoResult.getCode()+"");
            }

        });
    }
}
