package com.zyz.mybatis.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A6日期相关.B3日期格式化.Demo2
 * @Author: zhengyuzhu
 * @Description: TODO
 * @Version: 1.0
 */
public class DateUtil {

    /**
     * @description: 获取当前系统时间戳（毫秒级别）
     * @author: zhengyuzhu
     * @return: long
     **/
    public static long getCurrentTimeStamp(){
        return System.currentTimeMillis();
    }

    /**
     * 将指定格式的日期字符串转换为秒级别的时间戳
     *
     * @param dateTimeStr 日期字符串，例如 "2024-10-16 14:30:45"
     * @param pattern     日期格式，例如 "yyyy-MM-dd HH:mm:ss"
     * @return 返回秒级别的时间戳
     */
    public static long convertToTimestampInSeconds(String dateTimeStr, String pattern) {
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // 将字符串转换为 LocalDateTime 对象
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, formatter);

        // 将 LocalDateTime 转换为时间戳（毫秒秒级）
        return localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    /**
     * @description: 将时间戳毫秒级别转换为格式化日期字符串
     * @author: zhengyuzhu
     * @param: timestamp
     * @param: pattern
     * @return: java.lang.String
     **/
    public static String formatTimestamp(Long timestamp, String pattern) {
        if (timestamp == null) {
            return null;
        }
        // 直接处理毫秒级别的时间戳
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        return dateTime.format(formatter);
    }

    /**
     * @description: 日期时间戳转换方法
     * @author: zhengyuzhu
     * @param: startTime
     * @param: EndTime
     * @return: java.lang.Long
     **/
    public static long[] getTimestampRange(String applyStartDate, String applyDeadLine) throws Exception {
        long begDateTimeTimestamp = 0;
        long endDateTimeTimestamp = 0;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            // 判断起始时间和结束时间
            if (!"".equals(applyStartDate) && !"".equals(applyDeadLine)) {
                // 增加时分秒后缀
                applyStartDate += " 00:00:00";
                applyDeadLine += " 23:59:59";

                // 转换为毫秒级别的时间戳
                begDateTimeTimestamp = simpleDateFormat.parse(applyStartDate).getTime();
                endDateTimeTimestamp = simpleDateFormat.parse(applyDeadLine).getTime();

            } else if (!"".equals(applyStartDate) && "".equals(applyDeadLine)) {
                applyStartDate += " 00:00:00";
                Date endDateTime = new Date();

                begDateTimeTimestamp = simpleDateFormat.parse(applyStartDate).getTime();
                endDateTimeTimestamp = endDateTime.getTime();

            } else if ("".equals(applyStartDate) && !"".equals(applyDeadLine)) {
                Date begDateTime = simpleDateFormat.parse("1970-01-01 00:00:00");
                applyDeadLine += " 23:59:59";

                begDateTimeTimestamp = begDateTime.getTime();
                endDateTimeTimestamp = simpleDateFormat.parse(applyDeadLine).getTime();
            } else if("".equals(applyStartDate) && "".equals(applyDeadLine)){
                begDateTimeTimestamp = 0;
                endDateTimeTimestamp = 0;
            }

        } catch (Exception e) {
            throw new Exception("时间戳转换错误", e);
        }

        // 返回毫秒级别的开始和结束时间戳数组
        return new long[]{begDateTimeTimestamp, endDateTimeTimestamp};
    }

}
