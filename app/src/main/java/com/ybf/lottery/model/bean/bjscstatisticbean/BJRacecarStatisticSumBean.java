package com.ybf.lottery.model.bean.bjscstatisticbean;

/**
 * Created by XQyi on 2018/3/24.
 * Use:北京赛车数据统计(总和、龙虎)的实体
 */

public class BJRacecarStatisticSumBean {

    /**
     * data : {"bnum2":{"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"lastMiss":{"ISSUE":0,"TIGER":1,"DRAGON":0},"maxCont":{"ISSUE":0,"TIGER":6,"DRAGON":4},"maxMiss":{"ISSUE":0,"TIGER":4,"DRAGON":6},"probability":{"ISSUE":0,"TIGER":53333,"DRAGON":46666},"occ":{"ISSUE":0,"TIGER":16,"DRAGON":14}},"bnum3":{"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"lastMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"maxCont":{"ISSUE":0,"TIGER":3,"DRAGON":2},"maxMiss":{"ISSUE":0,"TIGER":2,"DRAGON":3},"probability":{"ISSUE":0,"TIGER":60000,"DRAGON":40000},"occ":{"ISSUE":0,"TIGER":18,"DRAGON":12}},"bnum1":{"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":1,"DRAGON":0},"lastMiss":{"ISSUE":0,"TIGER":4,"DRAGON":0},"maxCont":{"ISSUE":0,"TIGER":3,"DRAGON":5},"maxMiss":{"ISSUE":0,"TIGER":5,"DRAGON":3},"probability":{"ISSUE":0,"TIGER":33333,"DRAGON":66666},"occ":{"ISSUE":0,"TIGER":10,"DRAGON":20}},"sum":{"occ2":{"ISSUE":0,"N7":0,"N6":0,"N9":0,"N8":0,"N10":0,"N11":0,"N12":0,"SUMEVEN":0,"SUMSMALL":0,"N3":0,"N5":0,"N4":0,"SUMBIG":0,"DRAWCODE":0,"N14":0,"N13":0,"N16":0,"N15":0,"SUMODD":0,"N18":0,"N17":0,"N19":0},"avgMiss":{"ISSUE":0,"N7":18,"N6":15,"N9":10,"N8":15,"N10":12,"N11":6,"N12":8,"SUMEVEN":1,"SUMSMALL":1,"N3":75,"N5":15,"N4":34,"SUMBIG":0,"DRAWCODE":0,"N14":20,"N13":5,"N16":19,"N15":15,"SUMODD":0,"N18":36,"N17":47,"N19":14},"lastMiss":{"ISSUE":0,"N7":25,"N6":15,"N9":1,"N8":13,"N10":16,"N11":2,"N12":11,"SUMEVEN":11,"SUMSMALL":1,"N3":75,"N5":18,"N4":34,"SUMBIG":0,"DRAWCODE":0,"N14":27,"N13":0,"N16":17,"N15":8,"SUMODD":0,"N18":36,"N17":47,"N19":3},"maxCont":{"ISSUE":0,"N7":1,"N6":1,"N9":1,"N8":1,"N10":1,"N11":1,"N12":1,"SUMEVEN":5,"SUMSMALL":2,"N3":0,"N5":1,"N4":0,"SUMBIG":6,"DRAWCODE":0,"N14":1,"N13":4,"N16":1,"N15":1,"SUMODD":11,"N18":0,"N17":0,"N19":1},"maxMiss":{"ISSUE":0,"N7":25,"N6":40,"N9":23,"N8":17,"N10":18,"N11":16,"N12":17,"SUMEVEN":11,"SUMSMALL":6,"N3":75,"N5":18,"N4":34,"SUMBIG":2,"DRAWCODE":0,"N14":27,"N13":26,"N16":21,"N15":28,"SUMODD":5,"N18":36,"N17":47,"N19":26},"probability":{"ISSUE":0,"N7":3333,"N6":10000,"N9":6666,"N8":3333,"N10":6666,"N11":10000,"N12":13333,"SUMEVEN":40000,"SUMSMALL":43333,"N3":0,"N5":3333,"N4":0,"SUMBIG":56666,"DRAWCODE":0,"N14":3333,"N13":26666,"N16":3333,"N15":6666,"N18":0,"SUMODD":60000,"N17":0,"N19":3333},"occ":{"ISSUE":0,"N7":1,"N6":3,"N9":2,"N8":1,"N10":2,"N11":3,"N12":4,"SUMEVEN":12,"SUMSMALL":13,"N3":0,"N5":1,"N4":0,"SUMBIG":17,"DRAWCODE":0,"N14":1,"N13":8,"N16":1,"N15":2,"SUMODD":18,"N18":0,"N17":0,"N19":1}},"bnum5":{"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":1,"DRAGON":0},"lastMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"maxCont":{"ISSUE":0,"TIGER":3,"DRAGON":8},"maxMiss":{"ISSUE":0,"TIGER":8,"DRAGON":3},"probability":{"ISSUE":0,"TIGER":40000,"DRAGON":60000},"occ":{"ISSUE":0,"TIGER":12,"DRAGON":18}},"bnum4":{"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"lastMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"maxCont":{"ISSUE":0,"TIGER":5,"DRAGON":4},"maxMiss":{"ISSUE":0,"TIGER":4,"DRAGON":5},"probability":{"ISSUE":0,"TIGER":60000,"DRAGON":40000},"occ":{"ISSUE":0,"TIGER":18,"DRAGON":12}}}
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
         * bnum2 : {"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"lastMiss":{"ISSUE":0,"TIGER":1,"DRAGON":0},"maxCont":{"ISSUE":0,"TIGER":6,"DRAGON":4},"maxMiss":{"ISSUE":0,"TIGER":4,"DRAGON":6},"probability":{"ISSUE":0,"TIGER":53333,"DRAGON":46666},"occ":{"ISSUE":0,"TIGER":16,"DRAGON":14}}
         * bnum3 : {"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"lastMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"maxCont":{"ISSUE":0,"TIGER":3,"DRAGON":2},"maxMiss":{"ISSUE":0,"TIGER":2,"DRAGON":3},"probability":{"ISSUE":0,"TIGER":60000,"DRAGON":40000},"occ":{"ISSUE":0,"TIGER":18,"DRAGON":12}}
         * bnum1 : {"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":1,"DRAGON":0},"lastMiss":{"ISSUE":0,"TIGER":4,"DRAGON":0},"maxCont":{"ISSUE":0,"TIGER":3,"DRAGON":5},"maxMiss":{"ISSUE":0,"TIGER":5,"DRAGON":3},"probability":{"ISSUE":0,"TIGER":33333,"DRAGON":66666},"occ":{"ISSUE":0,"TIGER":10,"DRAGON":20}}
         * sum : {"occ2":{"ISSUE":0,"N7":0,"N6":0,"N9":0,"N8":0,"N10":0,"N11":0,"N12":0,"SUMEVEN":0,"SUMSMALL":0,"N3":0,"N5":0,"N4":0,"SUMBIG":0,"DRAWCODE":0,"N14":0,"N13":0,"N16":0,"N15":0,"SUMODD":0,"N18":0,"N17":0,"N19":0},"avgMiss":{"ISSUE":0,"N7":18,"N6":15,"N9":10,"N8":15,"N10":12,"N11":6,"N12":8,"SUMEVEN":1,"SUMSMALL":1,"N3":75,"N5":15,"N4":34,"SUMBIG":0,"DRAWCODE":0,"N14":20,"N13":5,"N16":19,"N15":15,"SUMODD":0,"N18":36,"N17":47,"N19":14},"lastMiss":{"ISSUE":0,"N7":25,"N6":15,"N9":1,"N8":13,"N10":16,"N11":2,"N12":11,"SUMEVEN":11,"SUMSMALL":1,"N3":75,"N5":18,"N4":34,"SUMBIG":0,"DRAWCODE":0,"N14":27,"N13":0,"N16":17,"N15":8,"SUMODD":0,"N18":36,"N17":47,"N19":3},"maxCont":{"ISSUE":0,"N7":1,"N6":1,"N9":1,"N8":1,"N10":1,"N11":1,"N12":1,"SUMEVEN":5,"SUMSMALL":2,"N3":0,"N5":1,"N4":0,"SUMBIG":6,"DRAWCODE":0,"N14":1,"N13":4,"N16":1,"N15":1,"SUMODD":11,"N18":0,"N17":0,"N19":1},"maxMiss":{"ISSUE":0,"N7":25,"N6":40,"N9":23,"N8":17,"N10":18,"N11":16,"N12":17,"SUMEVEN":11,"SUMSMALL":6,"N3":75,"N5":18,"N4":34,"SUMBIG":2,"DRAWCODE":0,"N14":27,"N13":26,"N16":21,"N15":28,"SUMODD":5,"N18":36,"N17":47,"N19":26},"probability":{"ISSUE":0,"N7":3333,"N6":10000,"N9":6666,"N8":3333,"N10":6666,"N11":10000,"N12":13333,"SUMEVEN":40000,"SUMSMALL":43333,"N3":0,"N5":3333,"N4":0,"SUMBIG":56666,"DRAWCODE":0,"N14":3333,"N13":26666,"N16":3333,"N15":6666,"N18":0,"SUMODD":60000,"N17":0,"N19":3333},"occ":{"ISSUE":0,"N7":1,"N6":3,"N9":2,"N8":1,"N10":2,"N11":3,"N12":4,"SUMEVEN":12,"SUMSMALL":13,"N3":0,"N5":1,"N4":0,"SUMBIG":17,"DRAWCODE":0,"N14":1,"N13":8,"N16":1,"N15":2,"SUMODD":18,"N18":0,"N17":0,"N19":1}}
         * bnum5 : {"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":1,"DRAGON":0},"lastMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"maxCont":{"ISSUE":0,"TIGER":3,"DRAGON":8},"maxMiss":{"ISSUE":0,"TIGER":8,"DRAGON":3},"probability":{"ISSUE":0,"TIGER":40000,"DRAGON":60000},"occ":{"ISSUE":0,"TIGER":12,"DRAGON":18}}
         * bnum4 : {"occ2":{"ISSUE":0,"TIGER":0,"DRAGON":0},"avgMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"lastMiss":{"ISSUE":0,"TIGER":0,"DRAGON":1},"maxCont":{"ISSUE":0,"TIGER":5,"DRAGON":4},"maxMiss":{"ISSUE":0,"TIGER":4,"DRAGON":5},"probability":{"ISSUE":0,"TIGER":60000,"DRAGON":40000},"occ":{"ISSUE":0,"TIGER":18,"DRAGON":12}}
         */

        private Bnum2Bean bnum2;
        private Bnum3Bean bnum3;
        private Bnum1Bean bnum1;
        private SumBean sum;
        private Bnum5Bean bnum5;
        private Bnum4Bean bnum4;

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

        public SumBean getSum() {
            return sum;
        }

        public void setSum(SumBean sum) {
            this.sum = sum;
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

        public static class Bnum2Bean {
            /**
             * occ2 : {"ISSUE":0,"TIGER":0,"DRAGON":0}
             * avgMiss : {"ISSUE":0,"TIGER":0,"DRAGON":1}
             * lastMiss : {"ISSUE":0,"TIGER":1,"DRAGON":0}
             * maxCont : {"ISSUE":0,"TIGER":6,"DRAGON":4}
             * maxMiss : {"ISSUE":0,"TIGER":4,"DRAGON":6}
             * probability : {"ISSUE":0,"TIGER":53333,"DRAGON":46666}
             * occ : {"ISSUE":0,"TIGER":16,"DRAGON":14}
             */

            private Occ2Bean occ2;
            private AvgMissBean avgMiss;
            private LastMissBean lastMiss;
            private MaxContBean maxCont;
            private MaxMissBean maxMiss;
            private ProbabilityBean probability;
            private OccBean occ;

            public Occ2Bean getOcc2() {
                return occ2;
            }

            public void setOcc2(Occ2Bean occ2) {
                this.occ2 = occ2;
            }

            public AvgMissBean getAvgMiss() {
                return avgMiss;
            }

            public void setAvgMiss(AvgMissBean avgMiss) {
                this.avgMiss = avgMiss;
            }

            public LastMissBean getLastMiss() {
                return lastMiss;
            }

            public void setLastMiss(LastMissBean lastMiss) {
                this.lastMiss = lastMiss;
            }

            public MaxContBean getMaxCont() {
                return maxCont;
            }

            public void setMaxCont(MaxContBean maxCont) {
                this.maxCont = maxCont;
            }

            public MaxMissBean getMaxMiss() {
                return maxMiss;
            }

            public void setMaxMiss(MaxMissBean maxMiss) {
                this.maxMiss = maxMiss;
            }

            public ProbabilityBean getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBean probability) {
                this.probability = probability;
            }

            public OccBean getOcc() {
                return occ;
            }

            public void setOcc(OccBean occ) {
                this.occ = occ;
            }

            public static class Occ2Bean {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class AvgMissBean {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 1
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class LastMissBean {
                /**
                 * ISSUE : 0
                 * TIGER : 1
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxContBean {
                /**
                 * ISSUE : 0
                 * TIGER : 6
                 * DRAGON : 4
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxMissBean {
                /**
                 * ISSUE : 0
                 * TIGER : 4
                 * DRAGON : 6
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class ProbabilityBean {
                /**
                 * ISSUE : 0
                 * TIGER : 53333
                 * DRAGON : 46666
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class OccBean {
                /**
                 * ISSUE : 0
                 * TIGER : 16
                 * DRAGON : 14
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }
        }

        public static class Bnum3Bean {
            /**
             * occ2 : {"ISSUE":0,"TIGER":0,"DRAGON":0}
             * avgMiss : {"ISSUE":0,"TIGER":0,"DRAGON":1}
             * lastMiss : {"ISSUE":0,"TIGER":0,"DRAGON":1}
             * maxCont : {"ISSUE":0,"TIGER":3,"DRAGON":2}
             * maxMiss : {"ISSUE":0,"TIGER":2,"DRAGON":3}
             * probability : {"ISSUE":0,"TIGER":60000,"DRAGON":40000}
             * occ : {"ISSUE":0,"TIGER":18,"DRAGON":12}
             */

            private Occ2BeanX occ2;
            private AvgMissBeanX avgMiss;
            private LastMissBeanX lastMiss;
            private MaxContBeanX maxCont;
            private MaxMissBeanX maxMiss;
            private ProbabilityBeanX probability;
            private OccBeanX occ;

            public Occ2BeanX getOcc2() {
                return occ2;
            }

            public void setOcc2(Occ2BeanX occ2) {
                this.occ2 = occ2;
            }

            public AvgMissBeanX getAvgMiss() {
                return avgMiss;
            }

            public void setAvgMiss(AvgMissBeanX avgMiss) {
                this.avgMiss = avgMiss;
            }

            public LastMissBeanX getLastMiss() {
                return lastMiss;
            }

            public void setLastMiss(LastMissBeanX lastMiss) {
                this.lastMiss = lastMiss;
            }

            public MaxContBeanX getMaxCont() {
                return maxCont;
            }

            public void setMaxCont(MaxContBeanX maxCont) {
                this.maxCont = maxCont;
            }

            public MaxMissBeanX getMaxMiss() {
                return maxMiss;
            }

            public void setMaxMiss(MaxMissBeanX maxMiss) {
                this.maxMiss = maxMiss;
            }

            public ProbabilityBeanX getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBeanX probability) {
                this.probability = probability;
            }

            public OccBeanX getOcc() {
                return occ;
            }

            public void setOcc(OccBeanX occ) {
                this.occ = occ;
            }

            public static class Occ2BeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class AvgMissBeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 1
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class LastMissBeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 1
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxContBeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 3
                 * DRAGON : 2
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxMissBeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 2
                 * DRAGON : 3
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class ProbabilityBeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 60000
                 * DRAGON : 40000
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class OccBeanX {
                /**
                 * ISSUE : 0
                 * TIGER : 18
                 * DRAGON : 12
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }
        }

        public static class Bnum1Bean {
            /**
             * occ2 : {"ISSUE":0,"TIGER":0,"DRAGON":0}
             * avgMiss : {"ISSUE":0,"TIGER":1,"DRAGON":0}
             * lastMiss : {"ISSUE":0,"TIGER":4,"DRAGON":0}
             * maxCont : {"ISSUE":0,"TIGER":3,"DRAGON":5}
             * maxMiss : {"ISSUE":0,"TIGER":5,"DRAGON":3}
             * probability : {"ISSUE":0,"TIGER":33333,"DRAGON":66666}
             * occ : {"ISSUE":0,"TIGER":10,"DRAGON":20}
             */

            private Occ2BeanXX occ2;
            private AvgMissBeanXX avgMiss;
            private LastMissBeanXX lastMiss;
            private MaxContBeanXX maxCont;
            private MaxMissBeanXX maxMiss;
            private ProbabilityBeanXX probability;
            private OccBeanXX occ;

            public Occ2BeanXX getOcc2() {
                return occ2;
            }

            public void setOcc2(Occ2BeanXX occ2) {
                this.occ2 = occ2;
            }

            public AvgMissBeanXX getAvgMiss() {
                return avgMiss;
            }

            public void setAvgMiss(AvgMissBeanXX avgMiss) {
                this.avgMiss = avgMiss;
            }

            public LastMissBeanXX getLastMiss() {
                return lastMiss;
            }

            public void setLastMiss(LastMissBeanXX lastMiss) {
                this.lastMiss = lastMiss;
            }

            public MaxContBeanXX getMaxCont() {
                return maxCont;
            }

            public void setMaxCont(MaxContBeanXX maxCont) {
                this.maxCont = maxCont;
            }

            public MaxMissBeanXX getMaxMiss() {
                return maxMiss;
            }

            public void setMaxMiss(MaxMissBeanXX maxMiss) {
                this.maxMiss = maxMiss;
            }

            public ProbabilityBeanXX getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBeanXX probability) {
                this.probability = probability;
            }

            public OccBeanXX getOcc() {
                return occ;
            }

            public void setOcc(OccBeanXX occ) {
                this.occ = occ;
            }

            public static class Occ2BeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class AvgMissBeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 1
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class LastMissBeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 4
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxContBeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 3
                 * DRAGON : 5
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxMissBeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 5
                 * DRAGON : 3
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class ProbabilityBeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 33333
                 * DRAGON : 66666
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class OccBeanXX {
                /**
                 * ISSUE : 0
                 * TIGER : 10
                 * DRAGON : 20
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }
        }

        public static class SumBean {
            /**
             * occ2 : {"ISSUE":0,"N7":0,"N6":0,"N9":0,"N8":0,"N10":0,"N11":0,"N12":0,"SUMEVEN":0,"SUMSMALL":0,"N3":0,"N5":0,"N4":0,"SUMBIG":0,"DRAWCODE":0,"N14":0,"N13":0,"N16":0,"N15":0,"SUMODD":0,"N18":0,"N17":0,"N19":0}
             * avgMiss : {"ISSUE":0,"N7":18,"N6":15,"N9":10,"N8":15,"N10":12,"N11":6,"N12":8,"SUMEVEN":1,"SUMSMALL":1,"N3":75,"N5":15,"N4":34,"SUMBIG":0,"DRAWCODE":0,"N14":20,"N13":5,"N16":19,"N15":15,"SUMODD":0,"N18":36,"N17":47,"N19":14}
             * lastMiss : {"ISSUE":0,"N7":25,"N6":15,"N9":1,"N8":13,"N10":16,"N11":2,"N12":11,"SUMEVEN":11,"SUMSMALL":1,"N3":75,"N5":18,"N4":34,"SUMBIG":0,"DRAWCODE":0,"N14":27,"N13":0,"N16":17,"N15":8,"SUMODD":0,"N18":36,"N17":47,"N19":3}
             * maxCont : {"ISSUE":0,"N7":1,"N6":1,"N9":1,"N8":1,"N10":1,"N11":1,"N12":1,"SUMEVEN":5,"SUMSMALL":2,"N3":0,"N5":1,"N4":0,"SUMBIG":6,"DRAWCODE":0,"N14":1,"N13":4,"N16":1,"N15":1,"SUMODD":11,"N18":0,"N17":0,"N19":1}
             * maxMiss : {"ISSUE":0,"N7":25,"N6":40,"N9":23,"N8":17,"N10":18,"N11":16,"N12":17,"SUMEVEN":11,"SUMSMALL":6,"N3":75,"N5":18,"N4":34,"SUMBIG":2,"DRAWCODE":0,"N14":27,"N13":26,"N16":21,"N15":28,"SUMODD":5,"N18":36,"N17":47,"N19":26}
             * probability : {"ISSUE":0,"N7":3333,"N6":10000,"N9":6666,"N8":3333,"N10":6666,"N11":10000,"N12":13333,"SUMEVEN":40000,"SUMSMALL":43333,"N3":0,"N5":3333,"N4":0,"SUMBIG":56666,"DRAWCODE":0,"N14":3333,"N13":26666,"N16":3333,"N15":6666,"N18":0,"SUMODD":60000,"N17":0,"N19":3333}
             * occ : {"ISSUE":0,"N7":1,"N6":3,"N9":2,"N8":1,"N10":2,"N11":3,"N12":4,"SUMEVEN":12,"SUMSMALL":13,"N3":0,"N5":1,"N4":0,"SUMBIG":17,"DRAWCODE":0,"N14":1,"N13":8,"N16":1,"N15":2,"SUMODD":18,"N18":0,"N17":0,"N19":1}
             */

            private Occ2BeanXXX occ2;
            private AvgMissBeanXXX avgMiss;
            private LastMissBeanXXX lastMiss;
            private MaxContBeanXXX maxCont;
            private MaxMissBeanXXX maxMiss;
            private ProbabilityBeanXXX probability;
            private OccBeanXXX occ;

            public Occ2BeanXXX getOcc2() {
                return occ2;
            }

            public void setOcc2(Occ2BeanXXX occ2) {
                this.occ2 = occ2;
            }

            public AvgMissBeanXXX getAvgMiss() {
                return avgMiss;
            }

            public void setAvgMiss(AvgMissBeanXXX avgMiss) {
                this.avgMiss = avgMiss;
            }

            public LastMissBeanXXX getLastMiss() {
                return lastMiss;
            }

            public void setLastMiss(LastMissBeanXXX lastMiss) {
                this.lastMiss = lastMiss;
            }

            public MaxContBeanXXX getMaxCont() {
                return maxCont;
            }

            public void setMaxCont(MaxContBeanXXX maxCont) {
                this.maxCont = maxCont;
            }

            public MaxMissBeanXXX getMaxMiss() {
                return maxMiss;
            }

            public void setMaxMiss(MaxMissBeanXXX maxMiss) {
                this.maxMiss = maxMiss;
            }

            public ProbabilityBeanXXX getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBeanXXX probability) {
                this.probability = probability;
            }

            public OccBeanXXX getOcc() {
                return occ;
            }

            public void setOcc(OccBeanXXX occ) {
                this.occ = occ;
            }

            public static class Occ2BeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 0
                 * N6 : 0
                 * N9 : 0
                 * N8 : 0
                 * N10 : 0
                 * N11 : 0
                 * N12 : 0
                 * SUMEVEN : 0
                 * SUMSMALL : 0
                 * N3 : 0
                 * N5 : 0
                 * N4 : 0
                 * SUMBIG : 0
                 * DRAWCODE : 0
                 * N14 : 0
                 * N13 : 0
                 * N16 : 0
                 * N15 : 0
                 * SUMODD : 0
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

                public int getSUMODD() {
                    return SUMODD;
                }

                public void setSUMODD(int SUMODD) {
                    this.SUMODD = SUMODD;
                }

                public int getN18() {
                    return N18;
                }

                public void setN18(int N18) {
                    this.N18 = N18;
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

            public static class AvgMissBeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 18
                 * N6 : 15
                 * N9 : 10
                 * N8 : 15
                 * N10 : 12
                 * N11 : 6
                 * N12 : 8
                 * SUMEVEN : 1
                 * SUMSMALL : 1
                 * N3 : 75
                 * N5 : 15
                 * N4 : 34
                 * SUMBIG : 0
                 * DRAWCODE : 0
                 * N14 : 20
                 * N13 : 5
                 * N16 : 19
                 * N15 : 15
                 * SUMODD : 0
                 * N18 : 36
                 * N17 : 47
                 * N19 : 14
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

                public int getSUMODD() {
                    return SUMODD;
                }

                public void setSUMODD(int SUMODD) {
                    this.SUMODD = SUMODD;
                }

                public int getN18() {
                    return N18;
                }

                public void setN18(int N18) {
                    this.N18 = N18;
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

            public static class LastMissBeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 25
                 * N6 : 15
                 * N9 : 1
                 * N8 : 13
                 * N10 : 16
                 * N11 : 2
                 * N12 : 11
                 * SUMEVEN : 11
                 * SUMSMALL : 1
                 * N3 : 75
                 * N5 : 18
                 * N4 : 34
                 * SUMBIG : 0
                 * DRAWCODE : 0
                 * N14 : 27
                 * N13 : 0
                 * N16 : 17
                 * N15 : 8
                 * SUMODD : 0
                 * N18 : 36
                 * N17 : 47
                 * N19 : 3
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

                public int getSUMODD() {
                    return SUMODD;
                }

                public void setSUMODD(int SUMODD) {
                    this.SUMODD = SUMODD;
                }

                public int getN18() {
                    return N18;
                }

                public void setN18(int N18) {
                    this.N18 = N18;
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

            public static class MaxContBeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 1
                 * N6 : 1
                 * N9 : 1
                 * N8 : 1
                 * N10 : 1
                 * N11 : 1
                 * N12 : 1
                 * SUMEVEN : 5
                 * SUMSMALL : 2
                 * N3 : 0
                 * N5 : 1
                 * N4 : 0
                 * SUMBIG : 6
                 * DRAWCODE : 0
                 * N14 : 1
                 * N13 : 4
                 * N16 : 1
                 * N15 : 1
                 * SUMODD : 11
                 * N18 : 0
                 * N17 : 0
                 * N19 : 1
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

                public int getSUMODD() {
                    return SUMODD;
                }

                public void setSUMODD(int SUMODD) {
                    this.SUMODD = SUMODD;
                }

                public int getN18() {
                    return N18;
                }

                public void setN18(int N18) {
                    this.N18 = N18;
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

            public static class MaxMissBeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 25
                 * N6 : 40
                 * N9 : 23
                 * N8 : 17
                 * N10 : 18
                 * N11 : 16
                 * N12 : 17
                 * SUMEVEN : 11
                 * SUMSMALL : 6
                 * N3 : 75
                 * N5 : 18
                 * N4 : 34
                 * SUMBIG : 2
                 * DRAWCODE : 0
                 * N14 : 27
                 * N13 : 26
                 * N16 : 21
                 * N15 : 28
                 * SUMODD : 5
                 * N18 : 36
                 * N17 : 47
                 * N19 : 26
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

                public int getSUMODD() {
                    return SUMODD;
                }

                public void setSUMODD(int SUMODD) {
                    this.SUMODD = SUMODD;
                }

                public int getN18() {
                    return N18;
                }

                public void setN18(int N18) {
                    this.N18 = N18;
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

            public static class ProbabilityBeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 3333
                 * N6 : 10000
                 * N9 : 6666
                 * N8 : 3333
                 * N10 : 6666
                 * N11 : 10000
                 * N12 : 13333
                 * SUMEVEN : 40000
                 * SUMSMALL : 43333
                 * N3 : 0
                 * N5 : 3333
                 * N4 : 0
                 * SUMBIG : 56666
                 * DRAWCODE : 0
                 * N14 : 3333
                 * N13 : 26666
                 * N16 : 3333
                 * N15 : 6666
                 * N18 : 0
                 * SUMODD : 60000
                 * N17 : 0
                 * N19 : 3333
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
                private int N18;
                private int SUMODD;
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

            public static class OccBeanXXX {
                /**
                 * ISSUE : 0
                 * N7 : 1
                 * N6 : 3
                 * N9 : 2
                 * N8 : 1
                 * N10 : 2
                 * N11 : 3
                 * N12 : 4
                 * SUMEVEN : 12
                 * SUMSMALL : 13
                 * N3 : 0
                 * N5 : 1
                 * N4 : 0
                 * SUMBIG : 17
                 * DRAWCODE : 0
                 * N14 : 1
                 * N13 : 8
                 * N16 : 1
                 * N15 : 2
                 * SUMODD : 18
                 * N18 : 0
                 * N17 : 0
                 * N19 : 1
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

                public int getDRAWCODE() {
                    return DRAWCODE;
                }

                public void setDRAWCODE(int DRAWCODE) {
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

                public int getSUMODD() {
                    return SUMODD;
                }

                public void setSUMODD(int SUMODD) {
                    this.SUMODD = SUMODD;
                }

                public int getN18() {
                    return N18;
                }

                public void setN18(int N18) {
                    this.N18 = N18;
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

        public static class Bnum5Bean {
            /**
             * occ2 : {"ISSUE":0,"TIGER":0,"DRAGON":0}
             * avgMiss : {"ISSUE":0,"TIGER":1,"DRAGON":0}
             * lastMiss : {"ISSUE":0,"TIGER":0,"DRAGON":1}
             * maxCont : {"ISSUE":0,"TIGER":3,"DRAGON":8}
             * maxMiss : {"ISSUE":0,"TIGER":8,"DRAGON":3}
             * probability : {"ISSUE":0,"TIGER":40000,"DRAGON":60000}
             * occ : {"ISSUE":0,"TIGER":12,"DRAGON":18}
             */

            private Occ2BeanXXXX occ2;
            private AvgMissBeanXXXX avgMiss;
            private LastMissBeanXXXX lastMiss;
            private MaxContBeanXXXX maxCont;
            private MaxMissBeanXXXX maxMiss;
            private ProbabilityBeanXXXX probability;
            private OccBeanXXXX occ;

            public Occ2BeanXXXX getOcc2() {
                return occ2;
            }

            public void setOcc2(Occ2BeanXXXX occ2) {
                this.occ2 = occ2;
            }

            public AvgMissBeanXXXX getAvgMiss() {
                return avgMiss;
            }

            public void setAvgMiss(AvgMissBeanXXXX avgMiss) {
                this.avgMiss = avgMiss;
            }

            public LastMissBeanXXXX getLastMiss() {
                return lastMiss;
            }

            public void setLastMiss(LastMissBeanXXXX lastMiss) {
                this.lastMiss = lastMiss;
            }

            public MaxContBeanXXXX getMaxCont() {
                return maxCont;
            }

            public void setMaxCont(MaxContBeanXXXX maxCont) {
                this.maxCont = maxCont;
            }

            public MaxMissBeanXXXX getMaxMiss() {
                return maxMiss;
            }

            public void setMaxMiss(MaxMissBeanXXXX maxMiss) {
                this.maxMiss = maxMiss;
            }

            public ProbabilityBeanXXXX getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBeanXXXX probability) {
                this.probability = probability;
            }

            public OccBeanXXXX getOcc() {
                return occ;
            }

            public void setOcc(OccBeanXXXX occ) {
                this.occ = occ;
            }

            public static class Occ2BeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class AvgMissBeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 1
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class LastMissBeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 1
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxContBeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 3
                 * DRAGON : 8
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxMissBeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 8
                 * DRAGON : 3
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class ProbabilityBeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 40000
                 * DRAGON : 60000
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class OccBeanXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 12
                 * DRAGON : 18
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }
        }

        public static class Bnum4Bean {
            /**
             * occ2 : {"ISSUE":0,"TIGER":0,"DRAGON":0}
             * avgMiss : {"ISSUE":0,"TIGER":0,"DRAGON":1}
             * lastMiss : {"ISSUE":0,"TIGER":0,"DRAGON":1}
             * maxCont : {"ISSUE":0,"TIGER":5,"DRAGON":4}
             * maxMiss : {"ISSUE":0,"TIGER":4,"DRAGON":5}
             * probability : {"ISSUE":0,"TIGER":60000,"DRAGON":40000}
             * occ : {"ISSUE":0,"TIGER":18,"DRAGON":12}
             */

            private Occ2BeanXXXXX occ2;
            private AvgMissBeanXXXXX avgMiss;
            private LastMissBeanXXXXX lastMiss;
            private MaxContBeanXXXXX maxCont;
            private MaxMissBeanXXXXX maxMiss;
            private ProbabilityBeanXXXXX probability;
            private OccBeanXXXXX occ;

            public Occ2BeanXXXXX getOcc2() {
                return occ2;
            }

            public void setOcc2(Occ2BeanXXXXX occ2) {
                this.occ2 = occ2;
            }

            public AvgMissBeanXXXXX getAvgMiss() {
                return avgMiss;
            }

            public void setAvgMiss(AvgMissBeanXXXXX avgMiss) {
                this.avgMiss = avgMiss;
            }

            public LastMissBeanXXXXX getLastMiss() {
                return lastMiss;
            }

            public void setLastMiss(LastMissBeanXXXXX lastMiss) {
                this.lastMiss = lastMiss;
            }

            public MaxContBeanXXXXX getMaxCont() {
                return maxCont;
            }

            public void setMaxCont(MaxContBeanXXXXX maxCont) {
                this.maxCont = maxCont;
            }

            public MaxMissBeanXXXXX getMaxMiss() {
                return maxMiss;
            }

            public void setMaxMiss(MaxMissBeanXXXXX maxMiss) {
                this.maxMiss = maxMiss;
            }

            public ProbabilityBeanXXXXX getProbability() {
                return probability;
            }

            public void setProbability(ProbabilityBeanXXXXX probability) {
                this.probability = probability;
            }

            public OccBeanXXXXX getOcc() {
                return occ;
            }

            public void setOcc(OccBeanXXXXX occ) {
                this.occ = occ;
            }

            public static class Occ2BeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 0
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class AvgMissBeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 1
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class LastMissBeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 0
                 * DRAGON : 1
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxContBeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 5
                 * DRAGON : 4
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class MaxMissBeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 4
                 * DRAGON : 5
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class ProbabilityBeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 60000
                 * DRAGON : 40000
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
                }

                public int getDRAGON() {
                    return DRAGON;
                }

                public void setDRAGON(int DRAGON) {
                    this.DRAGON = DRAGON;
                }
            }

            public static class OccBeanXXXXX {
                /**
                 * ISSUE : 0
                 * TIGER : 18
                 * DRAGON : 12
                 */

                private int ISSUE;
                private int TIGER;
                private int DRAGON;

                public int getISSUE() {
                    return ISSUE;
                }

                public void setISSUE(int ISSUE) {
                    this.ISSUE = ISSUE;
                }

                public int getTIGER() {
                    return TIGER;
                }

                public void setTIGER(int TIGER) {
                    this.TIGER = TIGER;
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
}
