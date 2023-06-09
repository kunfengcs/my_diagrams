package com.yqg.manage.utils;



import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeUtils {
    // 模板
    public static final String PATTERN_DATE8 = "yyyyMMdd";

    public static final String PATTERN_DATE8_2 = "yyyy-MM-dd";

    public static final String PATTERN_TIME6 = "HHmmss";

    public static final String PATTERN_TIME14 = "yyyyMMddHHmmss";

    public static final String PATTERN_TIME14_2 = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_TIME17 = "yyyyMMddHHmmssSSS";

    public static String getFormattedDate(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
    }

    public static String getFormattedDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * <p>
     * Description 获取当前日期的上个月
     * </p>
     * @return
     */
    public static String getFormattedLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String time = format.format(c.getTime());
        return time;
    }

    public static String getFormattedTime(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        }
    }

    /**
     * 格式：yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String getFormattedTime2(Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sdf.format(date);
        }
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：20050828143158
     * <p>
     *
     * @return String
     */
    public static String getTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：20050828
     * <p>
     *
     * @return String
     */
    public static String getDateStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回多少天前系统时间组成的字符串。例如：20050828
     * <p>
     *
     * @return String
     */
    public static String getDateStamp(int time) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0 - time);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：2005-08-28
     * <p>
     *
     * @return String
     */
    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：2005-08-28 14:20:36
     * <p>
     *
     * @return String
     */
    public static String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：200508
     * <p>
     *
     * @return String
     */
    public static String getMonthStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }

    /**
     * 返回某年某月的天数
     *
     * @param year
     *            int
     * @param month
     *            int
     * @return int
     */
    public static int getDays(int year, int month) {
        int days = 30;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
        }
        return days;
    }

    /**
     * Returns true if the specified date string represents a valid date in the
     * specified format.
     *
     * @param dateString
     *            a String representing a date/time.
     * @param dateFormatPattern
     *            a String specifying the format to be used when parsing the
     *            dateString. The pattern is expressed with the pattern letters
     *            defined for the java.text.SimpleDateFormat class.
     * @return boolean - return true if valid, false otherwise.
     */
    public static boolean isValidDate(String dateString, String dateFormatPattern) {

//        // 长度校验追加
//        if (StringUtil.isEmpty(dateString) || StringUtil.isEmpty(dateFormatPattern)) {
//            return false;
//        }

        if (dateString.length() != dateFormatPattern.length()) {
            return false;
        }
        // 长度校验追加

        Date validDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
            sdf.setLenient(false);
            validDate = sdf.parse(dateString);
        } catch (ParseException e) {
            return validDate != null;
        }

        return validDate != null;
    }

    public static Date string2Date(String date, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw e;
        }

    }

    public static String date2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     *
     * @return 当前时间
     */
    public static Date getNowTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     *
     * @return 当前时间
     */
    public static long getNowTimeInMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * <p>
     * 返回系统时间组成的字符串。例如：20050828143158333
     * <p>
     *
     * @return String
     */
    public static String getTimeMillisecondStamp() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date);
    }

    /**
     * <p>
     * 返回多少天后系统时间组成的字符串。例如：20050828143158333
     * <p>
     *
     * @return String
     */
    public static String getTimeMillisecondStamp(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date);
    }

    public static String transformTime(String date, String sourceFormat, String destFormat) throws Exception {
        SimpleDateFormat sdfSource = new SimpleDateFormat(sourceFormat);
        Date dateSource = sdfSource.parse(date);
        SimpleDateFormat sdfDest = new SimpleDateFormat(destFormat);
        return sdfDest.format(dateSource);
    }

    public static Timestamp stringToTimestamp(String datetime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Timestamp ts = new Timestamp(formatter.parse(datetime).getTime());
        return ts;
    }

    public static String addDays(int days) {
        String fromTime = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, days);

        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        fromTime = sdf.format(date);
        return fromTime;
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static String addDays(String dateStr, int days) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setLenient(false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(dateStr));
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }

    /**
     * 小时变化
     *
     * @param timeStr
     * @param hours
     * @return
     * @throws ParseException
     */
    public static String addHours(String timeStr, int hours) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        sdf.setLenient(false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(timeStr));
        calendar.add(Calendar.HOUR, hours);
        return sdf.format(calendar.getTime());
    }

    /**
     * 判断time1与time2的大小；如果time1大于time2,则返回true;否则返回false;
     *
     * @param time1
     * @param time2
     * @param pattern
     *            time1与time2均符合pattern模式
     * @return
     * @throws ParseException
     */
    public static boolean isAfter(String time1, String time2, String pattern) throws ParseException {
        Date date1 = TimeUtils.string2Date(time1, pattern);
        Date date2 = TimeUtils.string2Date(time2, pattern);
        long tim1 = date1.getTime();
        long tim2 = date2.getTime();

        return tim1 > tim2;
    }

    /**
     * 计算当前时间到下offset个整点的时间
     *
     * @param offset
     *            小时个数，比如计算当前时间到下一个整点的时间，传值为1；到第二个整点，则传值为2；依次类推
     * @return
     */
    public static long nextHourDelay(int offset) {
        Calendar calendar = Calendar.getInstance();
        long currTime = calendar.getTimeInMillis();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.set(Calendar.HOUR_OF_DAY, hour + offset);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long nextHourTime = calendar.getTimeInMillis();

        return nextHourTime - currTime;
    }

    /**
     * <p>
     * Description:获取指定月份的最后一天：举例 202302 获取到 20230226
     * </p>
     *
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(month.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.valueOf(month.substring(4)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH,-1);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * <p>
     * Description 获取指定日期当月第一天。比如20230226，当月第一天是20230201
     * </p>
     *
     * @param date
     * @return
     */
    public static String getFirstDayOfMonth(String date) {
        String s = date.substring(0, 6) + "01";
        return s;
    }

    /**
     * <p>
     * Description 获取指定日期的前一天，比如20230226前一天是20230225
     * </p>
     *
     * @param date
     * @return
     */
    public static String getBeforeDay(String date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(date.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.valueOf(date.substring(4, 6)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date.substring(6)));
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * <p>
     * Description:获取指定年月有多少天
     * </p>
     *
     * @param month
     * @return
     */
    public static int getDayNumberByMonth(String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(month.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.valueOf(month.substring(4)) - 1);
        int dayNumber = cal.getActualMaximum(Calendar.DATE);
        return dayNumber;
    }

    /**
     * <p>
     * Description 举例：date=20230226 返回值是20230226000000000
     *
     * @param date
     */
    public static String getNextDayTime(String date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.valueOf(date.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.valueOf(date.substring(4, 6)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date.substring(6)));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        String s = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
        return s + "000000000";
    }

}
