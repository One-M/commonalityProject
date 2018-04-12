package com.ybf.lottery.function.homefunction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.bjschomeadapter.HotLotterAdapter;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.ColorTextView;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.homebean.HotLotteryBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/23.
 * Use:首页fragment
 */

public class HomeFragment extends BaseMvpFragment<HomeContract.Presenter> implements HomeContract.IView {

    @BindView(R.id.home_kj_issue)
    TextView kjIssue;
    @BindView(R.id.home_kj_time)
    TextView kjTime;
    @BindView(R.id.kj_issue)
    TextView kjIssueTxt;
    @BindView(R.id.home_hot_lottery_gridlay)
    GridView hotLotterGrid;
    @BindViews({R.id.home_kj_num1 ,
                R.id.home_kj_num2,
                R.id.home_kj_num3,
                R.id.home_kj_num4,
                R.id.home_kj_num5,
                R.id.home_kj_num6,
                R.id.home_kj_num7,
                R.id.home_kj_num8,
                R.id.home_kj_num9,
                R.id.home_kj_num10
                })
    List<ColorTextView> kjNumList;

    @BindViews({R.id.home_kj_sx1,
                R.id.home_kj_sx2,
                R.id.home_kj_sx3,
                R.id.home_kj_sx4,
                R.id.home_kj_sx5,
                R.id.home_kj_sx6,
                R.id.home_kj_sx7,
                R.id.home_kj_sx8,
                })
    List<TextView> kjSXList;

    private String issue;
    private MyCountDown countDown;
    private Context mContext;

    @Override
    public HomeContract.Presenter initPresenter() {
        return new HomePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.home_fragment, container, false);

        ButterKnife.bind(this , mView);

        initTimeData();
        initHotLotteryData();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initTimeData(){
        mPresenter.loadTimeData();
    }

    private void initHotLotteryData(){
        List<HotLotteryBean> hotLotteryList = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            HotLotteryBean hotLotteryBean = new HotLotteryBean();
            hotLotteryBean.setTypeName("历史开奖 "+i);
            hotLotteryList.add(hotLotteryBean);
        }

        HotLotterAdapter hotLotterAdapter = new HotLotterAdapter(mContext, hotLotteryList);
        hotLotterGrid.setAdapter(hotLotterAdapter);
    }

    @Override
    public void loadTimeSuccess(BJRacecarCountDownBean countDownBean) {
        setTimeData(countDownBean);
    }

    @Override
    public void loadTimeFailed(BJRacecarCountDownBean failedData) {

    }
    @SuppressLint("SetTextI18n")
    private void setTimeData(BJRacecarCountDownBean countDownBean){

        long endTime = countDownBean.getInfo().getSaleEndTime();
        long serverTime = countDownBean.getInfo().getServerTime();
        long time = endTime - serverTime;

        String timeStr = formatLongToTimeStr(time);
        issue = countDownBean.getInfo().getIssue();
        countDown = new MyCountDown(time , 1000);
        countDown.start();
        kjIssue.setText("距离" + issue + "期开奖还有");
        kjTime.setText(timeStr);

        kjIssueTxt.setText("第" + issue + "期开奖");
        String predrawcode = countDownBean.getInfo().getPredrawcode();
        String[] issueStr = predrawcode.split(",");
        for (int i = 0; i < issueStr.length; i++) {
            kjNumList.get(i).setCtvText(issueStr[i]);
            setKJNumColor(kjNumList.get(i) , issueStr[i]);
        }


        Log.d("qwer==> " , countDownBean.getCode() + " success" + time);
    }

    class MyCountDown extends CountDownTimer {

        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            String timeStr = formatLongToTimeStr(l);
            kjIssue.setText("距离" + issue + "期开奖还有");
            kjTime.setText(timeStr);
        }

        @Override
        public void onFinish() {
            kjIssue.setText("开奖啦！");
            countDown.cancel();
            initTimeData();
        }
    }
    /**
     * long ==> 分秒显示,
     * @param l
     * @return
     */
    private String formatLongToTimeStr(long l){
        int minute = 0;//分
        int second = 0;//秒
        second = (int) (l/1000);
        if (second >= 60) {
            minute = second/60;//取整
            second = second%60;//取余
        }

        String m = "";
        String s = "";
        m = minute < 10 ? "0" + minute : "" + minute;
        s = second < 10 ? "0" + second : "" + second;

//        String strTime = m + "分" + s + "秒";
        String strTime = m + ":" + s;
        return strTime;
    }

    /**设置开奖号码背景色*/
    private void setKJNumColor(ColorTextView textView , String num){
        switch (num){
            case "01":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_1));
                break;
            case "02":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_2));
                break;
            case "03":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_3));
                break;
            case "04":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_4));
                break;
            case "05":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_5));
                break;
            case "06":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_6));
                break;
            case "07":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_7));
                break;
            case "08":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_8));
                break;
            case "09":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_9));
                break;
            case "10":
                textView.setCtvBackgroundColor(getResources().getColor(R.color.num_10));
                break;
        }
    }
}
