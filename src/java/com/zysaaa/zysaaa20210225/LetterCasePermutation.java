package com.zysaaa.zysaaa20210225;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/letter-case-permutation/
 * @author:zysaaa
 * @date: 2021/2/28 21:18
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b"));
    }

    public List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        dfs(S, 0);
        result.add(S);
        return result;
    }

    private void dfs(String S, int i) {
        if (i == S.length()) {
            return;
        }
        if (Character.isLetter(S.charAt(i))) {
            char[] chars = S.toCharArray();
            chars[i] = Character.isLowerCase(chars[i]) ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]);
            result.add(new String(chars));
            dfs(new String(chars), i+1);
        }
        dfs(S, i+1);
    }

}
