package com.ybf.lottery.model.bean.bjscstatisticbean;

/**
 * Created by XQyi on 2018/3/25.
 * Use: 统计数据显示的实体（自己封装）
 */

public class StatisticalBean {

    private String statisticalItem;//统计项
    private String occurrenceNum;//出现次数
    private String occurrenceProbability;//出现概率
    private String theoryProbability;//理论概率

    public String getStatisticalItem() {
        return statisticalItem;
    }

    public void setStatisticalItem(String statisticalItem) {
        this.statisticalItem = statisticalItem;
    }

    public String getOccurrenceNum() {
        return occurrenceNum;
    }

    public void setOccurrenceNum(String occurrenceNum) {
        this.occurrenceNum = occurrenceNum;
    }

    public String getOccurrenceProbability() {
        return occurrenceProbability;
    }

    public void setOccurrenceProbability(String occurrenceProbability) {
        this.occurrenceProbability = occurrenceProbability;
    }

    public String getTheoryProbability() {
        return theoryProbability;
    }

    public void setTheoryProbability(String theoryProbability) {
        this.theoryProbability = theoryProbability;
    }
}
