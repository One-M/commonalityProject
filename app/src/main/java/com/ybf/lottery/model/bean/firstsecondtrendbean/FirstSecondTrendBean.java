package com.ybf.lottery.model.bean.firstsecondtrendbean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/21.
 * Use:冠亚走势接收实体
 */

public class FirstSecondTrendBean {

    /**
     * zs : [{"ISSUE":"677737","S10":12,"F01":5,"F06":0,"SUMVAL":14,"F07":9,"F08":17,"SUMSMALL":1,"F09":2,"F02":12,"F03":4,"F04":1,"F05":76,"SUMODD":1,"F10":3,"S01":2,"S02":7,"S03":3,"S04":13,"S05":34,"S06":8,"S07":1,"SUMEVEN":0,"S08":0,"S09":5,"SUMBIG":0,"DRAWCODE":"06,08,04,02,05,03,09,01,10,07"},{"ISSUE":"677736","S10":11,"F01":4,"F06":5,"SUMVAL":11,"F07":8,"F08":16,"SUMSMALL":0,"F09":1,"F02":11,"F03":3,"F04":0,"F05":75,"SUMODD":0,"F10":2,"S01":1,"S02":6,"S03":2,"S04":12,"S05":33,"S06":7,"S07":0,"SUMEVEN":1,"S08":3,"S09":4,"SUMBIG":2,"DRAWCODE":"04,07,06,01,10,05,09,02,08,03"},{"ISSUE":"677735","S10":10,"F01":3,"F06":4,"SUMVAL":10,"F07":7,"F08":15,"SUMSMALL":0,"F09":0,"F02":10,"F03":2,"F04":16,"F05":74,"SUMODD":1,"F10":1,"S01":0,"S02":5,"S03":1,"S04":11,"S05":32,"S06":6,"S07":12,"SUMEVEN":0,"S08":2,"S09":3,"SUMBIG":1,"DRAWCODE":"09,01,10,03,07,04,08,06,02,05"},{"ISSUE":"677734","S10":9,"F01":2,"F06":3,"SUMVAL":13,"F07":6,"F08":14,"SUMSMALL":1,"F09":7,"F02":9,"F03":1,"F04":15,"F05":73,"SUMODD":0,"F10":0,"S01":6,"S02":4,"S03":0,"S04":10,"S05":31,"S06":5,"S07":11,"SUMEVEN":2,"S08":1,"S09":2,"SUMBIG":0,"DRAWCODE":"10,03,06,07,09,05,04,08,02,01"},{"ISSUE":"677733","S10":8,"F01":1,"F06":2,"SUMVAL":11,"F07":5,"F08":13,"SUMSMALL":0,"F09":6,"F02":8,"F03":0,"F04":14,"F05":72,"SUMODD":0,"F10":11,"S01":5,"S02":3,"S03":2,"S04":9,"S05":30,"S06":4,"S07":10,"SUMEVEN":1,"S08":0,"S09":1,"SUMBIG":8,"DRAWCODE":"03,08,05,10,04,01,07,02,09,06"},{"ISSUE":"677732","S10":7,"F01":0,"F06":1,"SUMVAL":10,"F07":4,"F08":12,"SUMSMALL":0,"F09":5,"F02":7,"F03":17,"F04":13,"F05":71,"SUMODD":1,"F10":10,"S01":4,"S02":2,"S03":1,"S04":8,"S05":29,"S06":3,"S07":9,"SUMEVEN":0,"S08":21,"S09":0,"SUMBIG":7,"DRAWCODE":"01,09,03,04,06,02,05,08,10,07"},{"ISSUE":"677731","S10":6,"F01":2,"F06":0,"SUMVAL":9,"F07":3,"F08":11,"SUMSMALL":0,"F09":4,"F02":6,"F03":16,"F04":12,"F05":70,"SUMODD":0,"F10":9,"S01":3,"S02":1,"S03":0,"S04":7,"S05":28,"S06":2,"S07":8,"SUMEVEN":1,"S08":20,"S09":19,"SUMBIG":6,"DRAWCODE":"06,03,01,05,02,09,07,10,08,04"},{"ISSUE":"677730","S10":5,"F01":1,"F06":0,"SUMVAL":8,"F07":2,"F08":10,"SUMSMALL":0,"F09":3,"F02":5,"F03":15,"F04":11,"F05":69,"SUMODD":1,"F10":8,"S01":2,"S02":0,"S03":10,"S04":6,"S05":27,"S06":1,"S07":7,"SUMEVEN":0,"S08":19,"S09":18,"SUMBIG":5,"DRAWCODE":"06,02,04,01,05,09,08,07,03,10"},{"ISSUE":"677729","S10":4,"F01":0,"F06":3,"SUMVAL":7,"F07":1,"F08":9,"SUMSMALL":0,"F09":2,"F02":4,"F03":14,"F04":10,"F05":68,"SUMODD":0,"F10":7,"S01":1,"S02":2,"S03":9,"S04":5,"S05":26,"S06":0,"S07":6,"SUMEVEN":1,"S08":18,"S09":17,"SUMBIG":4,"DRAWCODE":"01,06,05,08,07,02,03,04,09,10"},{"ISSUE":"677728","S10":3,"F01":7,"F06":2,"SUMVAL":8,"F07":0,"F08":8,"SUMSMALL":0,"F09":1,"F02":3,"F03":13,"F04":9,"F05":67,"SUMODD":1,"F10":6,"S01":0,"S02":1,"S03":8,"S04":4,"S05":25,"S06":6,"S07":5,"SUMEVEN":0,"S08":17,"S09":16,"SUMBIG":3,"DRAWCODE":"07,01,04,03,05,09,10,02,06,08"},{"ISSUE":"677727","S10":2,"F01":6,"F06":1,"SUMVAL":11,"F07":3,"F08":7,"SUMSMALL":0,"F09":0,"F02":2,"F03":12,"F04":8,"F05":66,"SUMODD":0,"F10":5,"S01":20,"S02":0,"S03":7,"S04":3,"S05":24,"S06":5,"S07":4,"SUMEVEN":1,"S08":16,"S09":15,"SUMBIG":2,"DRAWCODE":"09,02,10,05,08,07,04,03,06,01"},{"ISSUE":"677726","S10":1,"F01":5,"F06":0,"SUMVAL":8,"F07":2,"F08":6,"SUMSMALL":0,"F09":8,"F02":1,"F03":11,"F04":7,"F05":65,"SUMODD":2,"F10":4,"S01":19,"S02":0,"S03":6,"S04":2,"S05":23,"S06":4,"S07":3,"SUMEVEN":0,"S08":15,"S09":14,"SUMBIG":1,"DRAWCODE":"06,02,09,05,03,07,10,01,04,08"},{"ISSUE":"677725","S10":0,"F01":4,"F06":11,"SUMVAL":12,"F07":1,"F08":5,"SUMSMALL":1,"F09":7,"F02":0,"F03":10,"F04":6,"F05":64,"SUMODD":1,"F10":3,"S01":18,"S02":11,"S03":5,"S04":1,"S05":22,"S06":3,"S07":2,"SUMEVEN":0,"S08":14,"S09":13,"SUMBIG":0,"DRAWCODE":"02,10,04,03,08,01,09,07,05,06"},{"ISSUE":"677724","S10":5,"F01":3,"F06":10,"SUMVAL":11,"F07":0,"F08":4,"SUMSMALL":0,"F09":6,"F02":1,"F03":9,"F04":5,"F05":63,"SUMODD":0,"F10":2,"S01":17,"S02":10,"S03":4,"S04":0,"S05":21,"S06":2,"S07":1,"SUMEVEN":2,"S08":13,"S09":12,"SUMBIG":2,"DRAWCODE":"07,04,08,09,02,06,03,01,10,05"},{"ISSUE":"677723","S10":4,"F01":2,"F06":9,"SUMVAL":9,"F07":14,"F08":3,"SUMSMALL":0,"F09":5,"F02":0,"F03":8,"F04":4,"F05":62,"SUMODD":0,"F10":1,"S01":16,"S02":9,"S03":3,"S04":2,"S05":20,"S06":1,"S07":0,"SUMEVEN":1,"S08":12,"S09":11,"SUMBIG":1,"DRAWCODE":"02,07,03,01,05,06,08,04,10,09"},{"ISSUE":"677722","S10":3,"F01":1,"F06":8,"SUMVAL":16,"F07":13,"F08":2,"SUMSMALL":1,"F09":4,"F02":20,"F03":7,"F04":3,"F05":61,"SUMODD":1,"F10":0,"S01":15,"S02":8,"S03":2,"S04":1,"S05":19,"S06":0,"S07":4,"SUMEVEN":0,"S08":11,"S09":10,"SUMBIG":0,"DRAWCODE":"10,06,04,09,08,01,03,05,07,02"},{"ISSUE":"677721","S10":2,"F01":0,"F06":7,"SUMVAL":5,"F07":12,"F08":1,"SUMSMALL":0,"F09":3,"F02":19,"F03":6,"F04":2,"F05":60,"SUMODD":0,"F10":18,"S01":14,"S02":7,"S03":1,"S04":0,"S05":18,"S06":16,"S07":3,"SUMEVEN":2,"S08":10,"S09":9,"SUMBIG":2,"DRAWCODE":"01,04,07,03,09,02,05,08,06,10"},{"ISSUE":"677720","S10":1,"F01":3,"F06":6,"SUMVAL":11,"F07":11,"F08":0,"SUMSMALL":0,"F09":2,"F02":18,"F03":5,"F04":1,"F05":59,"SUMODD":0,"F10":17,"S01":13,"S02":6,"S03":0,"S04":4,"S05":17,"S06":15,"S07":2,"SUMEVEN":1,"S08":9,"S09":8,"SUMBIG":1,"DRAWCODE":"08,03,07,02,05,09,01,06,10,04"},{"ISSUE":"677719","S10":0,"F01":2,"F06":5,"SUMVAL":14,"F07":10,"F08":3,"SUMSMALL":2,"F09":1,"F02":17,"F03":4,"F04":0,"F05":58,"SUMODD":4,"F10":16,"S01":12,"S02":5,"S03":9,"S04":3,"S05":16,"S06":14,"S07":1,"SUMEVEN":0,"S08":8,"S09":7,"SUMBIG":0,"DRAWCODE":"04,10,06,09,01,08,02,07,03,05"},{"ISSUE":"677718","S10":9,"F01":1,"F06":4,"SUMVAL":16,"F07":9,"F08":2,"SUMSMALL":1,"F09":0,"F02":16,"F03":3,"F04":8,"F05":57,"SUMODD":3,"F10":15,"S01":11,"S02":4,"S03":8,"S04":2,"S05":15,"S06":13,"S07":0,"SUMEVEN":0,"S08":7,"S09":6,"SUMBIG":0,"DRAWCODE":"09,07,01,03,02,08,05,04,06,10"},{"ISSUE":"677717","S10":8,"F01":0,"F06":3,"SUMVAL":8,"F07":8,"F08":1,"SUMSMALL":0,"F09":4,"F02":15,"F03":2,"F04":7,"F05":56,"SUMODD":2,"F10":14,"S01":10,"S02":3,"S03":7,"S04":1,"S05":14,"S06":12,"S07":0,"SUMEVEN":0,"S08":6,"S09":5,"SUMBIG":1,"DRAWCODE":"01,07,09,10,08,02,06,04,05,03"},{"ISSUE":"677716","S10":7,"F01":32,"F06":2,"SUMVAL":12,"F07":7,"F08":0,"SUMSMALL":1,"F09":3,"F02":14,"F03":1,"F04":6,"F05":55,"SUMODD":1,"F10":13,"S01":9,"S02":2,"S03":6,"S04":0,"S05":13,"S06":11,"S07":10,"SUMEVEN":0,"S08":5,"S09":4,"SUMBIG":0,"DRAWCODE":"08,04,06,03,07,10,01,09,05,02"},{"ISSUE":"677715","S10":6,"F01":31,"F06":1,"SUMVAL":7,"F07":6,"F08":20,"SUMSMALL":0,"F09":2,"F02":13,"F03":0,"F04":5,"F05":54,"SUMODD":0,"F10":12,"S01":8,"S02":1,"S03":5,"S04":0,"S05":12,"S06":10,"S07":9,"SUMEVEN":1,"S08":4,"S09":3,"SUMBIG":2,"DRAWCODE":"03,04,08,10,09,02,06,07,01,05"},{"ISSUE":"677714","S10":5,"F01":30,"F06":0,"SUMVAL":8,"F07":5,"F08":19,"SUMSMALL":0,"F09":1,"F02":12,"F03":3,"F04":4,"F05":53,"SUMODD":1,"F10":11,"S01":7,"S02":0,"S03":4,"S04":1,"S05":11,"S06":9,"S07":8,"SUMEVEN":0,"S08":3,"S09":2,"SUMBIG":1,"DRAWCODE":"06,02,04,01,10,09,03,07,08,05"},{"ISSUE":"677713","S10":4,"F01":29,"F06":1,"SUMVAL":13,"F07":4,"F08":18,"SUMSMALL":2,"F09":0,"F02":11,"F03":2,"F04":3,"F05":52,"SUMODD":0,"F10":10,"S01":6,"S02":9,"S03":3,"S04":0,"S05":10,"S06":8,"S07":7,"SUMEVEN":12,"S08":2,"S09":1,"SUMBIG":0,"DRAWCODE":"09,04,02,01,03,08,10,07,06,05"},{"ISSUE":"677712","S10":3,"F01":28,"F06":0,"SUMVAL":15,"F07":3,"F08":17,"SUMSMALL":1,"F09":4,"F02":10,"F03":1,"F04":2,"F05":51,"SUMODD":0,"F10":9,"S01":5,"S02":8,"S03":2,"S04":19,"S05":9,"S06":7,"S07":6,"SUMEVEN":11,"S08":1,"S09":0,"SUMBIG":0,"DRAWCODE":"06,09,05,07,03,08,02,01,10,04"},{"ISSUE":"677711","S10":2,"F01":27,"F06":5,"SUMVAL":11,"F07":2,"F08":16,"SUMSMALL":0,"F09":3,"F02":9,"F03":0,"F04":1,"F05":50,"SUMODD":0,"F10":8,"S01":4,"S02":7,"S03":1,"S04":18,"S05":8,"S06":6,"S07":5,"SUMEVEN":10,"S08":0,"S09":13,"SUMBIG":2,"DRAWCODE":"03,08,01,07,09,04,05,10,02,06"},{"ISSUE":"677710","S10":1,"F01":26,"F06":4,"SUMVAL":7,"F07":1,"F08":15,"SUMSMALL":0,"F09":2,"F02":8,"F03":5,"F04":0,"F05":49,"SUMODD":0,"F10":7,"S01":3,"S02":6,"S03":0,"S04":17,"S05":7,"S06":5,"S07":4,"SUMEVEN":9,"S08":2,"S09":12,"SUMBIG":1,"DRAWCODE":"04,03,09,02,01,06,07,05,10,08"},{"ISSUE":"677709","S10":0,"F01":25,"F06":3,"SUMVAL":17,"F07":0,"F08":14,"SUMSMALL":2,"F09":1,"F02":7,"F03":4,"F04":2,"F05":48,"SUMODD":0,"F10":6,"S01":2,"S02":5,"S03":23,"S04":16,"S05":6,"S06":4,"S07":3,"SUMEVEN":8,"S08":1,"S09":11,"SUMBIG":0,"DRAWCODE":"07,10,04,01,09,02,06,05,03,08"},{"ISSUE":"677708","S10":24,"F01":24,"F06":2,"SUMVAL":17,"F07":18,"F08":13,"SUMSMALL":1,"F09":0,"F02":6,"F03":3,"F04":1,"F05":47,"SUMODD":0,"F10":5,"S01":1,"S02":4,"S03":22,"S04":15,"S05":5,"S06":3,"S07":2,"SUMEVEN":7,"S08":0,"S09":10,"SUMBIG":0,"DRAWCODE":"09,08,04,03,01,05,06,02,10,07"}]
     * code : 200
     * tj : {"occ2":{"S10":0,"ISSUE":0,"F01":0,"SUMVAL":0,"F06":0,"F07":0,"F08":0,"F09":0,"SUMSMALL":0,"F02":0,"F03":0,"F04":0,"F05":0,"SUMODD":0,"F10":0,"S01":0,"S02":0,"S03":0,"S04":0,"S05":0,"S06":0,"S07":0,"SUMEVEN":0,"S08":0,"S09":0,"SUMBIG":0,"DRAWCODE":0},"avgMiss":{"S10":12,"ISSUE":0,"F01":9,"SUMVAL":14,"F06":3,"F07":11,"F08":13,"F09":4,"SUMSMALL":0,"F02":11,"F03":7,"F04":6,"F05":76,"SUMODD":0,"F10":10,"S01":9,"S02":5,"S03":9,"S04":6,"S05":34,"S06":10,"S07":5,"SUMEVEN":1,"S08":5,"S09":12,"SUMBIG":1,"DRAWCODE":0},"lastMiss":{"S10":12,"ISSUE":0,"F01":5,"SUMVAL":14,"F06":0,"F07":9,"F08":17,"F09":2,"SUMSMALL":1,"F02":12,"F03":4,"F04":1,"F05":76,"SUMODD":1,"F10":3,"S01":2,"S02":7,"S03":3,"S04":13,"S05":34,"S06":8,"S07":1,"SUMEVEN":0,"S08":0,"S09":5,"SUMBIG":0,"DRAWCODE":0},"maxCont":{"S10":1,"ISSUE":0,"F01":1,"SUMVAL":0,"F06":2,"F07":1,"F08":1,"F09":1,"SUMSMALL":8,"F02":1,"F03":1,"F04":1,"F05":0,"SUMODD":6,"F10":1,"S01":1,"S02":2,"S03":1,"S04":2,"S05":0,"S06":1,"S07":2,"SUMEVEN":4,"S08":1,"S09":1,"SUMBIG":2,"DRAWCODE":0},"probability":{"ISSUE":0,"S10":10000,"F01":13333,"F06":20000,"SUMVAL":0,"F07":10000,"F08":6666,"SUMSMALL":63333,"F09":16666,"F02":6666,"F03":10000,"F04":10000,"F05":0,"SUMODD":56666,"F10":6666,"S01":6666,"S02":13333,"S03":13333,"S04":16666,"S05":0,"S06":6666,"S07":13333,"SUMEVEN":43333,"S08":13333,"S09":6666,"SUMBIG":36666,"DRAWCODE":0},"maxMiss":{"S10":24,"ISSUE":0,"F01":32,"SUMVAL":17,"F06":11,"F07":18,"F08":20,"F09":8,"SUMSMALL":2,"F02":20,"F03":17,"F04":16,"F05":76,"SUMODD":4,"F10":18,"S01":20,"S02":11,"S03":23,"S04":19,"S05":34,"S06":16,"S07":12,"SUMEVEN":12,"S08":21,"S09":19,"SUMBIG":8,"DRAWCODE":0},"occ":{"S10":3,"ISSUE":0,"F01":4,"SUMVAL":0,"F06":6,"F07":3,"F08":2,"F09":5,"SUMSMALL":19,"F02":2,"F03":3,"F04":3,"F05":0,"SUMODD":17,"F10":2,"S01":2,"S02":4,"S03":4,"S04":5,"S05":0,"S06":2,"S07":4,"SUMEVEN":13,"S08":4,"S09":2,"SUMBIG":11,"DRAWCODE":0}}
     */

    private int code;
    private TjBean tj;
    private List<ZsBean> zs;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TjBean getTj() {
        return tj;
    }

    public void setTj(TjBean tj) {
        this.tj = tj;
    }

    public List<ZsBean> getZs() {
        return zs;
    }

    public void setZs(List<ZsBean> zs) {
        this.zs = zs;
    }

    public static class TjBean {
        /**
         * occ2 : {"S10":0,"ISSUE":0,"F01":0,"SUMVAL":0,"F06":0,"F07":0,"F08":0,"F09":0,"SUMSMALL":0,"F02":0,"F03":0,"F04":0,"F05":0,"SUMODD":0,"F10":0,"S01":0,"S02":0,"S03":0,"S04":0,"S05":0,"S06":0,"S07":0,"SUMEVEN":0,"S08":0,"S09":0,"SUMBIG":0,"DRAWCODE":0}
         * avgMiss : {"S10":12,"ISSUE":0,"F01":9,"SUMVAL":14,"F06":3,"F07":11,"F08":13,"F09":4,"SUMSMALL":0,"F02":11,"F03":7,"F04":6,"F05":76,"SUMODD":0,"F10":10,"S01":9,"S02":5,"S03":9,"S04":6,"S05":34,"S06":10,"S07":5,"SUMEVEN":1,"S08":5,"S09":12,"SUMBIG":1,"DRAWCODE":0}
         * lastMiss : {"S10":12,"ISSUE":0,"F01":5,"SUMVAL":14,"F06":0,"F07":9,"F08":17,"F09":2,"SUMSMALL":1,"F02":12,"F03":4,"F04":1,"F05":76,"SUMODD":1,"F10":3,"S01":2,"S02":7,"S03":3,"S04":13,"S05":34,"S06":8,"S07":1,"SUMEVEN":0,"S08":0,"S09":5,"SUMBIG":0,"DRAWCODE":0}
         * maxCont : {"S10":1,"ISSUE":0,"F01":1,"SUMVAL":0,"F06":2,"F07":1,"F08":1,"F09":1,"SUMSMALL":8,"F02":1,"F03":1,"F04":1,"F05":0,"SUMODD":6,"F10":1,"S01":1,"S02":2,"S03":1,"S04":2,"S05":0,"S06":1,"S07":2,"SUMEVEN":4,"S08":1,"S09":1,"SUMBIG":2,"DRAWCODE":0}
         * probability : {"ISSUE":0,"S10":10000,"F01":13333,"F06":20000,"SUMVAL":0,"F07":10000,"F08":6666,"SUMSMALL":63333,"F09":16666,"F02":6666,"F03":10000,"F04":10000,"F05":0,"SUMODD":56666,"F10":6666,"S01":6666,"S02":13333,"S03":13333,"S04":16666,"S05":0,"S06":6666,"S07":13333,"SUMEVEN":43333,"S08":13333,"S09":6666,"SUMBIG":36666,"DRAWCODE":0}
         * maxMiss : {"S10":24,"ISSUE":0,"F01":32,"SUMVAL":17,"F06":11,"F07":18,"F08":20,"F09":8,"SUMSMALL":2,"F02":20,"F03":17,"F04":16,"F05":76,"SUMODD":4,"F10":18,"S01":20,"S02":11,"S03":23,"S04":19,"S05":34,"S06":16,"S07":12,"SUMEVEN":12,"S08":21,"S09":19,"SUMBIG":8,"DRAWCODE":0}
         * occ : {"S10":3,"ISSUE":0,"F01":4,"SUMVAL":0,"F06":6,"F07":3,"F08":2,"F09":5,"SUMSMALL":19,"F02":2,"F03":3,"F04":3,"F05":0,"SUMODD":17,"F10":2,"S01":2,"S02":4,"S03":4,"S04":5,"S05":0,"S06":2,"S07":4,"SUMEVEN":13,"S08":4,"S09":2,"SUMBIG":11,"DRAWCODE":0}
         */

        private FSTrendTJBean occ2;
        private FSTrendTJBean avgMiss;
        private FSTrendTJBean lastMiss;
        private FSTrendTJBean maxCont;
        private FSTrendTJBean probability;
        private FSTrendTJBean maxMiss;
        private FSTrendTJBean occ;

        public FSTrendTJBean getOcc2() {
            return occ2;
        }

        public void setOcc2(FSTrendTJBean occ2) {
            this.occ2 = occ2;
        }

        public FSTrendTJBean getAvgMiss() {
            return avgMiss;
        }

        public void setAvgMiss(FSTrendTJBean avgMiss) {
            this.avgMiss = avgMiss;
        }

        public FSTrendTJBean getLastMiss() {
            return lastMiss;
        }

        public void setLastMiss(FSTrendTJBean lastMiss) {
            this.lastMiss = lastMiss;
        }

        public FSTrendTJBean getMaxCont() {
            return maxCont;
        }

        public void setMaxCont(FSTrendTJBean maxCont) {
            this.maxCont = maxCont;
        }

        public FSTrendTJBean getProbability() {
            return probability;
        }

        public void setProbability(FSTrendTJBean probability) {
            this.probability = probability;
        }

        public FSTrendTJBean getMaxMiss() {
            return maxMiss;
        }

        public void setMaxMiss(FSTrendTJBean maxMiss) {
            this.maxMiss = maxMiss;
        }

        public FSTrendTJBean getOcc() {
            return occ;
        }

        public void setOcc(FSTrendTJBean occ) {
            this.occ = occ;
        }

        public static class FSTrendTJBean{
            /**
             * S10 : 3
             * ISSUE : 0
             * F01 : 4
             * SUMVAL : 0
             * F06 : 6
             * F07 : 3
             * F08 : 2
             * F09 : 5
             * SUMSMALL : 19
             * F02 : 2
             * F03 : 3
             * F04 : 3
             * F05 : 0
             * SUMODD : 17
             * F10 : 2
             * S01 : 2
             * S02 : 4
             * S03 : 4
             * S04 : 5
             * S05 : 0
             * S06 : 2
             * S07 : 4
             * SUMEVEN : 13
             * S08 : 4
             * S09 : 2
             * SUMBIG : 11
             * DRAWCODE : 0
             */

            private int S10;
            private int ISSUE;
            private int F01;
            private int SUMVAL;
            private int F06;
            private int F07;
            private int F08;
            private int F09;
            private int SUMSMALL;
            private int F02;
            private int F03;
            private int F04;
            private int F05;
            private int SUMODD;
            private int F10;
            private int S01;
            private int S02;
            private int S03;
            private int S04;
            private int S05;
            private int S06;
            private int S07;
            private int SUMEVEN;
            private int S08;
            private int S09;
            private int SUMBIG;
            private int DRAWCODE;

            public int getS10() {
                return S10;
            }

            public void setS10(int s10) {
                S10 = s10;
            }

            public int getISSUE() {
                return ISSUE;
            }

            public void setISSUE(int ISSUE) {
                this.ISSUE = ISSUE;
            }

            public int getF01() {
                return F01;
            }

            public void setF01(int f01) {
                F01 = f01;
            }

            public int getSUMVAL() {
                return SUMVAL;
            }

            public void setSUMVAL(int SUMVAL) {
                this.SUMVAL = SUMVAL;
            }

            public int getF06() {
                return F06;
            }

            public void setF06(int f06) {
                F06 = f06;
            }

            public int getF07() {
                return F07;
            }

            public void setF07(int f07) {
                F07 = f07;
            }

            public int getF08() {
                return F08;
            }

            public void setF08(int f08) {
                F08 = f08;
            }

            public int getF09() {
                return F09;
            }

            public void setF09(int f09) {
                F09 = f09;
            }

            public int getSUMSMALL() {
                return SUMSMALL;
            }

            public void setSUMSMALL(int SUMSMALL) {
                this.SUMSMALL = SUMSMALL;
            }

            public int getF02() {
                return F02;
            }

            public void setF02(int f02) {
                F02 = f02;
            }

            public int getF03() {
                return F03;
            }

            public void setF03(int f03) {
                F03 = f03;
            }

            public int getF04() {
                return F04;
            }

            public void setF04(int f04) {
                F04 = f04;
            }

            public int getF05() {
                return F05;
            }

            public void setF05(int f05) {
                F05 = f05;
            }

            public int getSUMODD() {
                return SUMODD;
            }

            public void setSUMODD(int SUMODD) {
                this.SUMODD = SUMODD;
            }

            public int getF10() {
                return F10;
            }

            public void setF10(int f10) {
                F10 = f10;
            }

            public int getS01() {
                return S01;
            }

            public void setS01(int s01) {
                S01 = s01;
            }

            public int getS02() {
                return S02;
            }

            public void setS02(int s02) {
                S02 = s02;
            }

            public int getS03() {
                return S03;
            }

            public void setS03(int s03) {
                S03 = s03;
            }

            public int getS04() {
                return S04;
            }

            public void setS04(int s04) {
                S04 = s04;
            }

            public int getS05() {
                return S05;
            }

            public void setS05(int s05) {
                S05 = s05;
            }

            public int getS06() {
                return S06;
            }

            public void setS06(int s06) {
                S06 = s06;
            }

            public int getS07() {
                return S07;
            }

            public void setS07(int s07) {
                S07 = s07;
            }

            public int getSUMEVEN() {
                return SUMEVEN;
            }

            public void setSUMEVEN(int SUMEVEN) {
                this.SUMEVEN = SUMEVEN;
            }

            public int getS08() {
                return S08;
            }

            public void setS08(int s08) {
                S08 = s08;
            }

            public int getS09() {
                return S09;
            }

            public void setS09(int s09) {
                S09 = s09;
            }

            public int getSUMBIG() {
                return SUMBIG;
            }

            public void setSUMBIG(int SUMBIG) {
                this.SUMBIG = SUMBIG;
            }

            public int getDRAWCODE() {
                return DRAWCODE;
            }

            public void setDRAWCODE(int DRAWCODE) {
                this.DRAWCODE = DRAWCODE;
            }
        }
    }

    public static class ZsBean {
        /**
         * ISSUE : 677737
         * S10 : 12
         * F01 : 5
         * F06 : 0
         * SUMVAL : 14
         * F07 : 9
         * F08 : 17
         * SUMSMALL : 1
         * F09 : 2
         * F02 : 12
         * F03 : 4
         * F04 : 1
         * F05 : 76
         * SUMODD : 1
         * F10 : 3
         * S01 : 2
         * S02 : 7
         * S03 : 3
         * S04 : 13
         * S05 : 34
         * S06 : 8
         * S07 : 1
         * SUMEVEN : 0
         * S08 : 0
         * S09 : 5
         * SUMBIG : 0
         * DRAWCODE : 06,08,04,02,05,03,09,01,10,07
         */

        private String ISSUE;
        private int S10;
        private int F01;
        private int F06;
        private int SUMVAL;
        private int F07;
        private int F08;
        private int SUMSMALL;
        private int F09;
        private int F02;
        private int F03;
        private int F04;
        private int F05;
        private int SUMODD;
        private int F10;
        private int S01;
        private int S02;
        private int S03;
        private int S04;
        private int S05;
        private int S06;
        private int S07;
        private int SUMEVEN;
        private int S08;
        private int S09;
        private int SUMBIG;
        private String DRAWCODE;

        public String getISSUE() {
            return ISSUE;
        }

        public void setISSUE(String ISSUE) {
            this.ISSUE = ISSUE;
        }

        public int getS10() {
            return S10;
        }

        public void setS10(int S10) {
            this.S10 = S10;
        }

        public int getF01() {
            return F01;
        }

        public void setF01(int F01) {
            this.F01 = F01;
        }

        public int getF06() {
            return F06;
        }

        public void setF06(int F06) {
            this.F06 = F06;
        }

        public int getSUMVAL() {
            return SUMVAL;
        }

        public void setSUMVAL(int SUMVAL) {
            this.SUMVAL = SUMVAL;
        }

        public int getF07() {
            return F07;
        }

        public void setF07(int F07) {
            this.F07 = F07;
        }

        public int getF08() {
            return F08;
        }

        public void setF08(int F08) {
            this.F08 = F08;
        }

        public int getSUMSMALL() {
            return SUMSMALL;
        }

        public void setSUMSMALL(int SUMSMALL) {
            this.SUMSMALL = SUMSMALL;
        }

        public int getF09() {
            return F09;
        }

        public void setF09(int F09) {
            this.F09 = F09;
        }

        public int getF02() {
            return F02;
        }

        public void setF02(int F02) {
            this.F02 = F02;
        }

        public int getF03() {
            return F03;
        }

        public void setF03(int F03) {
            this.F03 = F03;
        }

        public int getF04() {
            return F04;
        }

        public void setF04(int F04) {
            this.F04 = F04;
        }

        public int getF05() {
            return F05;
        }

        public void setF05(int F05) {
            this.F05 = F05;
        }

        public int getSUMODD() {
            return SUMODD;
        }

        public void setSUMODD(int SUMODD) {
            this.SUMODD = SUMODD;
        }

        public int getF10() {
            return F10;
        }

        public void setF10(int F10) {
            this.F10 = F10;
        }

        public int getS01() {
            return S01;
        }

        public void setS01(int S01) {
            this.S01 = S01;
        }

        public int getS02() {
            return S02;
        }

        public void setS02(int S02) {
            this.S02 = S02;
        }

        public int getS03() {
            return S03;
        }

        public void setS03(int S03) {
            this.S03 = S03;
        }

        public int getS04() {
            return S04;
        }

        public void setS04(int S04) {
            this.S04 = S04;
        }

        public int getS05() {
            return S05;
        }

        public void setS05(int S05) {
            this.S05 = S05;
        }

        public int getS06() {
            return S06;
        }

        public void setS06(int S06) {
            this.S06 = S06;
        }

        public int getS07() {
            return S07;
        }

        public void setS07(int S07) {
            this.S07 = S07;
        }

        public int getSUMEVEN() {
            return SUMEVEN;
        }

        public void setSUMEVEN(int SUMEVEN) {
            this.SUMEVEN = SUMEVEN;
        }

        public int getS08() {
            return S08;
        }

        public void setS08(int S08) {
            this.S08 = S08;
        }

        public int getS09() {
            return S09;
        }

        public void setS09(int S09) {
            this.S09 = S09;
        }

        public int getSUMBIG() {
            return SUMBIG;
        }

        public void setSUMBIG(int SUMBIG) {
            this.SUMBIG = SUMBIG;
        }

        public String getDRAWCODE() {
            return DRAWCODE;
        }

        public void setDRAWCODE(String DRAWCODE) {
            this.DRAWCODE = DRAWCODE;
        }
    }
}
