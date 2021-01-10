package com.zysaaa.zysaaa20210110;

import java.util.Arrays;

/**
 * @description: 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 *
 * @author:zysaaa
 * @date: 2021/1/10 10:28
 */
public class CanConstruct {

    public static void main(String[] args) {
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            int index;
            if ( (index = contains(chars1[i], chars2)) != -1) {
                chars2[index] = 'A';
            } else {
                return false;
            }
        }
        return true;

    }

    private static int contains(char c, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

}
