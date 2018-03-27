package com.ybf.lottery.model.bean.bjscstatisticbean;

/**
 * Created by XQyi on 2018/3/24.
 * Use:北京赛车数据统计(亚冠、大小、单双、龙虎走势)统计的实体
 */

public class BJRacecarStatisticYDDLBean {


    /**
     * data : {"gragonTiger_bnum1":{"TIGER":9,"BNUM":1,"DRAGON":21},"gragonTiger_bnum2":{"TIGER":16,"BNUM":2,"DRAGON":14},"gragonTiger_bnum3":{"TIGER":18,"BNUM":3,"DRAGON":12},"sum":{"SUMBIG":18,"SUMSMALL":12,"SUMEVEN":13,"SUMODD":17},"bnum9":{"SMALL":16,"EVEN":17,"BNUM":9,"BIG":14,"ODD":13},"bnum8":{"SMALL":14,"EVEN":13,"BNUM":8,"BIG":16,"ODD":17},"bnum7":{"SMALL":14,"EVEN":12,"BNUM":7,"BIG":16,"ODD":18},"bnum6":{"SMALL":18,"EVEN":13,"BNUM":6,"BIG":12,"ODD":17},"bnum5":{"SMALL":11,"EVEN":18,"BNUM":5,"BIG":19,"ODD":12},"bnum4":{"SMALL":14,"EVEN":14,"BNUM":4,"BIG":16,"ODD":16},"bnum2":{"SMALL":16,"EVEN":13,"BNUM":2,"BIG":14,"ODD":17},"bnum3":{"SMALL":15,"EVEN":21,"BNUM":3,"BIG":15,"ODD":9},"bnum1":{"SMALL":14,"EVEN":12,"BNUM":1,"BIG":16,"ODD":18},"bnum10":{"SMALL":18,"EVEN":17,"BNUM":10,"BIG":12,"ODD":13},"gragonTiger_bnum5":{"TIGER":11,"BNUM":5,"DRAGON":19},"gragonTiger_bnum4":{"TIGER":18,"BNUM":4,"DRAGON":12}}
     * code : 200
     */

    private DataBean data;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * gragonTiger_bnum1 : {"TIGER":9,"BNUM":1,"DRAGON":21}
         * gragonTiger_bnum2 : {"TIGER":16,"BNUM":2,"DRAGON":14}
         * gragonTiger_bnum3 : {"TIGER":18,"BNUM":3,"DRAGON":12}
         * sum : {"SUMBIG":18,"SUMSMALL":12,"SUMEVEN":13,"SUMODD":17}
         * bnum9 : {"SMALL":16,"EVEN":17,"BNUM":9,"BIG":14,"ODD":13}
         * bnum8 : {"SMALL":14,"EVEN":13,"BNUM":8,"BIG":16,"ODD":17}
         * bnum7 : {"SMALL":14,"EVEN":12,"BNUM":7,"BIG":16,"ODD":18}
         * bnum6 : {"SMALL":18,"EVEN":13,"BNUM":6,"BIG":12,"ODD":17}
         * bnum5 : {"SMALL":11,"EVEN":18,"BNUM":5,"BIG":19,"ODD":12}
         * bnum4 : {"SMALL":14,"EVEN":14,"BNUM":4,"BIG":16,"ODD":16}
         * bnum2 : {"SMALL":16,"EVEN":13,"BNUM":2,"BIG":14,"ODD":17}
         * bnum3 : {"SMALL":15,"EVEN":21,"BNUM":3,"BIG":15,"ODD":9}
         * bnum1 : {"SMALL":14,"EVEN":12,"BNUM":1,"BIG":16,"ODD":18}
         * bnum10 : {"SMALL":18,"EVEN":17,"BNUM":10,"BIG":12,"ODD":13}
         * gragonTiger_bnum5 : {"TIGER":11,"BNUM":5,"DRAGON":19}
         * gragonTiger_bnum4 : {"TIGER":18,"BNUM":4,"DRAGON":12}
         */

        private GragonTigerBnum1Bean gragonTiger_bnum1;
        private GragonTigerBnum2Bean gragonTiger_bnum2;
        private GragonTigerBnum3Bean gragonTiger_bnum3;
        private SumBean sum;
        private Bnum9Bean bnum9;
        private Bnum8Bean bnum8;
        private Bnum7Bean bnum7;
        private Bnum6Bean bnum6;
        private Bnum5Bean bnum5;
        private Bnum4Bean bnum4;
        private Bnum2Bean bnum2;
        private Bnum3Bean bnum3;
        private Bnum1Bean bnum1;
        private Bnum10Bean bnum10;
        private GragonTigerBnum5Bean gragonTiger_bnum5;
        private GragonTigerBnum4Bean gragonTiger_bnum4;

        public GragonTigerBnum1Bean getGragonTiger_bnum1() {
            return gragonTiger_bnum1;
        }

        public void setGragonTiger_bnum1(GragonTigerBnum1Bean gragonTiger_bnum1) {
            this.gragonTiger_bnum1 = gragonTiger_bnum1;
        }

        public GragonTigerBnum2Bean getGragonTiger_bnum2() {
            return gragonTiger_bnum2;
        }

        public void setGragonTiger_bnum2(GragonTigerBnum2Bean gragonTiger_bnum2) {
            this.gragonTiger_bnum2 = gragonTiger_bnum2;
        }

        public GragonTigerBnum3Bean getGragonTiger_bnum3() {
            return gragonTiger_bnum3;
        }

        public void setGragonTiger_bnum3(GragonTigerBnum3Bean gragonTiger_bnum3) {
            this.gragonTiger_bnum3 = gragonTiger_bnum3;
        }

        public SumBean getSum() {
            return sum;
        }

        public void setSum(SumBean sum) {
            this.sum = sum;
        }

        public Bnum9Bean getBnum9() {
            return bnum9;
        }

        public void setBnum9(Bnum9Bean bnum9) {
            this.bnum9 = bnum9;
        }

        public Bnum8Bean getBnum8() {
            return bnum8;
        }

        public void setBnum8(Bnum8Bean bnum8) {
            this.bnum8 = bnum8;
        }

        public Bnum7Bean getBnum7() {
            return bnum7;
        }

        public void setBnum7(Bnum7Bean bnum7) {
            this.bnum7 = bnum7;
        }

        public Bnum6Bean getBnum6() {
            return bnum6;
        }

        public void setBnum6(Bnum6Bean bnum6) {
            this.bnum6 = bnum6;
        }

        public Bnum5Bean getBnum5() {
            return bnum5;
        }

        public void setBnum5(Bnum5Bean bnum5) {
            this.bnum5 = bnum5;
        }

        public Bnum4Bean getBnum4() {
            return bnum4;
        }

        public void setBnum4(Bnum4Bean bnum4) {
            this.bnum4 = bnum4;
        }

        public Bnum2Bean getBnum2() {
            return bnum2;
        }

        public void setBnum2(Bnum2Bean bnum2) {
            this.bnum2 = bnum2;
        }

        public Bnum3Bean getBnum3() {
            return bnum3;
        }

        public void setBnum3(Bnum3Bean bnum3) {
            this.bnum3 = bnum3;
        }

        public Bnum1Bean getBnum1() {
            return bnum1;
        }

        public void setBnum1(Bnum1Bean bnum1) {
            this.bnum1 = bnum1;
        }

        public Bnum10Bean getBnum10() {
            return bnum10;
        }

        public void setBnum10(Bnum10Bean bnum10) {
            this.bnum10 = bnum10;
        }

        public GragonTigerBnum5Bean getGragonTiger_bnum5() {
            return gragonTiger_bnum5;
        }

        public void setGragonTiger_bnum5(GragonTigerBnum5Bean gragonTiger_bnum5) {
            this.gragonTiger_bnum5 = gragonTiger_bnum5;
        }

        public GragonTigerBnum4Bean getGragonTiger_bnum4() {
            return gragonTiger_bnum4;
        }

        public void setGragonTiger_bnum4(GragonTigerBnum4Bean gragonTiger_bnum4) {
            this.gragonTiger_bnum4 = gragonTiger_bnum4;
        }

        public static class GragonTigerBnum1Bean {
            /**
             * TIGER : 9
             * BNUM : 1
             * DRAGON : 21
             */

            private int TIGER;
            private int BNUM;
            private int DRAGON;

            public int getTIGER() {
                return TIGER;
            }

            public void setTIGER(int TIGER) {
                this.TIGER = TIGER;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getDRAGON() {
                return DRAGON;
            }

            public void setDRAGON(int DRAGON) {
                this.DRAGON = DRAGON;
            }
        }

        public static class GragonTigerBnum2Bean {
            /**
             * TIGER : 16
             * BNUM : 2
             * DRAGON : 14
             */

            private int TIGER;
            private int BNUM;
            private int DRAGON;

            public int getTIGER() {
                return TIGER;
            }

            public void setTIGER(int TIGER) {
                this.TIGER = TIGER;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getDRAGON() {
                return DRAGON;
            }

            public void setDRAGON(int DRAGON) {
                this.DRAGON = DRAGON;
            }
        }

        public static class GragonTigerBnum3Bean {
            /**
             * TIGER : 18
             * BNUM : 3
             * DRAGON : 12
             */

            private int TIGER;
            private int BNUM;
            private int DRAGON;

            public int getTIGER() {
                return TIGER;
            }

            public void setTIGER(int TIGER) {
                this.TIGER = TIGER;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getDRAGON() {
                return DRAGON;
            }

            public void setDRAGON(int DRAGON) {
                this.DRAGON = DRAGON;
            }
        }

        public static class SumBean {
            /**
             * SUMBIG : 18
             * SUMSMALL : 12
             * SUMEVEN : 13
             * SUMODD : 17
             */

            private int SUMBIG;
            private int SUMSMALL;
            private int SUMEVEN;
            private int SUMODD;

            public int getSUMBIG() {
                return SUMBIG;
            }

            public void setSUMBIG(int SUMBIG) {
                this.SUMBIG = SUMBIG;
            }

            public int getSUMSMALL() {
                return SUMSMALL;
            }

            public void setSUMSMALL(int SUMSMALL) {
                this.SUMSMALL = SUMSMALL;
            }

            public int getSUMEVEN() {
                return SUMEVEN;
            }

            public void setSUMEVEN(int SUMEVEN) {
                this.SUMEVEN = SUMEVEN;
            }

            public int getSUMODD() {
                return SUMODD;
            }

            public void setSUMODD(int SUMODD) {
                this.SUMODD = SUMODD;
            }
        }

        public static class Bnum9Bean {
            /**
             * SMALL : 16
             * EVEN : 17
             * BNUM : 9
             * BIG : 14
             * ODD : 13
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum8Bean {
            /**
             * SMALL : 14
             * EVEN : 13
             * BNUM : 8
             * BIG : 16
             * ODD : 17
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum7Bean {
            /**
             * SMALL : 14
             * EVEN : 12
             * BNUM : 7
             * BIG : 16
             * ODD : 18
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum6Bean {
            /**
             * SMALL : 18
             * EVEN : 13
             * BNUM : 6
             * BIG : 12
             * ODD : 17
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum5Bean {
            /**
             * SMALL : 11
             * EVEN : 18
             * BNUM : 5
             * BIG : 19
             * ODD : 12
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum4Bean {
            /**
             * SMALL : 14
             * EVEN : 14
             * BNUM : 4
             * BIG : 16
             * ODD : 16
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum2Bean {
            /**
             * SMALL : 16
             * EVEN : 13
             * BNUM : 2
             * BIG : 14
             * ODD : 17
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum3Bean {
            /**
             * SMALL : 15
             * EVEN : 21
             * BNUM : 3
             * BIG : 15
             * ODD : 9
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum1Bean {
            /**
             * SMALL : 14
             * EVEN : 12
             * BNUM : 1
             * BIG : 16
             * ODD : 18
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class Bnum10Bean {
            /**
             * SMALL : 18
             * EVEN : 17
             * BNUM : 10
             * BIG : 12
             * ODD : 13
             */

            private int SMALL;
            private int EVEN;
            private int BNUM;
            private int BIG;
            private int ODD;

            public int getSMALL() {
                return SMALL;
            }

            public void setSMALL(int SMALL) {
                this.SMALL = SMALL;
            }

            public int getEVEN() {
                return EVEN;
            }

            public void setEVEN(int EVEN) {
                this.EVEN = EVEN;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getBIG() {
                return BIG;
            }

            public void setBIG(int BIG) {
                this.BIG = BIG;
            }

            public int getODD() {
                return ODD;
            }

            public void setODD(int ODD) {
                this.ODD = ODD;
            }
        }

        public static class GragonTigerBnum5Bean {
            /**
             * TIGER : 11
             * BNUM : 5
             * DRAGON : 19
             */

            private int TIGER;
            private int BNUM;
            private int DRAGON;

            public int getTIGER() {
                return TIGER;
            }

            public void setTIGER(int TIGER) {
                this.TIGER = TIGER;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getDRAGON() {
                return DRAGON;
            }

            public void setDRAGON(int DRAGON) {
                this.DRAGON = DRAGON;
            }
        }

        public static class GragonTigerBnum4Bean {
            /**
             * TIGER : 18
             * BNUM : 4
             * DRAGON : 12
             */

            private int TIGER;
            private int BNUM;
            private int DRAGON;

            public int getTIGER() {
                return TIGER;
            }

            public void setTIGER(int TIGER) {
                this.TIGER = TIGER;
            }

            public int getBNUM() {
                return BNUM;
            }

            public void setBNUM(int BNUM) {
                this.BNUM = BNUM;
            }

            public int getDRAGON() {
                return DRAGON;
            }

            public void setDRAGON(int DRAGON) {
                this.DRAGON = DRAGON;
            }
        }
    }
}
