package com.ybf.lottery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ybf.lottery.R;

import java.util.List;

/**
 * Created by XQyi on 2018/3/30.
 * Use:期号显示的adapter
 */

public class IssueDataAdapter extends BaseAdapter{
    private List listData=null;
    private int layoutId;
    private Context mContext;
    public IssueDataAdapter(int layoutID , Context context){
        this.layoutId=layoutID;
        this.mContext = context;
    }
    public void bindData(List data){
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
            convertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        }
        final TextView tv_content = (TextView) convertView.findViewById(R.id.tv_content);
        tv_content.setText(listData.get(position).toString());
        if (position%2 == 0){
            tv_content.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.border_color));
        }else{
            tv_content.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.border_b_color));
        }
        return convertView;
    }
}
