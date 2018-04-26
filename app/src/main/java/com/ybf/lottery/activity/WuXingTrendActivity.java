package com.ybf.lottery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseActivity;
import com.ybf.lottery.function.wuxingtrend.BJRacecarWuXingTrendFragment;

/**
 * Created by XQyi on 2018/4/21.
 * Use:五行走势的首页入口
 */

public class WuXingTrendActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment_data);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        BJRacecarWuXingTrendFragment wuXingTrendFragment = BJRacecarWuXingTrendFragment.newInstance(1); // 传参标记入口type 导航栏入口传0 其它传l
        fragmentTransaction.add(R.id.data_fragment, wuXingTrendFragment);
        fragmentTransaction.commit();
    }
}
