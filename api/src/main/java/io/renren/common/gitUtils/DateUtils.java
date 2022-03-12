package io.renren.common.gitUtils;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 *
 * @Description:
 * @Date: Created in 2018/5/30 16:19
 * @Author: Wangll
 */
public class DateUtils {

    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 比较 当前时间 返回 XX秒前 .分钟.小时..  XX天前
     *
     * @param date
     * @return
     */
    public static String formationDate(Date date) {

        String dateString = "";
        // 获取系统当前时间
        Date now = new Date();

        if (date.before(now)) {
            try {
                long endTime = now.getTime();
                long currentTime = date.getTime();
                // 计算两个时间点相差的秒数
                long seconds = (endTime - currentTime);
                if (seconds < 10 * 1000) {
                    dateString = "刚刚";
                } else if (seconds < 60 * 1000) {
                    dateString = seconds / 1000 + "秒前";
                } else if (seconds < 60 * 60 * 1000) {
                    dateString = seconds / 1000 / 60 + "分钟前";
                } else if (seconds < 60 * 60 * 24 * 1000) {
                    dateString = seconds / 1000 / 60 / 60 + "小时前";
                } else if (seconds < 60 * 60 * 24 * 1000 * 30L) {
                    dateString = seconds / 1000 / 60 / 60 / 24 + "天前";
                } else if (date.getYear() == now.getYear()) {//今年并且大于30天显示具体月日
                    dateString = new SimpleDateFormat("MM-dd").format(date.getTime());
                } else if (date.getYear() != now.getYear()) {//大于今年显示年月日
                    dateString = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
                } else {
                    dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dateString;

    }

    /**
     * 判断选择的日期是否是本月
     *
     * @param time    选择的时间
     * @param pattern 格式(yyyy-MM)
     * @return
     */
    public static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String param = sdf.format(date);//参数时间
        String now = sdf.format(new Date());//当前时间
        if (param.equals(now)) {
            return true;
        }
        return false;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
        Date today = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(today);
        return result;
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static String asStr(LocalDateTime localDateTime) {
        return asStr(0, localDateTime);
    }

    /**
     * 格式
     *
     * @param typeId 类型
     * @param Date   时间
     * @return
     */
    public static String asStr(Integer typeId, Date time) {
        return asStr(typeId, asLocalDateTime(time));
    }

    /**
     *
     * @param typeId 1. 2. 3. 4. 5.
     * @param localDateTime
     * @return
     */
    public static String asStr(Integer typeId, LocalDateTime localDateTime) {
        if (ObjectUtils.isEmpty(localDateTime)) {
            return "";
        }
        String pattern;
        switch (typeId) {
            case 1:
                pattern = "yyyy-MM-dd";
                break;
            case 2:
                pattern = "HH:mm:ss";
                break;
            case 3:
                pattern = "yyyyMMddHHmmss";
                break;
            case 4:
                pattern = "yyyy-MM-dd HH:mm:ss";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + typeId);
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 传入Data类型日期，返回字符串类型时间（ISO8601标准时间）
     * @param typeId
     * @param localDateTime
     * @param ID 时间区域 UTC、"Asia/Shanghai"、"Asia/Chongqing"
     * @return
     */
    public static String asStr(LocalDateTime localDateTime, String ID) {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        df.setTimeZone(TimeZone.getTimeZone(ID));
//        localDateTime.atOffset(ZoneOffset.UTC);
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
//        return df.format(date);
    }

    /**
     * 无符号格式
     *
     * @param localDateTime
     * @return
     */
    public static String asNoSymbolString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    ;

    /**
     * 计算耗时
     * eg:
     * //日志开始时间
     * LocalDateTime beginDate = LocalDateTime.now();
     * logger.debug(DateUtils.calculationTimeConsuming("微 信 支 付 开 始 回 调", beginDate));
     *
     * @param now 开始时间
     * @return 提示消息
     */
    public static String calculationTimeConsuming(String msg, LocalDateTime now) {
        if (null != now) {
            LocalDateTime end = LocalDateTime.now();
            Duration duration = Duration.between(now, end);
            long days = duration.toDays(); //相差的天数
            long hours = duration.toHours();//相差的小时数
            long minutes = duration.toMinutes();//相差的分钟数
            long millis = duration.toMillis();//相差毫秒数
            long nanos = duration.toNanos();//相差的纳秒数
            return msg + "耗时【 " + days + "天：" + hours + " 小时：" + minutes + " 分钟：" + millis + " 毫秒：" + nanos + " 纳秒】";
        }
        return "";
    }

    /**
     * 判断当前时间距离第二天凌晨的秒数
     *
     * @return 返回值单位为[s:秒]
     */
    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }


    public static String toAccurateDataStr() {
        long time = System.currentTimeMillis();
        Date d = new Date(time);
        Timestamp t = new Timestamp(time);
        t.setNanos(000000);
        System.out.println(d);
        System.out.println(t);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'");
        NumberFormat nf = new DecimalFormat("000000");
        return df.format(t.getTime()) + nf.format(t.getNanos() + "Z");
    }

    /**
     * @param dateTime
     * @return
     */
    @SneakyThrows
    public static Date toDate(String dateTime) {
//        System.out.println(dateTime);
        int dateTimeIndex = dateTime.lastIndexOf(".");
        if (dateTimeIndex > -1) {
            dateTime = dateTime.substring(0, dateTimeIndex);
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date ;
        try {
            date = df.parse(dateTime);
        }catch (ParseException e){
            System.out.println(dateTime + "  错误");
            return new Date();
        }
//        Timestamp t = new Timestamp(date.getTime());
//        t.setNanos(123121);
//        NumberFormat nf = new DecimalFormat("000000");
//        System.out.println(df.format(t.getTime()) + nf.format(t.getNanos()));

        return utcToLocal(date);
    }



    /**
     *
     * <p>Description:UTC时间转化为本地时间 </p>
     * @param utcTime
     * @return
     * @author wgs
     * @date  2018年10月19日 下午2:23:24
     *
     */
    public static Date utcToLocal(Date utcDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getDefault());
        Date locatlDate = null;
        String localTime = sdf.format(utcDate.getTime());
        try {
            locatlDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locatlDate;
    }

}
