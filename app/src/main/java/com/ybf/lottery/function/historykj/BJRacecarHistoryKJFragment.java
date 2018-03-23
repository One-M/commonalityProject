package com.ybf.lottery.function.historykj;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.BJRacecarHistoryKJAdapter;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.trend.CustomHistoryKJView;
import com.ybf.lottery.diyview.trend.HeaderHorizontalScrollView;
import com.ybf.lottery.diyview.trend.LeftNumberCustomListView;
import com.ybf.lottery.diyview.trend.LeftNumberSynchScrollView;
import com.ybf.lottery.diyview.trend.ScrollChangeCallback;
import com.ybf.lottery.diyview.trend.TrendScrollViewWidget;
import com.ybf.lottery.eventBusInfo.HistoryKJEvent;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;
import com.ybf.lottery.utils.CustomDate;
import com.ybf.lottery.utils.DateUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/10.
 * Use:历史开奖页
 */

public class BJRacecarHistoryKJFragment extends BaseMvpFragment<BJRacecarHistoryKJContract.Presenter> implements BJRacecarHistoryKJContract.IView, ScrollChangeCallback {

    //容器区域
    @BindView(R.id.scroll_left)
    LeftNumberSynchScrollView mLeftScroll;
    @BindView(R.id.scroll_content)
    TrendScrollViewWidget mContentScroll;
    @BindView(R.id.trend_header_scroll)
    HeaderHorizontalScrollView mHeadScroll;
    //数据区域
    @BindView(R.id.lv_number)
    LeftNumberCustomListView mListView;
    //内容区域
//    @BindView(R.id.recycleview)
//    RecyclerView recyclerView;
    @BindView(R.id.custom_history_kj_view)
    CustomHistoryKJView historyKJView;
    //加载中提示
    @BindView(R.id.data_login_ll)
    LinearLayout dataLoginll;
    @BindView(R.id.load_text)
    TextView loadText;
    //数据显示
    @BindView(R.id.data_details_ll)
    LinearLayout dataDetailsll;

    private View mView;
    private DataAdapter dataAdapter;
    private BJRacecarHistoryKJAdapter historyKJAdapter;
    private List<BJRacecarHistoryKJBean> historyData = new ArrayList<>();
    private List<BJRacecarHistoryKJBean> showData = new ArrayList<>();//显示的数据
    private Timer timer;

    @Override
    public BJRacecarHistoryKJContract.Presenter initPresenter() {
        return new BJRacecarHistoryKJPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.kaijiang_history, container, false);

        ButterKnife.bind(this , mView);
        EventBus.getDefault().register(this);

        initView();
        CustomDate cuDate = new CustomDate();
        String cyString = DateUtil.getDateFormattingString(cuDate.getYear() , cuDate.getMonth() , cuDate.getDay());
        initDatas(cyString);

       return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView(){

//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(manager);

        mLeftScroll.setScrollViewListener(this);
        //中间走势图的监听器
        mContentScroll.setScrollViewListener(this);
        //走势图顶部的监听器
        mHeadScroll.setScrollViewListener(this);
        //走势图底部的旋球滚动监听器
//        mFooterScroll.setScrollViewListener(this);

    }

    private final int STATUS_LOADING = 0;//加载中
    private final int STATUS_LOAD_SUCCESS = 1;//加载成功
    private final int STATUS_LOAD_FAILED = 2;//加载失败
    private final int STATUS_SEREVER_ERROR = 3;//加载失败

    private void setStatus(int status){
        switch (status){
            case STATUS_LOADING:
                dataLoginll.setVisibility(View.VISIBLE);
                dataDetailsll.setVisibility(View.GONE);
                loadText.setText("加载中...");
                break;
            case STATUS_LOAD_SUCCESS:
                dataLoginll.setVisibility(View.GONE);
                dataDetailsll.setVisibility(View.VISIBLE);
                break;
            case STATUS_LOAD_FAILED:
                dataLoginll.setVisibility(View.VISIBLE);
                dataDetailsll.setVisibility(View.GONE);
                loadText.setText("加载失败");
                break;
            case STATUS_SEREVER_ERROR:
                dataLoginll.setVisibility(View.VISIBLE);
                dataDetailsll.setVisibility(View.GONE);
                loadText.setText("暂无数据");
                break;
        }
    }

    private void initDatas(String dateStr){
        setStatus(STATUS_LOADING);
        mPresenter.loadData(dateStr);
    }
    @Override
    public void loadSuccess(List<BJRacecarHistoryKJBean> historyKJBeanList) {

        /**显示的数据，在请求数据后先clear 再赋值新数据*/
        showData.clear();
        showData = historyKJBeanList;

        /**期号数据设置*/
        bindQiHaoData(getIssueNum(showData));
        bindNeiRongData(showData);

    }

//    Handler handler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message message) {
//            switch (message.what){
//                case 1:
//                    historyKJAdapter.notifyItemChanged(historyData.size());//更新单条
//                    break;
//            }
//            return false;
//        }
//    });

    @Override
    public void loadFailed() {
        Log.d("retrofit==> " , "failed");
        setStatus(STATUS_LOAD_FAILED);
    }

    @Override
    public void sereverError() {
        setStatus(STATUS_SEREVER_ERROR);
    }

    /**
     * 测试期号的数据绑定显示
     */
    private void bindQiHaoData(List<String> numList) {
        if (dataAdapter == null) {
            dataAdapter = new DataAdapter(R.layout.items);
            dataAdapter.bindData(numList);
            mListView.setAdapter(dataAdapter);
        }else{
            dataAdapter.bindData(numList);
            dataAdapter.notifyDataSetChanged();
            //复位
            mLeftScroll.scrollTo(0, 0);
            mHeadScroll.scrollTo(0,0);
        }
    }

//    private void newThread(boolean newData){
//        new Thread(){
//            @Override
//            public void run() {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if(newData){
//                            recyclerView.setAdapter(historyKJAdapter);
//                        }else{
//                            historyKJAdapter.notifyDataSetChanged();
//                        }
//                    }
//                });
//            }
//        }.start();
//    }

    /**
     * 添加内容数据
     */
//    private final int firstDataSize = 15;//分段加载初始15
//    private int currSize = 15;
    private void bindNeiRongData(final List<BJRacecarHistoryKJBean> dataBean){

//        if(historyKJAdapter == null){
//            historyKJAdapter = new BJRacecarHistoryKJAdapter(dataBean , getContext());
//            recyclerView.setAdapter(historyKJAdapter);
//        }else{
//            historyKJAdapter.setNewData(dataBean);
//            historyKJAdapter.notifyDataSetChanged();
//        }
        historyKJView.setShowDatas(dataBean);
        setStatus(STATUS_LOAD_SUCCESS);
//        historyData.clear();//切换日期得到新数据前clear
//        currSize = 15;
//        for (int i = 0; i < (dataBean.size() > firstDataSize ? firstDataSize : dataBean.size()); i++) {
//            historyData.add(dataBean.get(i));
//        }
//        if(historyKJAdapter == null){
//            historyKJAdapter = new BJRacecarHistoryKJAdapter(historyData , getContext());
//            recyclerView.setAdapter(historyKJAdapter);
//        }else{
//            historyKJAdapter.setNewData(historyData);
//            historyKJAdapter.notifyDataSetChanged();
//        }
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (currSize < dataBean.size()) {
//                    historyData.add(dataBean.get(currSize));
//                    currSize++;
//                    handler.sendEmptyMessage(1);
//                }else{
//                    timer.purge();
//                }
//            }
//        },100 , 100);
    }

    /***
     * 同步X轴位置
     * @param left
     */
    @Override
    public void changeXScroll(int left) {
        //顶部和底部容器滑动的回调;
        //此时需要同步中间走势的View的位置;
        mContentScroll.scrollTo(left, mContentScroll.getScrollY());
        //同步顶部自身的位置;
        mHeadScroll.scrollTo(left,0);
    }
    /***
     * 同步Y轴的位置
     * @param top
     */
    @Override
    public void changeYScoll(int top) {
        //中间走势View滑动位置的改变回调;
        //同步左边期号的Y轴的位置
        mLeftScroll.scrollTo(0, top);
        //同步中间走势View的位置
        mContentScroll.scrollTo(mContentScroll.getScrollX(), top);
        //有走势图头部...
        mHeadScroll.scrollTo(mContentScroll.getScrollX(),0);
    }

    /**
     * 获得开奖期号的list
     * @param datas
     */
    private List<String> getIssueNum(List<BJRacecarHistoryKJBean> datas){
        List<String> qihaoList = new ArrayList<>();

        for (BJRacecarHistoryKJBean d : datas) {
            qihaoList.add(d.getIssue());
        }
        return qihaoList;
    }
    /***
     * 期号
     */
    private class DataAdapter extends BaseAdapter {
        private  List listData=null;
        private int layoutId;
        public DataAdapter(int layoutID){
            this.layoutId=layoutID;
        }
        protected  void bindData(List data){
            this.listData=data;
        }

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
            }
            final TextView tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            tv_content.setText(listData.get(position).toString());
            if (position%2 == 0){
                tv_content.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_color));
            }else{
                tv_content.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_b_color));
            }
            return convertView;
        }
    }

    @Subscribe() // threadMode 设置 onEven的执行线程
    public void onEven(HistoryKJEvent event){
        if (event.getEventDate() != null) {
            boolean trd = isMainThread();
            Log.d("onEven" , event.getEventDate() + trd);
            /*timer.cancel();//日期切换后的更新数据前先清理*/
            initDatas(event.getEventDate());
        }
    }

    /**
     * 判断当前线程是否是主线程
     * @return true 主
     */
    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
