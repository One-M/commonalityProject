package com.ybf.lottery.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ybf.lottery.R;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by XQyi on 2018/3/16.
 * Use:历史开奖页内容adapter
 */

public class BJRacecarHistoryKJAdapter extends BaseQuickAdapter<BJRacecarHistoryKJBean , BaseViewHolder> {

    private Context context;

    public BJRacecarHistoryKJAdapter(@Nullable List<BJRacecarHistoryKJBean> data , Context context) {
        super(R.layout.kj_number_itemlay ,data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, BJRacecarHistoryKJBean itemData) {

        String deCode = itemData.getDrawCode();
        if (deCode != null) {
            setKJNumber(holder , stringToList(deCode));
        }

        holder.setText(R.id.value_text1 , itemData.getSumVal()+"");
        // pk10.history.small
        holder.setText(R.id.value_text2 , setData(itemData.getDaXiao()));
        holder.setText(R.id.value_text3 , setData(itemData.getDanShuang()));

        holder.setText(R.id.value_text4 , setData(itemData.getLonghu1()));
        holder.setText(R.id.value_text5 , setData(itemData.getLonghu2()));
        holder.setText(R.id.value_text6 , setData(itemData.getLonghu3()));
        holder.setText(R.id.value_text7 , setData(itemData.getLonghu4()));
        holder.setText(R.id.value_text8 , setData(itemData.getLonghu5()));

        setItemBg(holder , holder.getPosition());

    }
    /**数据设置 StringUtils中处理*/
    private String setData(String d){
        return toChineseString(splitString(filterStr(d) , 13 , filterStr(d).length()));
    }

    /**设置开奖号码*/
    private void setKJNumber(BaseViewHolder mHolder , List<String> numList){
        mHolder.setText(R.id.textview1  , numList.get(0));
        mHolder.setText(R.id.textview2  , numList.get(1));
        mHolder.setText(R.id.textview3  , numList.get(2));
        mHolder.setText(R.id.textview4  , numList.get(3));
        mHolder.setText(R.id.textview5  , numList.get(4));
        mHolder.setText(R.id.textview6  , numList.get(5));
        mHolder.setText(R.id.textview7  , numList.get(6));
        mHolder.setText(R.id.textview8  , numList.get(7));
        mHolder.setText(R.id.textview9  , numList.get(8));
        mHolder.setText(R.id.textview10 , numList.get(9));

        setKJNumColor((TextView) mHolder.getView(R.id.textview1 ) , numList.get(0));
        setKJNumColor((TextView) mHolder.getView(R.id.textview2 ) , numList.get(1));
        setKJNumColor((TextView) mHolder.getView(R.id.textview3 ) , numList.get(2));
        setKJNumColor((TextView) mHolder.getView(R.id.textview4 ) , numList.get(3));
        setKJNumColor((TextView) mHolder.getView(R.id.textview5 ) , numList.get(4));
        setKJNumColor((TextView) mHolder.getView(R.id.textview6 ) , numList.get(5));
        setKJNumColor((TextView) mHolder.getView(R.id.textview7 ) , numList.get(6));
        setKJNumColor((TextView) mHolder.getView(R.id.textview8 ) , numList.get(7));
        setKJNumColor((TextView) mHolder.getView(R.id.textview9 ) , numList.get(8));
        setKJNumColor((TextView) mHolder.getView(R.id.textview10) , numList.get(9));
    }

    /**设置开奖号码背景色*/
    private void setKJNumColor(TextView tView , String num){
        switch (num){
            case "01":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_1));
                break;
            case "02":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_2));
                break;
            case "03":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_3));
                break;
            case "04":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_4));
                break;
            case "05":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_5));
                break;
            case "06":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_6));
                break;
            case "07":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_7));
                break;
            case "08":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_8));
                break;
            case "09":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_9));
                break;
            case "10":
                tView.setBackgroundColor(context.getResources().getColor(R.color.num_10));
                break;
        }
    }

    /**设置单双行bg*/
    private void setItemBg(BaseViewHolder mHolder , int position){
        if (position%2 == 0) {
            mHolder.setBackgroundRes(R.id.kj_num_ll , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text1 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text2 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text3 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text4 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text5 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text6 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text7 , R.drawable.border_color);
            mHolder.setBackgroundRes(R.id.value_text8 , R.drawable.border_color);
        }else{
            mHolder.setBackgroundRes(R.id.kj_num_ll , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text1 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text2 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text3 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text4 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text5 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text6 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text7 , R.drawable.border_b_color);
            mHolder.setBackgroundRes(R.id.value_text8 , R.drawable.border_b_color);
        }
    }

    private String filterStr(String str){
        return str == null ? "" : str;
    }

    /**
     * string ==> List<String>
     * @param strs
     * @return
     */
    private List<String> stringToList(String strs){
        String str[] = strs.split(",");
        return Arrays.asList(str);
    }
    /**
     * 北京赛车历史开奖英文字符串
     * @param s
     * @param start
     * @param end
     */
    private String splitString(String s , int start , int end){
        return start < end ? s.substring(start , end) : "";
    }
    /**
     * 英==>中
     * @return
     */
    private String toChineseString(String str){
        String chineseStr = "";
        switch (str){
            case "small":
                chineseStr = "小";
                break;
            case "big":
                chineseStr = "大";
                break;
            case "odd":
                chineseStr = "单";
                break;
            case "even":
                chineseStr = "双";
                break;
            case "tiger":
                chineseStr = "虎";
                break;
            case "dragon":
                chineseStr = "龙";
                break;
        }
        return chineseStr;
    }
}
