package com.zysaaa.zysaaa20210108;

import java.util.Arrays;

/**
 * @description: 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。

 * @author:zysaaa
 * @date: 2021/1/8 19:10
 */
public class RunningSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum2(new int[]{1,2,3})));
    }


    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        final int length = nums.length;
        for (int i = 0; i < length; i++) {
            int tmp = 0;
            for (int j = 0; j < i+1; j++) {
                tmp += nums[j];
            }
            result[i] = tmp;
        }
        return result;
    }

    public static int[] runningSum2(int[] nums) {
        final int length = nums.length;
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
