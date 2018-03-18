package com.ybf.lottery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseActivity;
import com.ybf.lottery.fragment.RaceCaeFragment;

/**
 * Created by XQyi on 2018/3/9.
 * Use:
 */

public class RaceCarFragActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fragment_data);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        RaceCaeFragment issueRecommendFragment = RaceCaeFragment.newInstance();
        fragmentTransaction.add(R.id.data_fragment, issueRecommendFragment);
        fragmentTransaction.commit();
    }
}
