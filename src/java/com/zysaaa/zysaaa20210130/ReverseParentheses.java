package com.zysaaa.zysaaa20210130;

/**
 * @description: 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * @author:zysaaa
 * @date: 2021/1/30 17:30
 */
public class ReverseParentheses {


    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == ')') {
                // 倒推回去，找到第一个'('
                for (int j = i - 1; ;j --) {
                    if (chars[j] == '(') {
                        // 开始翻转，且去除这一对括号
                        s = s.substring(0, j) + reverse(s.substring(j + 1, i)) + s.substring(i + 1);
                        return reverseParentheses(s);
                    }
                }
            }
        }
        return s;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
