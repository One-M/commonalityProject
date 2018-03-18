package com.ybf.lottery.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by XQyi on 2018/3/15.
 * Use: 字符串相关操作工具类
 */

public final class StringUtils {

    /**
     * 北京赛车历史开奖英文字符串
     * @param s
     * @param start
     * @param end
     */
    public static String splitString(String s , int start , int end){
        return start < end ? s.substring(start , end) : "";
    }

    /**
     * 英==>中
     * @return
     */
    public static String toChineseString(String str){

        String chineseStr = "";
        switch (str){
            case "small":
                chineseStr = "小";
                break;
            case "big":
                chineseStr = "大";
                break;
            case "odd":
                chineseStr = "单";
                break;
            case "even":
                chineseStr = "双";
                break;
            case "tiger":
                chineseStr = "虎";
                break;
            case "dragon":
                chineseStr = "龙";
                break;
        }

        return chineseStr;
    }

    /**
     * string ==> List<String>
     * @param strs
     * @return
     */
    public static List<String> stringToList(String strs){
        String str[] = strs.split(",");
        return Arrays.asList(str);
    }

}
