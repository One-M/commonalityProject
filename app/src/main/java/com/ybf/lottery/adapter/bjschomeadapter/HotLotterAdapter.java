package com.ybf.lottery.adapter.bjschomeadapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ybf.lottery.R;
import com.ybf.lottery.activity.BasicTrendActivity;
import com.ybf.lottery.activity.BigSmallTrendActivity;
import com.ybf.lottery.activity.DivideRenainderActivity;
import com.ybf.lottery.activity.DragonTigerTrendActivity;
import com.ybf.lottery.activity.FirstSecondTrendActivity;
import com.ybf.lottery.activity.HistoryKJActivity;
import com.ybf.lottery.activity.LocationTrendActivity;
import com.ybf.lottery.activity.MantissaTrendActivity;
import com.ybf.lottery.activity.OddEvenActivity;
import com.ybf.lottery.activity.PrimeNumHeActivity;
import com.ybf.lottery.activity.SpanTrendActivity;
import com.ybf.lottery.activity.StatisticActivity;
import com.ybf.lottery.activity.WinnerRunnerSumValueActivity;
import com.ybf.lottery.activity.WuXingTrendActivity;
import com.ybf.lottery.model.bean.homebean.HotLotteryBean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/10.
 * Use:热门彩种的adapter
 */

public class HotLotterAdapter extends BaseAdapter{

    private static final String LEAGUE = "league";

    private List<HotLotteryBean> mList;
    private Context mContext;


    public HotLotterAdapter(Context context, List<HotLotteryBean> list) {
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HotLotteryHolder mViewHolder;


        if (convertView == null) {
            mViewHolder = new HotLotteryHolder();
            convertView = View.inflate(mContext, R.layout.bjsc_hot_lottery_gridlay_item, null);
            mViewHolder.hot_lottery_ll = (LinearLayout) convertView.findViewById(R.id.hot_lottery_ll);
            mViewHolder.hot_lottery_img = (ImageView) convertView.findViewById(R.id.hot_lottery_img);
            mViewHolder.hot_lottery_name = (TextView) convertView.findViewById(R.id.hot_lottery_name);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (HotLotteryHolder) convertView.getTag();
        }

        if (mList.get(position).getTypeName().equals("")) {
            mViewHolder.hot_lottery_ll.setEnabled(false);
            mViewHolder.hot_lottery_img.setImageDrawable(null);
            mViewHolder.hot_lottery_name.setText("");
        }else{

            setData(mViewHolder , position);
            mViewHolder.hot_lottery_ll.setEnabled(true);
        }
        mViewHolder.hot_lottery_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnClick(position);
            }
        });
        return convertView;
    }

    private void setOnClick(int position){
        switch (position){
            case 0://历史开奖
                mContext.startActivity(new Intent(mContext , HistoryKJActivity.class));
                break;
            case 1://数据统计
                mContext.startActivity(new Intent(mContext , StatisticActivity.class));
                break;
            case 2://基本走势
                mContext.startActivity(new Intent(mContext , BasicTrendActivity.class));
                break;
            case 3://定位走势
                mContext.startActivity(new Intent(mContext , LocationTrendActivity.class));
                break;
            case 4://龙虎走势
                mContext.startActivity(new Intent(mContext , DragonTigerTrendActivity.class));
                break;
            case 5://冠亚走势
                mContext.startActivity(new Intent(mContext , FirstSecondTrendActivity.class));
                break;
            case 6://冠亚和值
                mContext.startActivity(new Intent(mContext , WinnerRunnerSumValueActivity.class));
                break;
            case 7://大小形态
                mContext.startActivity(new Intent(mContext , BigSmallTrendActivity.class));
                break;
                //TODO-------------------以下暂无接口------------------
            case 8://奇偶形态
                mContext.startActivity(new Intent(mContext , OddEvenActivity.class));
                break;
            case 9://质合形态
                mContext.startActivity(new Intent(mContext , PrimeNumHeActivity.class));
                break;
            case 10://跨度走势
                mContext.startActivity(new Intent(mContext , SpanTrendActivity.class));
                break;
            case 11://尾数走势
                mContext.startActivity(new Intent(mContext , MantissaTrendActivity.class));
                break;
            case 12://五行走势
                mContext.startActivity(new Intent(mContext , WuXingTrendActivity.class));
                break;
            case 13://除三余(012)走势
                mContext.startActivity(new Intent(mContext , DivideRenainderActivity.class));
                break;
            default:
                Toast.makeText(mContext, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void setData( HotLotteryHolder holder , int position){
        switch (position){
            case 0:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_lishikaijiang));
                holder.hot_lottery_name.setText("历史开奖");
                break;
            case 1:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_shujutongji));
                holder.hot_lottery_name.setText("数据统计");
                break;
            case 2:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_jibenzoushi));
                holder.hot_lottery_name.setText("基本走势");
                break;
            case 3:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_dingweizoushi));
                holder.hot_lottery_name.setText("定位走势");
                break;
            case 4:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_longhuzoushi));
                holder.hot_lottery_name.setText("龙虎走势");
                break;
            case 5:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_guanyazoushi));
                holder.hot_lottery_name.setText("冠亚走势");
                break;
            case 6:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_guanyahezhi));
                holder.hot_lottery_name.setText("冠亚和值");
                break;
            case 7:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_daxiaoxingtai));
                holder.hot_lottery_name.setText("大小形态");
                break;
            case 8:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_jiqouxingtai));
                holder.hot_lottery_name.setText("奇偶形态");
                break;
            case 9:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_zhihexingtai));
                holder.hot_lottery_name.setText("质和形态");
                break;
            case 10:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_kuaduzoushi));
                holder.hot_lottery_name.setText("跨度走势");
                break;
            case 11:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_weishuzoushi));
                holder.hot_lottery_name.setText("尾数走势");
                break;
            case 12:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_wuxingzoushi));
                holder.hot_lottery_name.setText("五行走势");
                break;
            case 13:
                holder.hot_lottery_img.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.home_chusan));
                holder.hot_lottery_name.setText("除三余(012)走势");
                break;
        }
    }


    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    private static class HotLotteryHolder {

        private TextView hot_lottery_name;
        private ImageView hot_lottery_img;
        private LinearLayout hot_lottery_ll;
    }
}
