package com.ybf.lottery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseActivity;
import com.ybf.lottery.function.locationtrend.BJRacecarLocationTrendFragment;
import com.ybf.lottery.function.winnerrunnersumvalue.BJRacecarWinnerRunnerSumValueFragment;

/**
 * Created by XQyi on 2018/4/13.
 * Use:定位走势首页入口Activity
 */

public class LocationTrendActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment_data);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        BJRacecarLocationTrendFragment locationTrendFragment = BJRacecarLocationTrendFragment.newInstance(1); // 传参标记入口type 导航栏入口传0 其它传l
        fragmentTransaction.add(R.id.data_fragment, locationTrendFragment);
        fragmentTransaction.commit();
    }
}
