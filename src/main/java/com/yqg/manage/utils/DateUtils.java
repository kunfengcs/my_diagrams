package com.yqg.manage.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    private DateUtils() {
        throw new UnsupportedOperationException(this.getClass().getName() + " is a tool class, can't be created instance!");
    }

    public static String convertTimeToString(long longTime) {
        return convertTimeToString(longTime, "yyyy-MM-dd HH:mm:ss");
    }

    public static String convertTimeToString(long longTime, String format) {
        try {
            Timestamp t = new Timestamp(longTime * 1000L);
            SimpleDateFormat sDateFormat = new SimpleDateFormat(format);
            return sDateFormat.format(t);
        } catch (Exception var5) {
            throw new RuntimeException("Can't format the time by format[" + format + "]!");
        }
    }

    public static long convertTimeToLong(String dateTime) {
        return convertTimeToLong(dateTime, "yyyy-MM-dd HH:mm:ss");
    }

    public static long convertTimeToLong(String dateTime, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long date = 0L;

        try {
            Date d = sdf.parse(dateTime);
            date = d.getTime() / 1000L;
            return date;
        } catch (Exception var6) {
            throw new RuntimeException("Can't format the time by format[" + format + "]!");
        }
    }

    public static long getCurrentLongTime() {
        return System.currentTimeMillis() / 1000L;
    }

    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentTime(String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(new Date());
        } catch (Exception var2) {
            throw new RuntimeException("Can't format the time by format[" + format + "]!");
        }
    }

    public static long getDayBetweenDateAndDate(String startDate, String endDate) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0L;

        try {
            Date date = myFormatter.parse(endDate);
            Date mydate = myFormatter.parse(startDate);
            day = (date.getTime() - mydate.getTime()) / 86400000L;
            return day;
        } catch (Exception var7) {
            throw new RuntimeException("Time format[" + startDate + "][" + endDate + "] is error ! format must be 'yyyy-MM-dd'！");
        }
    }

    public static int getWeekday(String dateTime) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = myFormatter.parse(dateTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(7) - 1 < 0 ? 0 : cal.get(7) - 1;
        } catch (ParseException var4) {
            throw new RuntimeException("Time format[" + dateTime + "] is error ! format must be 'yyyy-MM-dd'！");
        }
    }

    public static String getPreWeekFirstDay() {
        Calendar cd = Calendar.getInstance();
        int week = cd.get(7) == 1 ? 8 : cd.get(7);
        int mondayPlus = week - 1 == 1 ? 0 : 1 - (week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus - 7);
        Date monday = currentDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(monday);
    }

    public static String getPreWeekLastDay() {
        Calendar cd = Calendar.getInstance();
        int week = cd.get(7) == 1 ? 8 : cd.get(7);
        int mondayPlus = week - 1 == 1 ? 0 : 1 - (week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus - 1);
        Date monday = currentDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(monday);
    }

    public static String getNextWeekFirstDay() {
        Calendar cd = Calendar.getInstance();
        int week = cd.get(7) == 1 ? 8 : cd.get(7);
        int mondayPlus = week - 1 == 1 ? 0 : 1 - (week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 7);
        Date monday = currentDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(monday);
    }

    public static String getNextWeekLastDay() {
        Calendar cd = Calendar.getInstance();
        int week = cd.get(7) == 1 ? 8 : cd.get(7);
        int mondayPlus = week - 1 == 1 ? 0 : 1 - (week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 7 + 6);
        Date monday = currentDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(monday);
    }

    public static String getWeekFirstDay() {
        Calendar cd = Calendar.getInstance();
        int week = cd.get(7) == 1 ? 8 : cd.get(7);
        int mondayPlus = week - 1 == 1 ? 0 : 1 - (week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus);
        Date monday = currentDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(monday);
    }

    public static String getWeekLastDay() {
        Calendar cd = Calendar.getInstance();
        int week = cd.get(7) == 1 ? 8 : cd.get(7);
        int mondayPlus = week - 1 == 1 ? 0 : 1 - (week - 1);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(5, mondayPlus + 6);
        Date monday = currentDate.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(monday);
    }

    public static String getPreMonthFirstDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getPreMonthLastDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, -1);
        lastDate.set(5, 1);
        lastDate.roll(5, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getMonthFirstDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getMonthLastDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.set(5, 1);
        lastDate.add(2, 1);
        lastDate.add(5, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getNextMonthFirstDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, 1);
        lastDate.set(5, 1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getNextMonthLastDay() {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(2, 1);
        lastDate.set(5, 1);
        lastDate.roll(5, -1);
        str = sdf.format(lastDate.getTime());
        return str;
    }

    public static String getBeforeAfterDate(String dateTime, int day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date oldDate = null;

        try {
            df.setLenient(false);
            oldDate = new Date(df.parse(dateTime).getTime());
        } catch (ParseException var11) {
            throw new RuntimeException("Time format[" + dateTime + "] is error ! format must be 'yyyy-MM-dd'！");
        }

        Calendar cal = new GregorianCalendar();
        cal.setTime(oldDate);
        int Year = cal.get(1);
        int Month = cal.get(2);
        int Day = cal.get(5);
        int NewDay = Day + day;
        cal.set(1, Year);
        cal.set(2, Month);
        cal.set(5, NewDay);
        Date date = new Date(cal.getTimeInMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
