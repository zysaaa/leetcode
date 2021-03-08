package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/maximum-subarray/
 *
 * {@link MaxProfit}
 *
 * @author:zysaaa
 * @date: 2021/3/7 11:04
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];

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
// keep it until u make it. Then you can start think of other things.
