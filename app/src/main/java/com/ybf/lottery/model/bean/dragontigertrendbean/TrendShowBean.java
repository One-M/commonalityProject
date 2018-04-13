package com.ybf.lottery.model.bean.dragontigertrendbean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/13.
 * Use:走势显示数据的封装实体
 */

public class TrendShowBean {

    private String DRAWCODE; //开奖号码
    private List<Integer> zsData;//排名数据

    public String getDRAWCODE() {
        return DRAWCODE;
    }

    public void setDRAWCODE(String DRAWCODE) {
        this.DRAWCODE = DRAWCODE;
    }

    public List<Integer> getZsData() {
        return zsData;
    }

    public void setZsData(List<Integer> zsData) {
        this.zsData = zsData;
    }

}
