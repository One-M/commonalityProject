package com.ybf.lottery.adapter.bjscbasictrendadapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ybf.lottery.R;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendStatisticBean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/3.
 * Use:基本走势数据统计的adapter
 */

public class BasicTrendAdapter extends BaseQuickAdapter<BasicTrendStatisticBean , BaseViewHolder> {

    private Context mContext;
    public BasicTrendAdapter(@Nullable List<BasicTrendStatisticBean> data , Context context) {
        super(R.layout.bjsc_basic_trend_statistic_item , data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, BasicTrendStatisticBean data) {
        holder.setText(R.id.basic_trend_cxcs , data.getData1() == -1 ? "" : data.getData1() +"");
        holder.setText(R.id.basic_trend_zdlc , data.getData2() == -1 ? "" : data.getData2()+"");
        holder.setText(R.id.basic_trend_zdyl , data.getData3() == -1 ? "" : data.getData3()+"");
        holder.setText(R.id.basic_trend_pjyl , data.getData4() == -1 ? "" : data.getData4()+"");
        holder.setText(R.id.basic_trend_dqyl , data.getData5() == -1 ? "" : data.getData5()+"");
    }
}
