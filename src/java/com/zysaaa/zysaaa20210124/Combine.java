package com.zysaaa.zysaaa20210124;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combinations
 *
 *  

 *
 * @author:zysaaa
 * @date: 2021/1/24 20:51
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(combine(2,2));
    }

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(list, n, k, 1);
        return result;
    }

    public  static void dfs(List<Integer> list, int n, int k, int begin) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n; i++) {
            list.add(i);
            System.out.println("前：" + list);
            dfs(list, n, k, i + 1);
            System.out.println("后：" + list);

            list.remove(list.size() - 1);
        }
    }
}
