package com.yqg.manage.utils;


/**
 * @author suzhongzhong~
 */
public class Constants {
    // 相等
    public static final int EQUAL_TRUE = 0;
    // 不等
    public static final int EQUAL_FALSE = -1;
    // 没有初始时间
    public static final int NO_TIME = 0;
    // 执行sql结果失败
    public static final int FAILURE = 0;
    // 开始位置
    public static final int START_POS = 0;
    // 第二个位置
    public static final int SECOND_POS = 1;
    // 计数
    public static final int COUNT_ZERO = 0;
    // 毫秒转秒
    public static final int COVERT_TIME_1000 = 1000;
    // 单条数据
    public static final int SINGLE_DATA = 1;

    // UUID长度
    public static final int UUID_LENGTH = 36;
    // 下载缓冲区大小
    public static final int DOWNLOAD_CACHE_SIZE = 4096;

    public static final class NUM{
        public static final int NUM_0 = 0;
        public static final int NUM_1 = 1;
        public static final int NUM_2 = 2;
        public static final int NUM_3 = 3;
        public static final int NUM_4 = 4;
        public static final int NUM_5 = 5;
        public static final int NUM_6 = 6;
        public static final int NUM_7 = 7;
        public static final int NUM_8 = 8;
        public static final int NUM_9 = 9;
        public static final int NUM_10 = 10;
        public static final int NUM_30 = 30;
        public static final int NUM_100 = 100;
        public static final int NUM_1000 = 1000;
        public static final long ONE_DAY_MILLIS = 86400L;
        public static final long ONE_MONTH_MILLIS = 30*86400L;
        public static final long ONE_YEAR_MILLIS = 365 * ONE_DAY_MILLIS;
        public static final int SIXCODENUM =1000000;
    }

    //过期时间
    public static final long EXPIRATION_TIME = 604800;
    public static final long EXPIRATION_TIME_DAY = 68400;
    public static final long SHORT_EXPIRATION_TIME = 60*5;


}
