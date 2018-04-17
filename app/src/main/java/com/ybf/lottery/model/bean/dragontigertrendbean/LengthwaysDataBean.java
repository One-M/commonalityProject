package com.ybf.lottery.model.bean.dragontigertrendbean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/17.
 * Use:纵向数据bean
 */

public class LengthwaysDataBean {

    private Integer numData;
    private boolean showYl;//是否显示遗漏背景

    public Integer getNumData() {
        return numData;
    }

    public void setNumData(Integer numData) {
        this.numData = numData;
    }

    public boolean isShowYl() {
        return showYl;
    }

    public void setShowYl(boolean showYl) {
        this.showYl = showYl;
    }
}
