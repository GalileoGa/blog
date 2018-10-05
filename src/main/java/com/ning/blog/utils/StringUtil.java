package com.ning.blog.utils;

/**
 * 用途：
 * 作者：郭桐宁
 * 时间：2018/10/5 16:43
 * Version:1.0
 */
public class StringUtil {
    public static String getSalt() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            str.append((char) (Math.random() * 26 + 'A'));
        }
        return str.toString();
    }

}
