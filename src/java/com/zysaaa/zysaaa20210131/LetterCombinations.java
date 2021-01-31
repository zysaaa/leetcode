package com.zysaaa.zysaaa20210131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/31 12:24
 */
public class LetterCombinations {

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("234");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return transfer(digits);
        }
        List<String> transfer = transfer(digits.substring(0, 1));
        List<String> transfer2 = letterCombinations(digits.substring(1));
        List<String> result = new ArrayList<>();
        for (String s1 : transfer) {
            for (String s2 : transfer2) {
                result.add(s1 + s2);
            }
        }
        return result;

    }


    public List<String> transfer(String s) {
        if (s.equals("9")) {
            return Arrays.asList("w", "x", "y", "z");
        }
        if (s.equals("8")) {
            return Arrays.asList("t", "u", "v");
        }
        if (s.equals("7")) {
            return Arrays.asList("p", "q", "r", "s");
        }
        if (s.equals("6")) {
            return Arrays.asList("m", "n", "o");
        }
        if (s.equals("5")) {
            return Arrays.asList("j", "k", "l");
        }
        if (s.equals("4")) {
            return Arrays.asList("g", "h", "i");
        }
        if (s.equals("3")) {
            return Arrays.asList("d", "e", "f");
        }
        if (s.equals("2")) {
            return Arrays.asList("a", "b", "c");
        }

        return null;
    }





}
