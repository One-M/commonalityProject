package com.ybf.lottery.eventBusInfo;

/**
 * Created by XQyi on 2018/3/17.
 * Use:日期选择时传递的date
 */

public class HistoryKJEvent {

    private String eventDate;

    public HistoryKJEvent(String eventDate){
        this.eventDate = eventDate;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
}
