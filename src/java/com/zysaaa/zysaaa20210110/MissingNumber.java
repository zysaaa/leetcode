package com.zysaaa.zysaaa20210110;

import java.util.Arrays;

/**
 * @description: 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * @author:zysaaa
 * @date: 2021/1/10 9:40
 */
public class MissingNumber {

    public static void main(String[] args) {

        System.out.println(missingNumber(new int[] {0}));
    }

    public static int missingNumber(int[] nums) {
        // 求和 -sum
        int shouldSum = (nums.length) * (nums.length + 1) / 2;
        int actulSum = 0;
        for (int num : nums) {
            actulSum += num;
        }
        return shouldSum - actulSum;

    }
}
