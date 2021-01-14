package com.zysaaa.zysaaa20210114;

import java.util.*;

/**
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 此题和数组最大值、冒泡很类似，一样的思想
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @author:zysaaa
 * @date: 2021/1/14 21:39
 */
public class LetterCombinations {

    public static void main(String[] args) {

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 递归
        List<String> aChar = getChar(digits.charAt(0));
        if (digits.length() == 1) {
            return aChar;
        }
        List<String> left = letterCombinations(digits.substring(1));
        for (int i = 0; i < aChar.size(); i ++) {
            for (int j = 0; j < left.size(); j ++) {
                result.add(aChar.get(i) + left.get(j));
            }
        }
        return result;
    }

    public static List<String> getChar(char c) {
        switch(c) {
            case '2': return Arrays.asList("a", "b", "c");
            case '3': return Arrays.asList("d", "e", "f");
            case '4': return Arrays.asList("g", "h", "i");
            case '5': return Arrays.asList("j", "k", "l");
            case '6': return Arrays.asList("m", "n", "o");
            case '7': return Arrays.asList("p", "q", "r", "s");
            case '8': return Arrays.asList("t", "u", "v");
            case '9': return Arrays.asList("w", "x", "y", "z");
            default : return new ArrayList();
        }
    }
}
