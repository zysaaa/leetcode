package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/maximum-subarray/
 * @author:zysaaa
 * @date: 2021/3/15 22:13
 */
public class MaxSubArray222444 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}
