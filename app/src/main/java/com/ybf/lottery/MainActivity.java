package com.ybf.lottery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ybf.lottery.base.BaseActivity;
import com.ybf.lottery.eventBusInfo.HistoryKJEvent;
import com.ybf.lottery.function.basictrend.BJRacecarBasicTrendFragment;
import com.ybf.lottery.function.datastatistics.BJRacecarDataStatisticsFragment;
import com.ybf.lottery.function.dragontigertrend.BJRacecarDragonTigerTrendFragment;
import com.ybf.lottery.function.homefunction.HomeFragment;
import com.ybf.lottery.function.historykj.BJRacecarHistoryKJFragment;
import com.ybf.lottery.function.winnerrunnersumvalue.BJRacecarWinnerRunnerSumValueFragment;
import com.ybf.lottery.utils.FragmentUtils;
import com.ybf.lottery.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * app 主入口
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.mRadioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.bottom_bar_sy)
    RadioButton sy;
    @BindView(R.id.bottom_bar_lskj)
    RadioButton lskj;
    @BindView(R.id.bottom_bar_sjtj)
    RadioButton sjtj;
    @BindView(R.id.bottom_bar_jbzs)
    RadioButton jbzs;

    // 退出程序...时间
    private long mExitApp;
    private List<Fragment> fragments = new ArrayList<>();
    private final int HOME_FRAGMENT = 0;     //首页
    private final int LSKJ_FRAGMENT = 1;    //历史开奖
    private final int SJTJ_FRAGMENT = 2; //数据统计
    private final int JBZS_FRAGMENT = 3;     //基本走势
    // 默认显示底部导航栏下标
    private int showFragmentIndex = HOME_FRAGMENT;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private HomeFragment homeFragment;
    private BJRacecarHistoryKJFragment bjRacecarHistoryKJFragment;
    private BJRacecarDragonTigerTrendFragment dragonTigerTrendFragment;
    private BJRacecarWinnerRunnerSumValueFragment bjRacecarWinnerRunnerSumValueFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
        initEvent();
    }

    /**初始化fragment模块*/
    private void initFragment(){
        homeFragment = new HomeFragment();
        bjRacecarHistoryKJFragment = BJRacecarHistoryKJFragment.newInstance(0);
        dragonTigerTrendFragment = BJRacecarDragonTigerTrendFragment.newInstance(0);
        bjRacecarWinnerRunnerSumValueFragment = BJRacecarWinnerRunnerSumValueFragment.newInstance(0);

        fragments.add(homeFragment);
        fragments.add(bjRacecarHistoryKJFragment);
        fragments.add(dragonTigerTrendFragment);
        fragments.add(bjRacecarWinnerRunnerSumValueFragment);

        sy.setChecked(showFragmentIndex == HOME_FRAGMENT);
        lskj.setChecked(showFragmentIndex == LSKJ_FRAGMENT);
        sjtj.setChecked(showFragmentIndex == SJTJ_FRAGMENT);
        jbzs.setChecked(showFragmentIndex == JBZS_FRAGMENT);
        fragmentManager = getSupportFragmentManager();
        switchFragment(showFragmentIndex);
        setChooseTextColor(showFragmentIndex);
    }
    private void initEvent(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.bottom_bar_sy:
                        switchFragment(HOME_FRAGMENT);
                        break;
                    case R.id.bottom_bar_lskj:
                        switchFragment(LSKJ_FRAGMENT);
                        break;
                    case R.id.bottom_bar_sjtj:
                        switchFragment(SJTJ_FRAGMENT);
                        break;
                    case R.id.bottom_bar_jbzs:
                        switchFragment(JBZS_FRAGMENT);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    //Fragment切换
    private void switchFragment(int position){
        setChooseTextColor(position);
        currentFragment = FragmentUtils.switchFragment(fragmentManager , R.id.fragment , currentFragment , fragments.get(position).getClass() , null ,
                false , fragments.get(position).getClass().getSimpleName() + position , false);
    }
    private void setChooseTextColor(int index){
        switch (index){
            case HOME_FRAGMENT:
                sy.setTextColor(getResources().getColor(R.color.colorPrimary));//history_kj_tab_color
                lskj.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                sjtj.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                jbzs.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                break;
            case LSKJ_FRAGMENT:
                sy.setTextColor(getResources().getColor(R.color.history_kj_tab_color));//history_kj_tab_color
                lskj.setTextColor(getResources().getColor(R.color.colorPrimary));
                sjtj.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                jbzs.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                EventBus.getDefault().post(new HistoryKJEvent("-1"));
                break;
            case SJTJ_FRAGMENT:
                sy.setTextColor(getResources().getColor(R.color.history_kj_tab_color));//history_kj_tab_color
                lskj.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                sjtj.setTextColor(getResources().getColor(R.color.colorPrimary));
                jbzs.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                break;
            case JBZS_FRAGMENT:
                sy.setTextColor(getResources().getColor(R.color.history_kj_tab_color));//history_kj_tab_color
                lskj.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                sjtj.setTextColor(getResources().getColor(R.color.history_kj_tab_color));
                jbzs.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitApp) > 2000) {
                Toast.makeText(this, "再按一次退出APP", Toast.LENGTH_SHORT).show();
                mExitApp = System.currentTimeMillis();
            } else {
                System.exit(0);// 退出APP
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
