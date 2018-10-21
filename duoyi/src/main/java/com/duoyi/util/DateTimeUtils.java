package com.duoyi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *   描述: 时间(Time)转换工具类
 *        1. 秒数转可读时间  格式为(hh):mm:ss
 *        2. 毫秒数转可读时间  格式为(hh):mm:ss
 *        3. java.util.date的格式化
 * </p>
 * @author Kanarien 
 * @version 1.0
 * @date 2017年11月13日 下午10:15:16
 */
public class DateTimeUtils {

    private static final String MIN_TIME = "00:00";
    private static final String MAX_TIME = "99:59:59";
    private static final String TIME_SEPARATOR = ":";
    private static final DateFormat formatDateTimeCN = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    private static final DateFormat formatDateCN = new SimpleDateFormat("yyyy年MM月dd日");
    private static final DateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    
    public static String secondToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return MIN_TIME;
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + TIME_SEPARATOR + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return MAX_TIME;
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + TIME_SEPARATOR + unitFormat(minute) + TIME_SEPARATOR + unitFormat(second);
            }
        }
        return timeStr;
    }
    
    public static String milisToTime(long time) {
        int second = (int) (time / 1000);
        return secondToTime(second);
    }
    
    private static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
    
    /**
     * <p>
     *    描述：日期转换  格式为：yyyy年MM月dd日 HH:mm:ss
     * </p>
     * @param date
     * @return
     */
    public static String formatDateTimeCN(Date date) {
        return formatDateTimeCN.format(date);
    }
    
    /**
     * <p>
     *    描述：日期转换  格式为: yyyy年MM月dd日
     * </p>
     * @param date
     * @return
     */
    public static String formatDateCN(Date date) {
        return formatDateCN.format(date);
    }
    
    /**
     * <p>
     *    描述：日期转换  格式为: yyyy-MM-dd HH:mm:ss
     * </p>
     * @param date
     * @return
     */
    public static String formatDateTime(Date date) {
        return formatDateTime.format(date);
    }
    
    /**
     * <p>
     *    描述：日期转换  格式为: yyyy-MM-dd
     * </p>
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return formatDate.format(date);
    }
    
}
