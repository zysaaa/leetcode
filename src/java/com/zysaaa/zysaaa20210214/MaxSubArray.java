package com.zysaaa.zysaaa20210214;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }

}
