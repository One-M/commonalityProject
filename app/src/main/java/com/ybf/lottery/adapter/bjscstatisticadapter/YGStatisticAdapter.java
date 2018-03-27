package com.ybf.lottery.adapter.bjscstatisticadapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ybf.lottery.R;
import com.ybf.lottery.model.bean.bjscstatisticbean.StatisticalBean;

import java.util.List;

/**
 * Created by XQyi on 2018/3/25.
 * Use:北京赛车数据统计adapter
 */

public class YGStatisticAdapter extends BaseQuickAdapter<StatisticalBean , BaseViewHolder> {

    private Context mContext;

    public YGStatisticAdapter(@Nullable List<StatisticalBean> data , Context context) {
        super(R.layout.bjsc_data_statistic_item_lay , data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, StatisticalBean item) {

        holder.setText(R.id.yg_total_points , item.getStatisticalItem());
        holder.setText(R.id.yg_total_points_num , item.getOccurrenceNum());
        holder.setText(R.id.yg_total_points_prob , item.getOccurrenceProbability());
        holder.setText(R.id.yg_theory_probability , item.getTheoryProbability());

    }
}
