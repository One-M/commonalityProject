package com.ybf.lottery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseActivity;
import com.ybf.lottery.function.divideremainder.BJRacecarDivideRemainderFragment;

/**
 * Created by XQyi on 2018/4/21.
 * Use:除三余(012)走势的首页入口
 */

public class DivideRenainderActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment_data);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        BJRacecarDivideRemainderFragment divideRemainderFragment = BJRacecarDivideRemainderFragment.newInstance(1); // 传参标记入口type 导航栏入口传0 其它传l
        fragmentTransaction.add(R.id.data_fragment, divideRemainderFragment);
        fragmentTransaction.commit();
    }
}
