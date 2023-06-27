package com.yqg.manage.utils;

import org.springframework.util.DigestUtils;

import java.util.Scanner;

public class MD5 {
    public static void main(String[] args) {
        new MD5().md5();
    }
    private void md5(){
        System.out.println("请输入加密：");
        System.err.println(DigestUtils.md5DigestAsHex(new Scanner(System.in).next().getBytes()));
    }
}

