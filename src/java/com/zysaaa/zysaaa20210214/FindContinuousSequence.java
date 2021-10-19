package com.zysaaa.zysaaa20210214;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 *
 * form website:
 *         //套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
 *         //当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().findContinuousSequence(9));
    }

    public int[][] findContinuousSequence(int target) {
        if (target == 1) {
            return new int[0][0];
        }
        List<int[]> list = new ArrayList<>();
        int left = 1;
        int right = 2;
        int end = target % 2 == 0 ? target / 2 : target / 2 + 1;

        while (left < right && right <= end) {
            if ((left + right) *  (right - left + 1) / 2 == target) {
                int[] hit = new int[(right - left) + 1];
                for (int i = 0; i < hit.length; i++) {
                    hit[i] = left + i;
                }
                list.add(hit);
                left++;
            } else if ((left + right) *  (right - left + 1) / 2 < target) {
                right ++;
            } else {
                left ++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
