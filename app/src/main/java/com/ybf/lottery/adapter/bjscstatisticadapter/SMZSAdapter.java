package com.ybf.lottery.adapter.bjscstatisticadapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ybf.lottery.R;
import com.ybf.lottery.model.bean.bjscstatisticbean.SMTJBean;

import java.util.List;

/**
 * Created by XQyi on 2018/3/25.
 * Use:双面走势adapter
 */

public class SMZSAdapter extends BaseQuickAdapter<SMTJBean , BaseViewHolder>{

    private Context mContext;

    public SMZSAdapter(@Nullable List<SMTJBean> data , Context context) {
        super(R.layout.bjsc_shuangmian_item_lay , data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, SMTJBean item) {

        holder.setText(R.id.smzs_name , item.getTitleName());

        holder.setText(R.id.double_zs_gj_statistic_da , item.getNumList().getBig());
        holder.setText(R.id.double_zs_gj_statistic_xiao , item.getNumList().getSmall());
        holder.setText(R.id.double_zs_gj_statistic_dan , item.getNumList().getOdd());
        holder.setText(R.id.double_zs_gj_statistic_shuang , item.getNumList().getEven());

        holder.setText(R.id.double_zs_gj_num_da , item.getLastMissList().getBig());
        holder.setText(R.id.double_zs_gj_num_xiao , item.getLastMissList().getSmall());
        holder.setText(R.id.double_zs_gj_num_dan , item.getLastMissList().getOdd());
        holder.setText(R.id.double_zs_gj_num_shuang , item.getLastMissList().getEven());

        holder.setText(R.id.double_zs_gj_leaveout_da , item.getMaxMissList().getBig());
        holder.setText(R.id.double_zs_gj_leaveout_xiao , item.getMaxMissList().getSmall());
        holder.setText(R.id.double_zs_gj_leaveout_dan , item.getMaxMissList().getOdd());
        holder.setText(R.id.double_zs_gj_leaveout_shuang , item.getMaxMissList().getEven());
    }
}
