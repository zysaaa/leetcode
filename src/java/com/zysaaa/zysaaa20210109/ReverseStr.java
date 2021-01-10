package com.zysaaa.zysaaa20210109;

/**
 * @description: 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

 * @author:zysaaa
 * @date: 2021/1/9 20:08
 */
public class ReverseStr {

    public static void main(String[] args) {
        System.out.println(reverseStr("abc", 2));
    }

    public static String reverseStr(String s, int k) {
        String result = "";
        int length = s.length();
        int r = length / (2 * k);

        for (int i = 0; i < r; i++) {
            result += reverseStr(s.substring(i * 2 * k, i * 2 * k + k));
            result += s.substring(i * 2 * k + k , i * 2 * k + k  + k);
        }
        // 剩下的字符
        int left = length - r * 2 * k;
        if (left <= k) {
            result += reverseStr(s.substring(r * 2 * k));
        } else {
            result += reverseStr(s.substring(r * 2 * k, r * 2 * k + k));
            result += s.substring(r * 2 * k + k);
        }
        return result;

    }

    private static String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }


}
