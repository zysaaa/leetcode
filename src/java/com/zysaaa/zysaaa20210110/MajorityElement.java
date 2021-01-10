package com.zysaaa.zysaaa20210110;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author:zysaaa
 * @date: 2021/1/10 9:17
 */
public class MajorityElement {

    public static void main(String[] args) {
        majorityElement2(new int[] {2, 2});


    }

    // 不能再笨的解法了  最简单的：排序取中间。
    public static int majorityElement(int[] nums) {
        int length = nums.length;

        int halfLength = length / 2;

        Map<String, Integer> stat = new HashMap<>();
        for (int num : nums) {
            if (stat.containsKey(String.valueOf(num))) {
                stat.put(String.valueOf(num), stat.get(String.valueOf(num)) + 1);
            } else {
                stat.put(String.valueOf(num), 1);
            }
            if (stat.get(String.valueOf(num)) > halfLength) {
                return num;
            }
        }
        return 0;
//        final int[] result = new int[1];
//        stat.forEach((k, v) -> {
//            if (v > halfLength) {
//                result[0] = Integer.parseInt(k);
//            }
//        });
//        return result[0];

    }

    // 摩尔投票---- 抵消
    public static int majorityElement2(int[] nums) {
        int result = 0;
        int num = 0;
        for (int i : nums) {
            if (num == 0) {
                result = i;
            }
            num += (result == i) ? 1 : -1;
        }
        return result;
    }


}
