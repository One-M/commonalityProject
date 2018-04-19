package com.ybf.lottery.model.bean.winnerrunnersumvaluebean;

import java.util.List;

/**
 * Created by XQyi on 2018/4/19.
 * Use: 冠亚和值的接口实体
 */

public class WinnerRunnerSumValueBean {
    /**
     * zs : [{"ISSUE":"677317","N7":8,"N6":50,"N9":12,"N8":1,"N10":3,"N11":0,"N12":30,"SUMEVEN":1,"SUMSMALL":0,"N3":5,"N5":13,"N4":23,"SUMBIG":2,"DRAWCODE":"05,06,02,03,08,04,01,07,09,10","N14":7,"N13":17,"N16":2,"N15":10,"N18":33,"SUMODD":0,"N17":42,"N19":41},{"ISSUE":"677316","N7":7,"N6":49,"N9":11,"N8":0,"N10":2,"N11":33,"N12":29,"SUMEVEN":0,"SUMSMALL":0,"N3":4,"N5":12,"N4":22,"SUMBIG":1,"DRAWCODE":"02,06,04,09,07,03,05,10,08,01","N14":6,"N13":16,"N16":1,"N15":9,"N18":32,"SUMODD":4,"N17":41,"N19":40},{"ISSUE":"677315","N7":6,"N6":48,"N9":10,"N8":22,"N10":1,"N11":32,"N12":28,"SUMEVEN":0,"SUMSMALL":1,"N3":3,"N5":11,"N4":21,"SUMBIG":0,"DRAWCODE":"07,09,06,08,10,02,04,05,03,01","N14":5,"N13":15,"N16":0,"N15":8,"N18":31,"SUMODD":3,"N17":40,"N19":39},{"ISSUE":"677314","N7":5,"N6":47,"N9":9,"N8":21,"N10":0,"N11":31,"N12":27,"SUMEVEN":0,"SUMSMALL":0,"N3":2,"N5":10,"N4":20,"SUMBIG":3,"DRAWCODE":"01,09,06,02,07,08,05,10,04,03","N14":4,"N13":14,"N16":3,"N15":7,"N18":30,"SUMODD":2,"N17":39,"N19":38},{"ISSUE":"677313","N7":4,"N6":46,"N9":8,"N8":20,"N10":0,"N11":30,"N12":26,"SUMEVEN":0,"SUMSMALL":0,"N3":1,"N5":9,"N4":19,"SUMBIG":2,"DRAWCODE":"01,09,10,04,08,03,02,05,06,07","N14":3,"N13":13,"N16":2,"N15":6,"N18":29,"SUMODD":1,"N17":38,"N19":37},{"ISSUE":"677312","N7":3,"N6":45,"N9":7,"N8":19,"N10":4,"N11":29,"N12":25,"SUMEVEN":1,"SUMSMALL":0,"N3":0,"N5":8,"N4":18,"SUMBIG":1,"DRAWCODE":"01,02,07,08,06,09,03,05,10,04","N14":2,"N13":12,"N16":1,"N15":5,"N18":28,"SUMODD":0,"N17":37,"N19":36},{"ISSUE":"677311","N7":2,"N6":44,"N9":6,"N8":18,"N10":3,"N11":28,"N12":24,"SUMEVEN":0,"SUMSMALL":2,"N3":16,"N5":7,"N4":17,"SUMBIG":0,"DRAWCODE":"07,09,08,06,10,05,01,03,04,02","N14":1,"N13":11,"N16":0,"N15":4,"N18":27,"SUMODD":2,"N17":36,"N19":35},{"ISSUE":"677310","N7":1,"N6":43,"N9":5,"N8":17,"N10":2,"N11":27,"N12":23,"SUMEVEN":0,"SUMSMALL":1,"N3":15,"N5":6,"N4":16,"SUMBIG":0,"DRAWCODE":"09,05,10,01,02,04,07,06,03,08","N14":0,"N13":10,"N16":81,"N15":3,"N18":26,"SUMODD":1,"N17":35,"N19":34},{"ISSUE":"677309","N7":0,"N6":42,"N9":4,"N8":16,"N10":1,"N11":26,"N12":22,"SUMEVEN":1,"SUMSMALL":0,"N3":14,"N5":5,"N4":15,"SUMBIG":2,"DRAWCODE":"05,02,04,07,06,09,08,10,01,03","N14":6,"N13":9,"N16":80,"N15":2,"N18":25,"SUMODD":0,"N17":34,"N19":33},{"ISSUE":"677308","N7":11,"N6":41,"N9":3,"N8":15,"N10":0,"N11":25,"N12":21,"SUMEVEN":0,"SUMSMALL":0,"N3":13,"N5":4,"N4":14,"SUMBIG":1,"DRAWCODE":"03,07,04,06,10,05,09,01,02,08","N14":5,"N13":8,"N16":79,"N15":1,"N18":24,"SUMODD":1,"N17":33,"N19":32},{"ISSUE":"677307","N7":10,"N6":40,"N9":2,"N8":14,"N10":5,"N11":24,"N12":20,"SUMEVEN":4,"SUMSMALL":2,"N3":12,"N5":3,"N4":13,"SUMBIG":0,"DRAWCODE":"10,05,01,06,09,02,08,04,03,07","N14":4,"N13":7,"N16":78,"N15":0,"N18":23,"SUMODD":0,"N17":32,"N19":31},{"ISSUE":"677306","N7":9,"N6":39,"N9":1,"N8":13,"N10":4,"N11":23,"N12":19,"SUMEVEN":3,"SUMSMALL":1,"N3":11,"N5":2,"N4":12,"SUMBIG":0,"DRAWCODE":"07,08,06,02,09,03,04,01,10,05","N14":3,"N13":6,"N16":77,"N15":0,"N18":22,"SUMODD":0,"N17":31,"N19":30},{"ISSUE":"677305","N7":8,"N6":38,"N9":0,"N8":12,"N10":3,"N11":22,"N12":18,"SUMEVEN":2,"SUMSMALL":0,"N3":10,"N5":1,"N4":11,"SUMBIG":2,"DRAWCODE":"08,01,09,03,10,06,05,07,04,02","N14":2,"N13":5,"N16":76,"N15":4,"N18":21,"SUMODD":0,"N17":30,"N19":29},{"ISSUE":"677304","N7":7,"N6":37,"N9":5,"N8":11,"N10":2,"N11":21,"N12":17,"SUMEVEN":1,"SUMSMALL":0,"N3":9,"N5":0,"N4":10,"SUMBIG":1,"DRAWCODE":"02,03,01,06,08,09,07,10,05,04","N14":1,"N13":4,"N16":75,"N15":3,"N18":20,"SUMODD":0,"N17":29,"N19":28},{"ISSUE":"677303","N7":6,"N6":36,"N9":4,"N8":10,"N10":1,"N11":20,"N12":16,"SUMEVEN":0,"SUMSMALL":1,"N3":8,"N5":14,"N4":9,"SUMBIG":0,"DRAWCODE":"10,04,03,05,08,02,09,07,06,01","N14":0,"N13":3,"N16":74,"N15":2,"N18":19,"SUMODD":2,"N17":28,"N19":27},{"ISSUE":"677302","N7":5,"N6":35,"N9":3,"N8":9,"N10":0,"N11":19,"N12":15,"SUMEVEN":0,"SUMSMALL":0,"N3":7,"N5":13,"N4":8,"SUMBIG":1,"DRAWCODE":"06,04,02,01,10,05,07,08,03,09","N14":25,"N13":2,"N16":73,"N15":1,"N18":18,"SUMODD":1,"N17":27,"N19":26},{"ISSUE":"677301","N7":4,"N6":34,"N9":2,"N8":8,"N10":11,"N11":18,"N12":14,"SUMEVEN":7,"SUMSMALL":2,"N3":6,"N5":12,"N4":7,"SUMBIG":0,"DRAWCODE":"05,10,09,02,08,01,07,04,03,06","N14":24,"N13":1,"N16":72,"N15":0,"N18":17,"SUMODD":0,"N17":26,"N19":25},{"ISSUE":"677300","N7":3,"N6":33,"N9":1,"N8":7,"N10":10,"N11":17,"N12":13,"SUMEVEN":6,"SUMSMALL":1,"N3":5,"N5":11,"N4":6,"SUMBIG":0,"DRAWCODE":"05,08,04,06,09,03,02,10,07,01","N14":23,"N13":0,"N16":71,"N15":20,"N18":16,"SUMODD":0,"N17":25,"N19":24},{"ISSUE":"677299","N7":2,"N6":32,"N9":0,"N8":6,"N10":9,"N11":16,"N12":12,"SUMEVEN":5,"SUMSMALL":0,"N3":4,"N5":10,"N4":5,"SUMBIG":3,"DRAWCODE":"07,02,04,10,05,03,01,09,06,08","N14":22,"N13":3,"N16":70,"N15":19,"N18":15,"SUMODD":0,"N17":24,"N19":23},{"ISSUE":"677298","N7":1,"N6":31,"N9":0,"N8":5,"N10":8,"N11":15,"N12":11,"SUMEVEN":4,"SUMSMALL":0,"N3":3,"N5":9,"N4":4,"SUMBIG":2,"DRAWCODE":"05,04,07,02,09,03,06,08,10,01","N14":21,"N13":2,"N16":69,"N15":18,"N18":14,"SUMODD":0,"N17":23,"N19":22},{"ISSUE":"677297","N7":0,"N6":30,"N9":5,"N8":4,"N10":7,"N11":14,"N12":10,"SUMEVEN":3,"SUMSMALL":0,"N3":2,"N5":8,"N4":3,"SUMBIG":1,"DRAWCODE":"05,02,09,06,07,01,10,04,08,03","N14":20,"N13":1,"N16":68,"N15":17,"N18":13,"SUMODD":0,"N17":22,"N19":21},{"ISSUE":"677296","N7":26,"N6":29,"N9":4,"N8":3,"N10":6,"N11":13,"N12":9,"SUMEVEN":2,"SUMSMALL":1,"N3":1,"N5":7,"N4":2,"SUMBIG":0,"DRAWCODE":"07,06,02,01,08,03,05,09,04,10","N14":19,"N13":0,"N16":67,"N15":16,"N18":12,"SUMODD":0,"N17":21,"N19":20},{"ISSUE":"677295","N7":25,"N6":28,"N9":3,"N8":2,"N10":5,"N11":12,"N12":8,"SUMEVEN":1,"SUMSMALL":0,"N3":0,"N5":6,"N4":1,"SUMBIG":4,"DRAWCODE":"02,01,08,03,07,06,05,09,04,10","N14":18,"N13":4,"N16":66,"N15":15,"N18":11,"SUMODD":0,"N17":20,"N19":19},{"ISSUE":"677294","N7":24,"N6":27,"N9":2,"N8":1,"N10":4,"N11":11,"N12":7,"SUMEVEN":0,"SUMSMALL":0,"N3":48,"N5":5,"N4":0,"SUMBIG":3,"DRAWCODE":"03,01,09,10,02,04,05,06,07,08","N14":17,"N13":3,"N16":65,"N15":14,"N18":10,"SUMODD":2,"N17":19,"N19":18},{"ISSUE":"677293","N7":23,"N6":26,"N9":1,"N8":0,"N10":3,"N11":10,"N12":6,"SUMEVEN":0,"SUMSMALL":0,"N3":47,"N5":4,"N4":5,"SUMBIG":2,"DRAWCODE":"07,01,02,04,05,09,10,03,08,06","N14":16,"N13":2,"N16":64,"N15":13,"N18":9,"SUMODD":1,"N17":18,"N19":17},{"ISSUE":"677292","N7":22,"N6":25,"N9":0,"N8":11,"N10":2,"N11":9,"N12":5,"SUMEVEN":2,"SUMSMALL":0,"N3":46,"N5":3,"N4":4,"SUMBIG":1,"DRAWCODE":"07,02,09,03,10,04,08,01,06,05","N14":15,"N13":1,"N16":63,"N15":12,"N18":8,"SUMODD":0,"N17":17,"N19":16},{"ISSUE":"677291","N7":21,"N6":24,"N9":12,"N8":10,"N10":1,"N11":8,"N12":4,"SUMEVEN":1,"SUMSMALL":1,"N3":45,"N5":2,"N4":3,"SUMBIG":0,"DRAWCODE":"03,10,09,05,04,07,02,01,08,06","N14":14,"N13":0,"N16":62,"N15":11,"N18":7,"SUMODD":0,"N17":16,"N19":15},{"ISSUE":"677290","N7":20,"N6":23,"N9":11,"N8":9,"N10":0,"N11":7,"N12":3,"SUMEVEN":0,"SUMSMALL":0,"N3":44,"N5":1,"N4":2,"SUMBIG":3,"DRAWCODE":"01,09,07,03,02,06,10,08,05,04","N14":13,"N13":18,"N16":61,"N15":10,"N18":6,"SUMODD":1,"N17":15,"N19":14},{"ISSUE":"677289","N7":19,"N6":22,"N9":10,"N8":8,"N10":3,"N11":6,"N12":2,"SUMEVEN":1,"SUMSMALL":0,"N3":43,"N5":0,"N4":1,"SUMBIG":2,"DRAWCODE":"02,03,06,08,04,10,01,09,07,05","N14":12,"N13":17,"N16":60,"N15":9,"N18":5,"SUMODD":0,"N17":14,"N19":13},{"ISSUE":"677288","N7":18,"N6":21,"N9":9,"N8":7,"N10":2,"N11":5,"N12":1,"SUMEVEN":0,"SUMSMALL":0,"N3":42,"N5":3,"N4":0,"SUMBIG":1,"DRAWCODE":"03,01,04,02,07,06,05,08,10,09","N14":11,"N13":16,"N16":59,"N15":8,"N18":4,"SUMODD":3,"N17":13,"N19":12}]
     * code : 200
     * tj : {"occ2":{"ISSUE":0,"N7":0,"N6":0,"N9":0,"N8":0,"N10":0,"N11":0,"N12":0,"SUMEVEN":0,"SUMSMALL":0,"N3":0,"N5":0,"N4":0,"SUMBIG":0,"DRAWCODE":0,"N14":0,"N13":0,"N16":0,"N15":0,"SUMODD":0,"N18":0,"N17":0,"N19":0},"avgMiss":{"ISSUE":0,"N7":15,"N6":50,"N9":6,"N8":11,"N10":4,"N11":16,"N12":30,"SUMEVEN":1,"SUMSMALL":0,"N3":23,"N5":10,"N4":9,"SUMBIG":1,"DRAWCODE":0,"N14":12,"N13":10,"N16":28,"N15":8,"SUMODD":0,"N18":33,"N17":42,"N19":41},"lastMiss":{"ISSUE":0,"N7":8,"N6":50,"N9":12,"N8":1,"N10":3,"N11":0,"N12":30,"SUMEVEN":1,"SUMSMALL":0,"N3":5,"N5":13,"N4":23,"SUMBIG":2,"DRAWCODE":0,"N14":7,"N13":17,"N16":2,"N15":10,"SUMODD":0,"N18":33,"N17":42,"N19":41},"maxCont":{"ISSUE":0,"N7":1,"N6":0,"N9":2,"N8":1,"N10":2,"N11":1,"N12":0,"SUMEVEN":4,"SUMSMALL":4,"N3":1,"N5":1,"N4":1,"SUMBIG":2,"DRAWCODE":0,"N14":1,"N13":1,"N16":1,"N15":2,"SUMODD":7,"N18":0,"N17":0,"N19":0},"probability":{"ISSUE":0,"N7":6666,"N6":0,"N9":13333,"N8":6666,"N10":16666,"N11":3333,"N12":0,"SUMEVEN":43333,"SUMSMALL":66666,"N3":6666,"N5":6666,"N4":6666,"SUMBIG":33333,"DRAWCODE":0,"N14":6666,"N13":10000,"N16":6666,"N15":10000,"N18":0,"SUMODD":56666,"N17":0,"N19":0},"maxMiss":{"ISSUE":0,"N7":26,"N6":50,"N9":12,"N8":22,"N10":11,"N11":33,"N12":30,"SUMEVEN":7,"SUMSMALL":2,"N3":48,"N5":14,"N4":23,"SUMBIG":4,"DRAWCODE":0,"N14":25,"N13":18,"N16":81,"N15":20,"SUMODD":4,"N18":33,"N17":42,"N19":41},"occ":{"ISSUE":0,"N7":2,"N6":0,"N9":4,"N8":2,"N10":5,"N11":1,"N12":0,"SUMEVEN":13,"SUMSMALL":20,"N3":2,"N5":2,"N4":2,"SUMBIG":10,"DRAWCODE":0,"N14":2,"N13":3,"N16":2,"N15":3,"SUMODD":17,"N18":0,"N17":0,"N19":0}}
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
         * occ2 : {"ISSUE":0,"N7":0,"N6":0,"N9":0,"N8":0,"N10":0,"N11":0,"N12":0,"SUMEVEN":0,"SUMSMALL":0,"N3":0,"N5":0,"N4":0,"SUMBIG":0,"DRAWCODE":0,"N14":0,"N13":0,"N16":0,"N15":0,"SUMODD":0,"N18":0,"N17":0,"N19":0}
         * avgMiss : {"ISSUE":0,"N7":15,"N6":50,"N9":6,"N8":11,"N10":4,"N11":16,"N12":30,"SUMEVEN":1,"SUMSMALL":0,"N3":23,"N5":10,"N4":9,"SUMBIG":1,"DRAWCODE":0,"N14":12,"N13":10,"N16":28,"N15":8,"SUMODD":0,"N18":33,"N17":42,"N19":41}
         * lastMiss : {"ISSUE":0,"N7":8,"N6":50,"N9":12,"N8":1,"N10":3,"N11":0,"N12":30,"SUMEVEN":1,"SUMSMALL":0,"N3":5,"N5":13,"N4":23,"SUMBIG":2,"DRAWCODE":0,"N14":7,"N13":17,"N16":2,"N15":10,"SUMODD":0,"N18":33,"N17":42,"N19":41}
         * maxCont : {"ISSUE":0,"N7":1,"N6":0,"N9":2,"N8":1,"N10":2,"N11":1,"N12":0,"SUMEVEN":4,"SUMSMALL":4,"N3":1,"N5":1,"N4":1,"SUMBIG":2,"DRAWCODE":0,"N14":1,"N13":1,"N16":1,"N15":2,"SUMODD":7,"N18":0,"N17":0,"N19":0}
         * probability : {"ISSUE":0,"N7":6666,"N6":0,"N9":13333,"N8":6666,"N10":16666,"N11":3333,"N12":0,"SUMEVEN":43333,"SUMSMALL":66666,"N3":6666,"N5":6666,"N4":6666,"SUMBIG":33333,"DRAWCODE":0,"N14":6666,"N13":10000,"N16":6666,"N15":10000,"N18":0,"SUMODD":56666,"N17":0,"N19":0}
         * maxMiss : {"ISSUE":0,"N7":26,"N6":50,"N9":12,"N8":22,"N10":11,"N11":33,"N12":30,"SUMEVEN":7,"SUMSMALL":2,"N3":48,"N5":14,"N4":23,"SUMBIG":4,"DRAWCODE":0,"N14":25,"N13":18,"N16":81,"N15":20,"SUMODD":4,"N18":33,"N17":42,"N19":41}
         * occ : {"ISSUE":0,"N7":2,"N6":0,"N9":4,"N8":2,"N10":5,"N11":1,"N12":0,"SUMEVEN":13,"SUMSMALL":20,"N3":2,"N5":2,"N4":2,"SUMBIG":10,"DRAWCODE":0,"N14":2,"N13":3,"N16":2,"N15":3,"SUMODD":17,"N18":0,"N17":0,"N19":0}
         */

        private tjDetailsBean occ2;
        private tjDetailsBean avgMiss;
        private tjDetailsBean lastMiss;
        private tjDetailsBean maxCont;
        private tjDetailsBean probability;
        private tjDetailsBean maxMiss;
        private tjDetailsBean occ;

        public tjDetailsBean getOcc2() {
            return occ2;
        }

        public void setOcc2(tjDetailsBean occ2) {
            this.occ2 = occ2;
        }

        public tjDetailsBean getAvgMiss() {
            return avgMiss;
        }

        public void setAvgMiss(tjDetailsBean avgMiss) {
            this.avgMiss = avgMiss;
        }

        public tjDetailsBean getLastMiss() {
            return lastMiss;
        }

        public void setLastMiss(tjDetailsBean lastMiss) {
            this.lastMiss = lastMiss;
        }

        public tjDetailsBean getMaxCont() {
            return maxCont;
        }

        public void setMaxCont(tjDetailsBean maxCont) {
            this.maxCont = maxCont;
        }

        public tjDetailsBean getProbability() {
            return probability;
        }

        public void setProbability(tjDetailsBean probability) {
            this.probability = probability;
        }

        public tjDetailsBean getMaxMiss() {
            return maxMiss;
        }

        public void setMaxMiss(tjDetailsBean maxMiss) {
            this.maxMiss = maxMiss;
        }

        public tjDetailsBean getOcc() {
            return occ;
        }

        public void setOcc(tjDetailsBean occ) {
            this.occ = occ;
        }

        public static class tjDetailsBean{
            /**
             * ISSUE : 0
             * N7 : 2
             * N6 : 0
             * N9 : 4
             * N8 : 2
             * N10 : 5
             * N11 : 1
             * N12 : 0
             * SUMEVEN : 13
             * SUMSMALL : 20
             * N3 : 2
             * N5 : 2
             * N4 : 2
             * SUMBIG : 10
             * DRAWCODE : 0
             * N14 : 2
             * N13 : 3
             * N16 : 2
             * N15 : 3
             * SUMODD : 17
             * N18 : 0
             * N17 : 0
             * N19 : 0
             */

            private int ISSUE;
            private int N7;
            private int N6;
            private int N9;
            private int N8;
            private int N10;
            private int N11;
            private int N12;
            private int SUMEVEN;
            private int SUMSMALL;
            private int N3;
            private int N5;
            private int N4;
            private int SUMBIG;
            private int DRAWCODE;
            private int N14;
            private int N13;
            private int N16;
            private int N15;
            private int SUMODD;
            private int N18;
            private int N17;
            private int N19;

            public int getISSUE() {
                return ISSUE;
            }

            public void setISSUE(int ISSUE) {
                this.ISSUE = ISSUE;
            }

            public int getN7() {
                return N7;
            }

            public void setN7(int n7) {
                N7 = n7;
            }

            public int getN6() {
                return N6;
            }

            public void setN6(int n6) {
                N6 = n6;
            }

            public int getN9() {
                return N9;
            }

            public void setN9(int n9) {
                N9 = n9;
            }

            public int getN8() {
                return N8;
            }

            public void setN8(int n8) {
                N8 = n8;
            }

            public int getN10() {
                return N10;
            }

            public void setN10(int n10) {
                N10 = n10;
            }

            public int getN11() {
                return N11;
            }

            public void setN11(int n11) {
                N11 = n11;
            }

            public int getN12() {
                return N12;
            }

            public void setN12(int n12) {
                N12 = n12;
            }

            public int getSUMEVEN() {
                return SUMEVEN;
            }

            public void setSUMEVEN(int SUMEVEN) {
                this.SUMEVEN = SUMEVEN;
            }

            public int getSUMSMALL() {
                return SUMSMALL;
            }

            public void setSUMSMALL(int SUMSMALL) {
                this.SUMSMALL = SUMSMALL;
            }

            public int getN3() {
                return N3;
            }

            public void setN3(int n3) {
                N3 = n3;
            }

            public int getN5() {
                return N5;
            }

            public void setN5(int n5) {
                N5 = n5;
            }

            public int getN4() {
                return N4;
            }

            public void setN4(int n4) {
                N4 = n4;
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

            public int getN14() {
                return N14;
            }

            public void setN14(int n14) {
                N14 = n14;
            }

            public int getN13() {
                return N13;
            }

            public void setN13(int n13) {
                N13 = n13;
            }

            public int getN16() {
                return N16;
            }

            public void setN16(int n16) {
                N16 = n16;
            }

            public int getN15() {
                return N15;
            }

            public void setN15(int n15) {
                N15 = n15;
            }

            public int getSUMODD() {
                return SUMODD;
            }

            public void setSUMODD(int SUMODD) {
                this.SUMODD = SUMODD;
            }

            public int getN18() {
                return N18;
            }

            public void setN18(int n18) {
                N18 = n18;
            }

            public int getN17() {
                return N17;
            }

            public void setN17(int n17) {
                N17 = n17;
            }

            public int getN19() {
                return N19;
            }

            public void setN19(int n19) {
                N19 = n19;
            }
        }
    }

    public static class ZsBean {
        /**
         * ISSUE : 677317
         * N7 : 8
         * N6 : 50
         * N9 : 12
         * N8 : 1
         * N10 : 3
         * N11 : 0
         * N12 : 30
         * SUMEVEN : 1
         * SUMSMALL : 0
         * N3 : 5
         * N5 : 13
         * N4 : 23
         * SUMBIG : 2
         * DRAWCODE : 05,06,02,03,08,04,01,07,09,10
         * N14 : 7
         * N13 : 17
         * N16 : 2
         * N15 : 10
         * N18 : 33
         * SUMODD : 0
         * N17 : 42
         * N19 : 41
         */

        private String ISSUE;
        private int N7;
        private int N6;
        private int N9;
        private int N8;
        private int N10;
        private int N11;
        private int N12;
        private int SUMEVEN;
        private int SUMSMALL;
        private int N3;
        private int N5;
        private int N4;
        private int SUMBIG;
        private String DRAWCODE;
        private int N14;
        private int N13;
        private int N16;
        private int N15;
        private int N18;
        private int SUMODD;
        private int N17;
        private int N19;

        public String getISSUE() {
            return ISSUE;
        }

        public void setISSUE(String ISSUE) {
            this.ISSUE = ISSUE;
        }

        public int getN7() {
            return N7;
        }

        public void setN7(int N7) {
            this.N7 = N7;
        }

        public int getN6() {
            return N6;
        }

        public void setN6(int N6) {
            this.N6 = N6;
        }

        public int getN9() {
            return N9;
        }

        public void setN9(int N9) {
            this.N9 = N9;
        }

        public int getN8() {
            return N8;
        }

        public void setN8(int N8) {
            this.N8 = N8;
        }

        public int getN10() {
            return N10;
        }

        public void setN10(int N10) {
            this.N10 = N10;
        }

        public int getN11() {
            return N11;
        }

        public void setN11(int N11) {
            this.N11 = N11;
        }

        public int getN12() {
            return N12;
        }

        public void setN12(int N12) {
            this.N12 = N12;
        }

        public int getSUMEVEN() {
            return SUMEVEN;
        }

        public void setSUMEVEN(int SUMEVEN) {
            this.SUMEVEN = SUMEVEN;
        }

        public int getSUMSMALL() {
            return SUMSMALL;
        }

        public void setSUMSMALL(int SUMSMALL) {
            this.SUMSMALL = SUMSMALL;
        }

        public int getN3() {
            return N3;
        }

        public void setN3(int N3) {
            this.N3 = N3;
        }

        public int getN5() {
            return N5;
        }

        public void setN5(int N5) {
            this.N5 = N5;
        }

        public int getN4() {
            return N4;
        }

        public void setN4(int N4) {
            this.N4 = N4;
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

        public int getN14() {
            return N14;
        }

        public void setN14(int N14) {
            this.N14 = N14;
        }

        public int getN13() {
            return N13;
        }

        public void setN13(int N13) {
            this.N13 = N13;
        }

        public int getN16() {
            return N16;
        }

        public void setN16(int N16) {
            this.N16 = N16;
        }

        public int getN15() {
            return N15;
        }

        public void setN15(int N15) {
            this.N15 = N15;
        }

        public int getN18() {
            return N18;
        }

        public void setN18(int N18) {
            this.N18 = N18;
        }

        public int getSUMODD() {
            return SUMODD;
        }

        public void setSUMODD(int SUMODD) {
            this.SUMODD = SUMODD;
        }

        public int getN17() {
            return N17;
        }

        public void setN17(int N17) {
            this.N17 = N17;
        }

        public int getN19() {
            return N19;
        }

        public void setN19(int N19) {
            this.N19 = N19;
        }
    }
}
