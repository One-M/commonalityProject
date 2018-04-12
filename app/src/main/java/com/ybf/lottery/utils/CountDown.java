package com.ybf.lottery.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by XQyi on 2018/4/11.
 * Use:
 */

public class CountDown extends CountDownTimer {

    private TextView showText;
    public CountDown(long millisInFuture, long countDownInterval , TextView showText) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long l) {
//        String timeStr = formatLongToTimeStr(l);
//        showText.setText("第" + issue + "期开奖倒计时:" + timeStr + " 每日售179期,今日剩余" + surplusIssue + "期");
//        showText.init(getActivity().getWindowManager());
    }

    @Override
    public void onFinish() {
//        mMarquee.setText("开奖啦！");
//        mMarquee.init(getActivity().getWindowManager());
//        this.cancel();
//        initTimeData();
    }
}
