package com.ybf.lottery.eventBusInfo;

/**
 * Created by XQyi on 2018/3/27.
 * Use:数据统计传递的 期号
 */

public class StatisticKJEvent {

    private int eventIssue;

    public StatisticKJEvent(int eventDate){
        this.eventIssue = eventDate;
    }

    public int getEventIssue() {
        return eventIssue;
    }

    public void setEventIssue(int eventIssue) {
        this.eventIssue = eventIssue;
    }
}
