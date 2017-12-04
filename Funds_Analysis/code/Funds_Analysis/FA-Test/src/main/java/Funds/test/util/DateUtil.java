package Funds.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Description: [描述]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/12/1
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class DateUtil {
    public static String formate_yyyy_MM_dd = "yyyy-MM-dd";
    public static String formate_yyyyMMdd = "yyyyMMdd";
    public static String formate_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static String formate_yyyyMMdd_HHmmss = "yyyy-MM-dd HH:mm:ss";
    public static String formate_C_yyyyMMdd = "yyyy年MM月dd日";

    /**
     * 根据时间字符获取时间
     *
     * @param dtStr
     * @param formate
     * @return
     */
    public static Date parseToDate(String dtStr,String formate){
        SimpleDateFormat dft = new SimpleDateFormat(formate);
        try {
            return dft.parse(dtStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
