package com.yqg.manage.utils;

import org.springframework.util.DigestUtils;

/**
 *  加密假烟
 */
public class MD5Util {
    //密码加密
    public static String getMD5Password(String password , String salt){
        //MD5加密算法的调用
        for (int i = 0; i < 3; i++) {
            //进行三次加密
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

    public static void main(String[] args) {
        System.out.println(getMD5Password("123456","admin"));
    }
}
