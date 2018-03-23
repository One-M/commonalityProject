package com.ybf.lottery.function.datastatistics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.trend.ScrollChangeCallback;
import com.ybf.lottery.function.historykj.BJRacecarHistoryKJContract;
import com.ybf.lottery.function.historykj.BJRacecarHistoryKJPresenter;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/22.
 * Use:北京赛车数据统计
 */

public class BJRacecarDataStatisticsFragment extends BaseMvpFragment<BJRacecarHistoryKJContract.Presenter> implements BJRacecarHistoryKJContract.IView, ScrollChangeCallback {

    @Override
    public BJRacecarHistoryKJContract.Presenter initPresenter() {
        return new BJRacecarHistoryKJPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.other_fragment, container, false);

        ButterKnife.bind(this , mView);

        return mView;
    }


    @Override
    public void changeXScroll(int left) {

    }

    @Override
    public void changeYScoll(int top) {

    }

    @Override
    public void loadSuccess(List<BJRacecarHistoryKJBean> historyKJBeanList) {

    }

    @Override
    public void loadFailed() {

    }

    @Override
    public void sereverError() {

    }
}
