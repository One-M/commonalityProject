package com.ybf.lottery.model.bean.locationtrendbean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/21.
 * Use:定位走势的接收实体
 */

public class LocationTrendBean {

    /**
     * zs : [{"ISSUE":"677731","N10":9,"AMP":0,"RANK":1,"AMP1":20,"N01":2,"SMALL":2,"AMP0":0,"AMP3":4,"AMP2":3,"ODD":2,"DRAWCODE":"06,03,01,05,02,09,07,10,08,04","EVEN":0,"N05":70,"AMP4":5,"N04":12,"AMP5":1,"N03":16,"AMP6":2,"AMP7":10,"N02":6,"AMP8":8,"N09":4,"AMP9":9,"N08":11,"N07":3,"BIG":0,"N06":0},{"ISSUE":"677730","N10":8,"AMP":5,"RANK":1,"AMP1":19,"N01":1,"SMALL":1,"AMP0":25,"AMP3":3,"AMP2":2,"ODD":1,"DRAWCODE":"06,02,04,01,05,09,08,07,03,10","EVEN":0,"N05":69,"AMP4":4,"N04":11,"AMP5":0,"N03":15,"AMP6":1,"AMP7":9,"N02":5,"AMP8":7,"N09":3,"AMP9":8,"N08":10,"N07":2,"BIG":0,"N06":0},{"ISSUE":"677729","N10":7,"AMP":6,"RANK":1,"AMP1":18,"N01":0,"SMALL":0,"AMP0":24,"AMP3":2,"AMP2":1,"ODD":0,"DRAWCODE":"01,06,05,08,07,02,03,04,09,10","EVEN":3,"N05":68,"AMP4":3,"N04":10,"AMP5":4,"N03":14,"AMP6":0,"AMP7":8,"N02":4,"AMP8":6,"N09":2,"AMP9":7,"N08":9,"N07":1,"BIG":1,"N06":3},{"ISSUE":"677728","N10":6,"AMP":2,"RANK":1,"AMP1":17,"N01":7,"SMALL":3,"AMP0":23,"AMP3":1,"AMP2":0,"ODD":0,"DRAWCODE":"07,01,04,03,05,09,10,02,06,08","EVEN":2,"N05":67,"AMP4":2,"N04":9,"AMP5":3,"N03":13,"AMP6":43,"AMP7":7,"N02":3,"AMP8":5,"N09":1,"AMP9":6,"N08":8,"N07":0,"BIG":0,"N06":2},{"ISSUE":"677727","N10":5,"AMP":3,"RANK":1,"AMP1":16,"N01":6,"SMALL":2,"AMP0":22,"AMP3":0,"AMP2":18,"ODD":0,"DRAWCODE":"09,02,10,05,08,07,04,03,06,01","EVEN":1,"N05":66,"AMP4":1,"N04":8,"AMP5":2,"N03":12,"AMP6":42,"AMP7":6,"N02":2,"AMP8":4,"N09":0,"AMP9":5,"N08":7,"N07":3,"BIG":0,"N06":1},{"ISSUE":"677726","N10":4,"AMP":4,"RANK":1,"AMP1":15,"N01":5,"SMALL":1,"AMP0":21,"AMP3":11,"AMP2":17,"ODD":2,"DRAWCODE":"06,02,09,05,03,07,10,01,04,08","EVEN":0,"N05":65,"AMP4":0,"N04":7,"AMP5":1,"N03":11,"AMP6":41,"AMP7":5,"N02":1,"AMP8":3,"N09":8,"AMP9":4,"N08":6,"N07":2,"BIG":0,"N06":0},{"ISSUE":"677725","N10":3,"AMP":5,"RANK":1,"AMP1":14,"N01":4,"SMALL":0,"AMP0":20,"AMP3":10,"AMP2":16,"ODD":1,"DRAWCODE":"02,10,04,03,08,01,09,07,05,06","EVEN":0,"N05":64,"AMP4":5,"N04":6,"AMP5":0,"N03":10,"AMP6":40,"AMP7":4,"N02":0,"AMP8":2,"N09":7,"AMP9":3,"N08":5,"N07":1,"BIG":1,"N06":11},{"ISSUE":"677724","N10":2,"AMP":5,"RANK":1,"AMP1":13,"N01":3,"SMALL":1,"AMP0":19,"AMP3":9,"AMP2":15,"ODD":0,"DRAWCODE":"07,04,08,09,02,06,03,01,10,05","EVEN":1,"N05":63,"AMP4":4,"N04":5,"AMP5":0,"N03":9,"AMP6":39,"AMP7":3,"N02":1,"AMP8":1,"N09":6,"AMP9":2,"N08":4,"N07":0,"BIG":0,"N06":10},{"ISSUE":"677723","N10":1,"AMP":8,"RANK":1,"AMP1":12,"N01":2,"SMALL":0,"AMP0":18,"AMP3":8,"AMP2":14,"ODD":2,"DRAWCODE":"02,07,03,01,05,06,08,04,10,09","EVEN":0,"N05":62,"AMP4":3,"N04":4,"AMP5":4,"N03":8,"AMP6":38,"AMP7":2,"N02":0,"AMP8":0,"N09":5,"AMP9":1,"N08":3,"N07":14,"BIG":1,"N06":9},{"ISSUE":"677722","N10":0,"AMP":9,"RANK":1,"AMP1":11,"N01":1,"SMALL":1,"AMP0":17,"AMP3":7,"AMP2":13,"ODD":1,"DRAWCODE":"10,06,04,09,08,01,03,05,07,02","EVEN":0,"N05":61,"AMP4":2,"N04":3,"AMP5":3,"N03":7,"AMP6":37,"AMP7":1,"N02":20,"AMP8":4,"N09":4,"AMP9":0,"N08":2,"N07":13,"BIG":0,"N06":8},{"ISSUE":"677721","N10":18,"AMP":7,"RANK":1,"AMP1":10,"N01":0,"SMALL":0,"AMP0":16,"AMP3":6,"AMP2":12,"ODD":0,"DRAWCODE":"01,04,07,03,09,02,05,08,06,10","EVEN":1,"N05":60,"AMP4":1,"N04":2,"AMP5":2,"N03":6,"AMP6":36,"AMP7":0,"N02":19,"AMP8":3,"N09":3,"AMP9":37,"N08":1,"N07":12,"BIG":1,"N06":7},{"ISSUE":"677720","N10":17,"AMP":4,"RANK":1,"AMP1":9,"N01":3,"SMALL":1,"AMP0":15,"AMP3":5,"AMP2":11,"ODD":2,"DRAWCODE":"08,03,07,02,05,09,01,06,10,04","EVEN":0,"N05":59,"AMP4":0,"N04":1,"AMP5":1,"N03":5,"AMP6":35,"AMP7":3,"N02":18,"AMP8":2,"N09":2,"AMP9":36,"N08":0,"N07":11,"BIG":0,"N06":6},{"ISSUE":"677719","N10":16,"AMP":5,"RANK":1,"AMP1":8,"N01":2,"SMALL":0,"AMP0":14,"AMP3":4,"AMP2":10,"ODD":1,"DRAWCODE":"04,10,06,09,01,08,02,07,03,05","EVEN":0,"N05":58,"AMP4":23,"N04":0,"AMP5":0,"N03":4,"AMP6":34,"AMP7":2,"N02":17,"AMP8":1,"N09":1,"AMP9":35,"N08":3,"N07":10,"BIG":1,"N06":5},{"ISSUE":"677718","N10":15,"AMP":8,"RANK":1,"AMP1":7,"N01":1,"SMALL":1,"AMP0":13,"AMP3":3,"AMP2":9,"ODD":0,"DRAWCODE":"09,07,01,03,02,08,05,04,06,10","EVEN":2,"N05":57,"AMP4":22,"N04":8,"AMP5":2,"N03":3,"AMP6":33,"AMP7":1,"N02":16,"AMP8":0,"N09":0,"AMP9":34,"N08":2,"N07":9,"BIG":0,"N06":4},{"ISSUE":"677717","N10":14,"AMP":7,"RANK":1,"AMP1":6,"N01":0,"SMALL":0,"AMP0":12,"AMP3":2,"AMP2":8,"ODD":0,"DRAWCODE":"01,07,09,10,08,02,06,04,05,03","EVEN":1,"N05":56,"AMP4":21,"N04":7,"AMP5":1,"N03":2,"AMP6":32,"AMP7":0,"N02":15,"AMP8":14,"N09":4,"AMP9":33,"N08":1,"N07":8,"BIG":1,"N06":3},{"ISSUE":"677716","N10":13,"AMP":5,"RANK":1,"AMP1":5,"N01":32,"SMALL":1,"AMP0":11,"AMP3":1,"AMP2":7,"ODD":1,"DRAWCODE":"08,04,06,03,07,10,01,09,05,02","EVEN":0,"N05":55,"AMP4":20,"N04":6,"AMP5":0,"N03":1,"AMP6":31,"AMP7":12,"N02":14,"AMP8":13,"N09":3,"AMP9":32,"N08":0,"N07":7,"BIG":0,"N06":2},{"ISSUE":"677715","N10":12,"AMP":3,"RANK":1,"AMP1":4,"N01":31,"SMALL":0,"AMP0":10,"AMP3":0,"AMP2":6,"ODD":0,"DRAWCODE":"03,04,08,10,09,02,06,07,01,05","EVEN":1,"N05":54,"AMP4":19,"N04":5,"AMP5":7,"N03":0,"AMP6":30,"AMP7":11,"N02":13,"AMP8":12,"N09":2,"AMP9":31,"N08":20,"N07":6,"BIG":1,"N06":1},{"ISSUE":"677714","N10":11,"AMP":3,"RANK":1,"AMP1":3,"N01":30,"SMALL":3,"AMP0":9,"AMP3":0,"AMP2":5,"ODD":1,"DRAWCODE":"06,02,04,01,10,09,03,07,08,05","EVEN":0,"N05":53,"AMP4":18,"N04":4,"AMP5":6,"N03":3,"AMP6":29,"AMP7":10,"N02":12,"AMP8":11,"N09":1,"AMP9":30,"N08":19,"N07":5,"BIG":0,"N06":0},{"ISSUE":"677713","N10":10,"AMP":3,"RANK":1,"AMP1":2,"N01":29,"SMALL":2,"AMP0":8,"AMP3":0,"AMP2":4,"ODD":0,"DRAWCODE":"09,04,02,01,03,08,10,07,06,05","EVEN":1,"N05":52,"AMP4":17,"N04":3,"AMP5":5,"N03":2,"AMP6":28,"AMP7":9,"N02":11,"AMP8":10,"N09":0,"AMP9":29,"N08":18,"N07":4,"BIG":0,"N06":1},{"ISSUE":"677712","N10":9,"AMP":3,"RANK":1,"AMP1":1,"N01":28,"SMALL":1,"AMP0":7,"AMP3":0,"AMP2":3,"ODD":1,"DRAWCODE":"06,09,05,07,03,08,02,01,10,04","EVEN":0,"N05":51,"AMP4":16,"N04":2,"AMP5":4,"N03":1,"AMP6":27,"AMP7":8,"N02":10,"AMP8":9,"N09":4,"AMP9":28,"N08":17,"N07":3,"BIG":0,"N06":0},{"ISSUE":"677711","N10":8,"AMP":1,"RANK":1,"AMP1":0,"N01":27,"SMALL":0,"AMP0":6,"AMP3":1,"AMP2":2,"ODD":0,"DRAWCODE":"03,08,01,07,09,04,05,10,02,06","EVEN":1,"N05":50,"AMP4":15,"N04":1,"AMP5":3,"N03":0,"AMP6":26,"AMP7":7,"N02":9,"AMP8":8,"N09":3,"AMP9":27,"N08":16,"N07":2,"BIG":2,"N06":5},{"ISSUE":"677710","N10":7,"AMP":3,"RANK":1,"AMP1":11,"N01":26,"SMALL":0,"AMP0":5,"AMP3":0,"AMP2":1,"ODD":1,"DRAWCODE":"04,03,09,02,01,06,07,05,10,08","EVEN":0,"N05":49,"AMP4":14,"N04":0,"AMP5":2,"N03":5,"AMP6":25,"AMP7":6,"N02":8,"AMP8":7,"N09":2,"AMP9":26,"N08":15,"N07":1,"BIG":1,"N06":4},{"ISSUE":"677709","N10":6,"AMP":2,"RANK":1,"AMP1":10,"N01":25,"SMALL":2,"AMP0":4,"AMP3":3,"AMP2":0,"ODD":0,"DRAWCODE":"07,10,04,01,09,02,06,05,03,08","EVEN":2,"N05":48,"AMP4":13,"N04":2,"AMP5":1,"N03":4,"AMP6":24,"AMP7":5,"N02":7,"AMP8":6,"N09":1,"AMP9":25,"N08":14,"N07":0,"BIG":0,"N06":3},{"ISSUE":"677708","N10":5,"AMP":5,"RANK":1,"AMP1":9,"N01":24,"SMALL":1,"AMP0":3,"AMP3":2,"AMP2":1,"ODD":0,"DRAWCODE":"09,08,04,03,01,05,06,02,10,07","EVEN":1,"N05":47,"AMP4":12,"N04":1,"AMP5":0,"N03":3,"AMP6":23,"AMP7":4,"N02":6,"AMP8":5,"N09":0,"AMP9":24,"N08":13,"N07":18,"BIG":0,"N06":2},{"ISSUE":"677707","N10":4,"AMP":2,"RANK":1,"AMP1":8,"N01":23,"SMALL":0,"AMP0":2,"AMP3":1,"AMP2":0,"ODD":2,"DRAWCODE":"04,01,09,08,10,03,06,07,02,05","EVEN":0,"N05":46,"AMP4":11,"N04":0,"AMP5":7,"N03":2,"AMP6":22,"AMP7":3,"N02":5,"AMP8":4,"N09":6,"AMP9":23,"N08":12,"N07":17,"BIG":1,"N06":1},{"ISSUE":"677706","N10":3,"AMP":3,"RANK":1,"AMP1":7,"N01":22,"SMALL":1,"AMP0":1,"AMP3":0,"AMP2":9,"ODD":1,"DRAWCODE":"06,07,08,01,09,10,05,02,04,03","EVEN":0,"N05":45,"AMP4":10,"N04":7,"AMP5":6,"N03":1,"AMP6":21,"AMP7":2,"N02":4,"AMP8":3,"N09":5,"AMP9":22,"N08":11,"N07":16,"BIG":0,"N06":0},{"ISSUE":"677705","N10":2,"AMP":0,"RANK":1,"AMP1":6,"N01":21,"SMALL":0,"AMP0":0,"AMP3":14,"AMP2":8,"ODD":0,"DRAWCODE":"03,06,04,01,07,02,05,10,08,09","EVEN":2,"N05":44,"AMP4":9,"N04":6,"AMP5":5,"N03":0,"AMP6":20,"AMP7":1,"N02":3,"AMP8":2,"N09":4,"AMP9":21,"N08":10,"N07":15,"BIG":2,"N06":29},{"ISSUE":"677704","N10":1,"AMP":7,"RANK":1,"AMP1":5,"N01":20,"SMALL":0,"AMP0":3,"AMP3":13,"AMP2":7,"ODD":0,"DRAWCODE":"03,02,07,04,05,09,06,10,08,01","EVEN":1,"N05":43,"AMP4":8,"N04":5,"AMP5":4,"N03":0,"AMP6":19,"AMP7":0,"N02":2,"AMP8":1,"N09":3,"AMP9":20,"N08":9,"N07":14,"BIG":1,"N06":28},{"ISSUE":"677703","N10":0,"AMP":8,"RANK":1,"AMP1":4,"N01":19,"SMALL":1,"AMP0":2,"AMP3":12,"AMP2":6,"ODD":2,"DRAWCODE":"10,05,09,08,04,01,07,06,02,03","EVEN":0,"N05":42,"AMP4":7,"N04":4,"AMP5":3,"N03":5,"AMP6":18,"AMP7":1,"N02":1,"AMP8":0,"N09":2,"AMP9":19,"N08":8,"N07":13,"BIG":0,"N06":27},{"ISSUE":"677702","N10":9,"AMP":7,"RANK":1,"AMP1":3,"N01":18,"SMALL":0,"AMP0":1,"AMP3":11,"AMP2":5,"ODD":1,"DRAWCODE":"02,01,06,09,04,10,05,07,03,08","EVEN":0,"N05":41,"AMP4":6,"N04":3,"AMP5":2,"N03":4,"AMP6":17,"AMP7":0,"N02":0,"AMP8":37,"N09":1,"AMP9":18,"N08":7,"N07":12,"BIG":1,"N06":26}]
     * code : 200
     * tj : {"occ2":{"ISSUE":0,"N10":0,"AMP":0,"RANK":0,"AMP1":0,"AMP0":0,"SMALL":0,"N01":0,"AMP3":0,"AMP2":0,"ODD":0,"DRAWCODE":0,"EVEN":0,"N05":0,"AMP4":0,"N04":0,"AMP5":0,"N03":0,"AMP6":0,"AMP7":0,"N02":0,"AMP8":0,"N09":0,"N08":0,"AMP9":0,"BIG":0,"N07":0,"N06":0},"avgMiss":{"ISSUE":0,"N10":12,"AMP":4,"RANK":1,"AMP1":15,"AMP0":9,"SMALL":1,"N01":11,"AMP3":4,"AMP2":7,"ODD":1,"DRAWCODE":0,"EVEN":0,"N05":70,"AMP4":11,"N04":7,"AMP5":3,"N03":5,"AMP6":22,"AMP7":5,"N02":6,"AMP8":15,"N09":5,"N08":11,"AMP9":23,"BIG":0,"N07":9,"N06":7},"lastMiss":{"ISSUE":0,"N10":9,"AMP":0,"RANK":1,"AMP1":20,"AMP0":0,"SMALL":2,"N01":2,"AMP3":4,"AMP2":3,"ODD":2,"DRAWCODE":0,"EVEN":0,"N05":70,"AMP4":5,"N04":12,"AMP5":1,"N03":16,"AMP6":2,"AMP7":10,"N02":6,"AMP8":8,"N09":4,"N08":11,"AMP9":9,"BIG":0,"N07":3,"N06":0},"maxCont":{"ISSUE":0,"N10":1,"AMP":1,"RANK":0,"AMP1":1,"AMP0":1,"SMALL":2,"N01":1,"AMP3":4,"AMP2":1,"ODD":3,"DRAWCODE":0,"EVEN":2,"N05":0,"AMP4":1,"N04":1,"AMP5":2,"N03":2,"AMP6":1,"AMP7":1,"N02":1,"AMP8":1,"N09":1,"N08":1,"AMP9":1,"BIG":3,"N07":1,"N06":2},"probability":{"ISSUE":0,"N10":6666,"AMP":6666,"RANK":0,"AMP1":3333,"N01":10000,"SMALL":43333,"AMP0":6666,"AMP3":23333,"AMP2":10000,"ODD":46666,"DRAWCODE":0,"EVEN":53333,"N05":0,"AMP4":6666,"N04":10000,"AMP5":20000,"N03":13333,"AMP6":3333,"AMP7":13333,"N02":10000,"AMP8":10000,"N09":13333,"AMP9":3333,"N08":6666,"N07":10000,"BIG":56666,"N06":20000},"maxMiss":{"ISSUE":0,"N10":18,"AMP":9,"RANK":1,"AMP1":20,"AMP0":25,"SMALL":3,"N01":32,"AMP3":14,"AMP2":18,"ODD":2,"DRAWCODE":0,"EVEN":3,"N05":70,"AMP4":23,"N04":12,"AMP5":7,"N03":16,"AMP6":43,"AMP7":12,"N02":20,"AMP8":37,"N09":8,"N08":20,"AMP9":37,"BIG":2,"N07":18,"N06":29},"occ":{"ISSUE":0,"N10":2,"AMP":2,"RANK":0,"AMP1":1,"AMP0":2,"SMALL":13,"N01":3,"AMP3":7,"AMP2":3,"ODD":14,"DRAWCODE":0,"EVEN":16,"N05":0,"AMP4":2,"N04":3,"AMP5":6,"N03":4,"AMP6":1,"AMP7":4,"N02":3,"AMP8":3,"N09":4,"N08":2,"AMP9":1,"BIG":17,"N07":3,"N06":6}}
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
         * occ2 : {"ISSUE":0,"N10":0,"AMP":0,"RANK":0,"AMP1":0,"AMP0":0,"SMALL":0,"N01":0,"AMP3":0,"AMP2":0,"ODD":0,"DRAWCODE":0,"EVEN":0,"N05":0,"AMP4":0,"N04":0,"AMP5":0,"N03":0,"AMP6":0,"AMP7":0,"N02":0,"AMP8":0,"N09":0,"N08":0,"AMP9":0,"BIG":0,"N07":0,"N06":0}
         * avgMiss : {"ISSUE":0,"N10":12,"AMP":4,"RANK":1,"AMP1":15,"AMP0":9,"SMALL":1,"N01":11,"AMP3":4,"AMP2":7,"ODD":1,"DRAWCODE":0,"EVEN":0,"N05":70,"AMP4":11,"N04":7,"AMP5":3,"N03":5,"AMP6":22,"AMP7":5,"N02":6,"AMP8":15,"N09":5,"N08":11,"AMP9":23,"BIG":0,"N07":9,"N06":7}
         * lastMiss : {"ISSUE":0,"N10":9,"AMP":0,"RANK":1,"AMP1":20,"AMP0":0,"SMALL":2,"N01":2,"AMP3":4,"AMP2":3,"ODD":2,"DRAWCODE":0,"EVEN":0,"N05":70,"AMP4":5,"N04":12,"AMP5":1,"N03":16,"AMP6":2,"AMP7":10,"N02":6,"AMP8":8,"N09":4,"N08":11,"AMP9":9,"BIG":0,"N07":3,"N06":0}
         * maxCont : {"ISSUE":0,"N10":1,"AMP":1,"RANK":0,"AMP1":1,"AMP0":1,"SMALL":2,"N01":1,"AMP3":4,"AMP2":1,"ODD":3,"DRAWCODE":0,"EVEN":2,"N05":0,"AMP4":1,"N04":1,"AMP5":2,"N03":2,"AMP6":1,"AMP7":1,"N02":1,"AMP8":1,"N09":1,"N08":1,"AMP9":1,"BIG":3,"N07":1,"N06":2}
         * probability : {"ISSUE":0,"N10":6666,"AMP":6666,"RANK":0,"AMP1":3333,"N01":10000,"SMALL":43333,"AMP0":6666,"AMP3":23333,"AMP2":10000,"ODD":46666,"DRAWCODE":0,"EVEN":53333,"N05":0,"AMP4":6666,"N04":10000,"AMP5":20000,"N03":13333,"AMP6":3333,"AMP7":13333,"N02":10000,"AMP8":10000,"N09":13333,"AMP9":3333,"N08":6666,"N07":10000,"BIG":56666,"N06":20000}
         * maxMiss : {"ISSUE":0,"N10":18,"AMP":9,"RANK":1,"AMP1":20,"AMP0":25,"SMALL":3,"N01":32,"AMP3":14,"AMP2":18,"ODD":2,"DRAWCODE":0,"EVEN":3,"N05":70,"AMP4":23,"N04":12,"AMP5":7,"N03":16,"AMP6":43,"AMP7":12,"N02":20,"AMP8":37,"N09":8,"N08":20,"AMP9":37,"BIG":2,"N07":18,"N06":29}
         * occ : {"ISSUE":0,"N10":2,"AMP":2,"RANK":0,"AMP1":1,"AMP0":2,"SMALL":13,"N01":3,"AMP3":7,"AMP2":3,"ODD":14,"DRAWCODE":0,"EVEN":16,"N05":0,"AMP4":2,"N04":3,"AMP5":6,"N03":4,"AMP6":1,"AMP7":4,"N02":3,"AMP8":3,"N09":4,"N08":2,"AMP9":1,"BIG":17,"N07":3,"N06":6}
         */

        private LocationTJBean occ2;
        private LocationTJBean avgMiss;
        private LocationTJBean lastMiss;
        private LocationTJBean maxCont;
        private LocationTJBean probability;
        private LocationTJBean maxMiss;
        private LocationTJBean occ;

        public LocationTJBean getOcc2() {
            return occ2;
        }

        public void setOcc2(LocationTJBean occ2) {
            this.occ2 = occ2;
        }

        public LocationTJBean getAvgMiss() {
            return avgMiss;
        }

        public void setAvgMiss(LocationTJBean avgMiss) {
            this.avgMiss = avgMiss;
        }

        public LocationTJBean getLastMiss() {
            return lastMiss;
        }

        public void setLastMiss(LocationTJBean lastMiss) {
            this.lastMiss = lastMiss;
        }

        public LocationTJBean getMaxCont() {
            return maxCont;
        }

        public void setMaxCont(LocationTJBean maxCont) {
            this.maxCont = maxCont;
        }

        public LocationTJBean getProbability() {
            return probability;
        }

        public void setProbability(LocationTJBean probability) {
            this.probability = probability;
        }

        public LocationTJBean getMaxMiss() {
            return maxMiss;
        }

        public void setMaxMiss(LocationTJBean maxMiss) {
            this.maxMiss = maxMiss;
        }

        public LocationTJBean getOcc() {
            return occ;
        }

        public void setOcc(LocationTJBean occ) {
            this.occ = occ;
        }

        public static class LocationTJBean{
            /**
             * ISSUE : 0
             * N10 : 2
             * AMP : 2
             * RANK : 0
             * AMP1 : 1
             * AMP0 : 2
             * SMALL : 13
             * N01 : 3
             * AMP3 : 7
             * AMP2 : 3
             * ODD : 14
             * DRAWCODE : 0
             * EVEN : 16
             * N05 : 0
             * AMP4 : 2
             * N04 : 3
             * AMP5 : 6
             * N03 : 4
             * AMP6 : 1
             * AMP7 : 4
             * N02 : 3
             * AMP8 : 3
             * N09 : 4
             * N08 : 2
             * AMP9 : 1
             * BIG : 17
             * N07 : 3
             * N06 : 6
             */

            private int ISSUE;
            private int N10;
            private int AMP;
            private int RANK;
            private int AMP1;
            private int AMP0;
            private int SMALL;
            private int N01;
            private int AMP3;
            private int AMP2;
            private int ODD;
            private int DRAWCODE;
            private int EVEN;
            private int N05;
            private int AMP4;
            private int N04;
            private int AMP5;
            private int N03;
            private int AMP6;
            private int AMP7;
            private int N02;
            private int AMP8;
            private int N09;
            private int N08;
            private int AMP9;
            private int BIG;
            private int N07;
            private int N06;

            public int getISSUE() {
                return ISSUE;
            }

            public void setISSUE(int ISSUE) {
                this.ISSUE = ISSUE;
            }

            public int getN10() {
                return N10;
            }

            public void setN10(int n10) {
                N10 = n10;
            }

            public int getAMP() {
                return AMP;
            }

            public void setAMP(int AMP) {
                this.AMP = AMP;
            }

            public int getRANK() {
                return RANK;
            }

            public void setRANK(int RANK) {
                this.RANK = RANK;
            }

            public int getAMP1() {
                return AMP1;
            }

            public void setAMP1(int AMP1) {
                this.AMP1 = AMP1;
            }

            public int getAMP0() {
                return AMP0;
            }

            public void setAMP0(int AMP0) {
                this.AMP0 = AMP0;
            }

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getN01() {
                return N01;
            }

            public void setN01(int n01) {
                N01 = n01;
            }

            public int getAMP3() {
                return AMP3;
            }

            public void setAMP3(int AMP3) {
                this.AMP3 = AMP3;
            }

            public int getAMP2() {
                return AMP2;
            }

            public void setAMP2(int AMP2) {
                this.AMP2 = AMP2;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }

            public int getDRAWCODE() {
                return DRAWCODE;
            }

            public void setDRAWCODE(int DRAWCODE) {
                this.DRAWCODE = DRAWCODE;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getN05() {
                return N05;
            }

            public void setN05(int n05) {
                N05 = n05;
            }

            public int getAMP4() {
                return AMP4;
            }

            public void setAMP4(int AMP4) {
                this.AMP4 = AMP4;
            }

            public int getN04() {
                return N04;
            }

            public void setN04(int n04) {
                N04 = n04;
            }

            public int getAMP5() {
                return AMP5;
            }

            public void setAMP5(int AMP5) {
                this.AMP5 = AMP5;
            }

            public int getN03() {
                return N03;
            }

            public void setN03(int n03) {
                N03 = n03;
            }

            public int getAMP6() {
                return AMP6;
            }

            public void setAMP6(int AMP6) {
                this.AMP6 = AMP6;
            }

            public int getAMP7() {
                return AMP7;
            }

            public void setAMP7(int AMP7) {
                this.AMP7 = AMP7;
            }

            public int getN02() {
                return N02;
            }

            public void setN02(int n02) {
                N02 = n02;
            }

            public int getAMP8() {
                return AMP8;
            }

            public void setAMP8(int AMP8) {
                this.AMP8 = AMP8;
            }

            public int getN09() {
                return N09;
            }

            public void setN09(int n09) {
                N09 = n09;
            }

            public int getN08() {
                return N08;
            }

            public void setN08(int n08) {
                N08 = n08;
            }

            public int getAMP9() {
                return AMP9;
            }

            public void setAMP9(int AMP9) {
                this.AMP9 = AMP9;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getN07() {
                return N07;
            }

            public void setN07(int n07) {
                N07 = n07;
            }

            public int getN06() {
                return N06;
            }

            public void setN06(int n06) {
                N06 = n06;
            }
        }
    }

    public static class ZsBean {
        /**
         * ISSUE : 677731
         * N10 : 9
         * AMP : 0
         * RANK : 1
         * AMP1 : 20
         * N01 : 2
         * SMALL : 2
         * AMP0 : 0
         * AMP3 : 4
         * AMP2 : 3
         * ODD : 2
         * DRAWCODE : 06,03,01,05,02,09,07,10,08,04
         * EVEN : 0
         * N05 : 70
         * AMP4 : 5
         * N04 : 12
         * AMP5 : 1
         * N03 : 16
         * AMP6 : 2
         * AMP7 : 10
         * N02 : 6
         * AMP8 : 8
         * N09 : 4
         * AMP9 : 9
         * N08 : 11
         * N07 : 3
         * BIG : 0
         * N06 : 0
         */

        private String ISSUE;
        private int N10;
        private int AMP;
        private int RANK;
        private int AMP1;
        private int N01;
        private int SMALL;
        private int AMP0;
        private int AMP3;
        private int AMP2;
        private int ODD;
        private String DRAWCODE;
        private int EVEN;
        private int N05;
        private int AMP4;
        private int N04;
        private int AMP5;
        private int N03;
        private int AMP6;
        private int AMP7;
        private int N02;
        private int AMP8;
        private int N09;
        private int AMP9;
        private int N08;
        private int N07;
        private int BIG;
        private int N06;

        public String getISSUE() {
            return ISSUE;
        }

        public void setISSUE(String ISSUE) {
            this.ISSUE = ISSUE;
        }

        public int getN10() {
            return N10;
        }

        public void setN10(int N10) {
            this.N10 = N10;
        }

        public int getAMP() {
            return AMP;
        }

        public void setAMP(int AMP) {
            this.AMP = AMP;
        }

        public int getRANK() {
            return RANK;
        }

        public void setRANK(int RANK) {
            this.RANK = RANK;
        }

        public int getAMP1() {
            return AMP1;
        }

        public void setAMP1(int AMP1) {
            this.AMP1 = AMP1;
        }

        public int getN01() {
            return N01;
        }

        public void setN01(int N01) {
            this.N01 = N01;
        }

        public int getSMALL() {
            return SMALL;
        }

        public void setSMALL(int SMALL) {
            this.SMALL = SMALL;
        }

        public int getAMP0() {
            return AMP0;
        }

        public void setAMP0(int AMP0) {
            this.AMP0 = AMP0;
        }

        public int getAMP3() {
            return AMP3;
        }

        public void setAMP3(int AMP3) {
            this.AMP3 = AMP3;
        }

        public int getAMP2() {
            return AMP2;
        }

        public void setAMP2(int AMP2) {
            this.AMP2 = AMP2;
        }

        public int getODD() {
            return ODD;
        }

        public void setODD(int ODD) {
            this.ODD = ODD;
        }

        public String getDRAWCODE() {
            return DRAWCODE;
        }

        public void setDRAWCODE(String DRAWCODE) {
            this.DRAWCODE = DRAWCODE;
        }

        public int getEVEN() {
            return EVEN;
        }

        public void setEVEN(int EVEN) {
            this.EVEN = EVEN;
        }

        public int getN05() {
            return N05;
        }

        public void setN05(int N05) {
            this.N05 = N05;
        }

        public int getAMP4() {
            return AMP4;
        }

        public void setAMP4(int AMP4) {
            this.AMP4 = AMP4;
        }

        public int getN04() {
            return N04;
        }

        public void setN04(int N04) {
            this.N04 = N04;
        }

        public int getAMP5() {
            return AMP5;
        }

        public void setAMP5(int AMP5) {
            this.AMP5 = AMP5;
        }

        public int getN03() {
            return N03;
        }

        public void setN03(int N03) {
            this.N03 = N03;
        }

        public int getAMP6() {
            return AMP6;
        }

        public void setAMP6(int AMP6) {
            this.AMP6 = AMP6;
        }

        public int getAMP7() {
            return AMP7;
        }

        public void setAMP7(int AMP7) {
            this.AMP7 = AMP7;
        }

        public int getN02() {
            return N02;
        }

        public void setN02(int N02) {
            this.N02 = N02;
        }

        public int getAMP8() {
            return AMP8;
        }

        public void setAMP8(int AMP8) {
            this.AMP8 = AMP8;
        }

        public int getN09() {
            return N09;
        }

        public void setN09(int N09) {
            this.N09 = N09;
        }

        public int getAMP9() {
            return AMP9;
        }

        public void setAMP9(int AMP9) {
            this.AMP9 = AMP9;
        }

        public int getN08() {
            return N08;
        }

        public void setN08(int N08) {
            this.N08 = N08;
        }

        public int getN07() {
            return N07;
        }

        public void setN07(int N07) {
            this.N07 = N07;
        }

        public int getBIG() {
            return BIG;
        }

        public void setBIG(int BIG) {
            this.BIG = BIG;
        }

        public int getN06() {
            return N06;
        }

        public void setN06(int N06) {
            this.N06 = N06;
        }
    }
}
