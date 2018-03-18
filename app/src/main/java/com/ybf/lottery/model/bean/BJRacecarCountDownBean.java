package com.ybf.lottery.model.bean;

/**
 * Created by XQyi on 2018/3/15.
 * Use:北京赛车倒计时接口实体
 */

public class BJRacecarCountDownBean {
    /**
     * issue : 129
     * code : 200
     * info : {"lotcode":"PK10","issue":"670988","drawtime":1521028353000,"status":"1","preissue":"670987","predrawcode":"03,08,06,10,01,07,02,05,04,09","saleissue":"670988","saleStartTime":1521028040000,"saleEndTime":1521028340000,"serverTime":1521028037094}
     */

    private int issue;
    private int code;
    private InfoBean info;

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * lotcode : PK10
         * issue : 670988
         * drawtime : 1521028353000
         * status : 1
         * preissue : 670987
         * predrawcode : 03,08,06,10,01,07,02,05,04,09
         * saleissue : 670988
         * saleStartTime : 1521028040000
         * saleEndTime : 1521028340000
         * serverTime : 1521028037094
         */

        private String lotcode;
        private String issue;
        private long drawtime;
        private String status;
        private String preissue;
        private String predrawcode;
        private String saleissue;
        private long saleStartTime;
        private long saleEndTime;
        private long serverTime;

        public String getLotcode() {
            return lotcode;
        }

        public void setLotcode(String lotcode) {
            this.lotcode = lotcode;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public long getDrawtime() {
            return drawtime;
        }

        public void setDrawtime(long drawtime) {
            this.drawtime = drawtime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPreissue() {
            return preissue;
        }

        public void setPreissue(String preissue) {
            this.preissue = preissue;
        }

        public String getPredrawcode() {
            return predrawcode;
        }

        public void setPredrawcode(String predrawcode) {
            this.predrawcode = predrawcode;
        }

        public String getSaleissue() {
            return saleissue;
        }

        public void setSaleissue(String saleissue) {
            this.saleissue = saleissue;
        }

        public long getSaleStartTime() {
            return saleStartTime;
        }

        public void setSaleStartTime(long saleStartTime) {
            this.saleStartTime = saleStartTime;
        }

        public long getSaleEndTime() {
            return saleEndTime;
        }

        public void setSaleEndTime(long saleEndTime) {
            this.saleEndTime = saleEndTime;
        }

        public long getServerTime() {
            return serverTime;
        }

        public void setServerTime(long serverTime) {
            this.serverTime = serverTime;
        }
    }
}
