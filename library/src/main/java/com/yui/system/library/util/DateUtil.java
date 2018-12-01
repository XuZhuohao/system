package com.yui.system.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具
 *
 * @author XuZhuohao
 * @date 2018-10-31 22:00
 */
public class DateUtil {

    public static String getMMdd(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("MMdd");
        return sf.format(date);
    }

    /**
     * 获取当前天，1-365（366）
     * @param date 传入时间
     * @return d
     */
    public static int getD(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("D");
        return Integer.valueOf(sf.format(date));
    }

    /**
     * 获取当前年份的，D所属时间
     * @param D 第几天， 0 - 366（265）
     * @return date
     */
    public static Date getDateByD(int D){
        String date = getDateStr(new Date(), "YYYY") + getMMdd(getDate(String.valueOf(D), "D"));
        return getDate(date, "yyyyMMdd");
    }
    /**
     * 获取当前天，1-365（366）
     * @param date 传入时间
     * @return YYYYMM
     */
    public static int getYYYYMM(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("YYYYMM");
        return Integer.valueOf(sf.format(date));
    }

    /**
     * 返回时间字符格式
     * @param date 时间
     * @param format 类型，如： YY, YYYY, MM, dd
     * @return 时间字符格式
     */
    public static String getDateStr(Date date, String format){
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * 获取时间对象
     * @param dateStr 时间，如 20181001
     * @param format 格式， 如 yyyyMMdd
     * @return 转换后时间
     */
    public static Date getDate(String dateStr, String format){
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date date;
        try {
            date = sf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期转换失败，date=" + dateStr + ";  format:" + format);
        }
        return date;
    }
}
