package com.zysaaa.zysaaa20210116;

/**
 * @description: 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @author:zysaaa
 * @date: 2021/1/16 22:44
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("cc"));


    }

    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char result = chars[i];
            boolean find = false;
            for (int j = 0; j < chars.length; j++) {
                if (i != j && chars[j] == result) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                return result;
            }
        }
        return ' ';
    }
}
