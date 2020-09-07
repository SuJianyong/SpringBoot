package com.sjy.sp_shiro.utils;

import java.util.Random;

/**
 * @作者 苏健勇
 * @创建时间 2020/9/7 16:43
 * @描述 生成随机盐值
 */
public class SaltUtils {

    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char s = chars[new Random().nextInt(chars.length)];
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(8));
    }
}
