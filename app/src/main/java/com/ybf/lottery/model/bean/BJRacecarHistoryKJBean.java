package com.ybf.lottery.model.bean;

/**
 * Created by XQyi on 2018/3/15.
 * Use:北京赛车历史开奖数据实体
 */

public class BJRacecarHistoryKJBean {


    /**
     * drawTime : 1521028058000
     * issue : 670987
     * drawCode : 03,08,06,10,01,07,02,05,04,09
     * sumVal : 11
     * daXiao : pk10.history.small
     * danShuang : pk10.history.odd
     * longhu1 : pk10.history.tiger
     * longhu2 : pk10.history.dragon
     * longhu3 : pk10.history.dragon
     * longhu4 : pk10.history.dragon
     * longhu5 : pk10.history.tiger
     * rnum : 1
     */

    private int dataType = 0;// 数据类型的type(初始为0 暂无用到)

    private long drawTime;
    private String issue;
    private String drawCode;
    private int sumVal;
    private String daXiao;
    private String danShuang;
    private String longhu1;
    private String longhu2;
    private String longhu3;
    private String longhu4;
    private String longhu5;
    private int rnum;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public long getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(long drawTime) {
        this.drawTime = drawTime;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDrawCode() {
        return drawCode;
    }

    public void setDrawCode(String drawCode) {
        this.drawCode = drawCode;
    }

    public int getSumVal() {
        return sumVal;
    }

    public void setSumVal(int sumVal) {
        this.sumVal = sumVal;
    }

    public String getDaXiao() {
        return daXiao;
    }

    public void setDaXiao(String daXiao) {
        this.daXiao = daXiao;
    }

    public String getDanShuang() {
        return danShuang;
    }

    public void setDanShuang(String danShuang) {
        this.danShuang = danShuang;
    }

    public String getLonghu1() {
        return longhu1;
    }

    public void setLonghu1(String longhu1) {
        this.longhu1 = longhu1;
    }

    public String getLonghu2() {
        return longhu2;
    }

    public void setLonghu2(String longhu2) {
        this.longhu2 = longhu2;
    }

    public String getLonghu3() {
        return longhu3;
    }

    public void setLonghu3(String longhu3) {
        this.longhu3 = longhu3;
    }

    public String getLonghu4() {
        return longhu4;
    }

    public void setLonghu4(String longhu4) {
        this.longhu4 = longhu4;
    }

    public String getLonghu5() {
        return longhu5;
    }

    public void setLonghu5(String longhu5) {
        this.longhu5 = longhu5;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }
}
