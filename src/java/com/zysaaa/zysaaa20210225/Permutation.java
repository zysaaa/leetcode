package com.zysaaa.zysaaa20210225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/permutation-i-lcci/
 * @author:zysaaa
 * @date: 2021/2/28 20:43
 */
public class Permutation {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("qwe")));
    }
    public String[] permutation(String S) {
        if (S == null || S.equals("")) {
            return null;
        }

        char[] chars = S.toCharArray();
        int length = chars.length;

        return dfs(chars, 0);
    }

    public String[] dfs(char[] chars, int begin) {
        if (begin == chars.length) {
            return null;
        }
        if (chars.length == begin+1) {
            return new String[]{String.valueOf(chars[begin])};
        }

        char first = chars[begin];
        String[] others = dfs(chars, begin + 1);

        List<String> list = new ArrayList<>();
        for (String s : others) {
            int length = s.length();
            for (int i = 0; i <= length; i++) {
                char[] tmp = new char[length + 1];

                for (int j = 0; j <= length; j++) {
                    if (j == i) {
                        tmp[j] = first;
                    } else {
                        if (j < i) {
                            tmp[j] = s.charAt(j);
                        } else {
                            tmp[j] = s.charAt(j - 1);
                        }
                    }
                }
                list.add(new String(tmp));
            }
        }
        return list.toArray(new String[0]);

    }
}
