package com.ybf.lottery.model.bean.bjscstatisticbean;

import java.util.List;

/**
 * Created by XQyi on 2018/3/25.
 * Use:双面走势封装实体
 */

public class SMTJBean {

    private BNumBean numList;
    private BNumBean lastMissList;
    private BNumBean maxMissList;
    private String titleName;

    public BNumBean getNumList() {
        return numList;
    }

    public void setNumList(BNumBean numList) {
        this.numList = numList;
    }

    public BNumBean getLastMissList() {
        return lastMissList;
    }

    public void setLastMissList(BNumBean lastMissList) {
        this.lastMissList = lastMissList;
    }

    public BNumBean getMaxMissList() {
        return maxMissList;
    }

    public void setMaxMissList(BNumBean maxMissList) {
        this.maxMissList = maxMissList;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public static class BNumBean{
        private String big;
        private String small;
        private String odd;
        private String even;

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getOdd() {
            return odd;
        }

        public void setOdd(String odd) {
            this.odd = odd;
        }

        public String getEven() {
            return even;
        }

        public void setEven(String even) {
            this.even = even;
        }
    }
}
