package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/maximum-subarray/
 * @author:zysaaa  --错误的  从index=1开始
 * @date: 2021/3/9 21:44
 */
public class MaxSubArray222 {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];
        for (int num : nums) {

            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            result = Math.max(sum, result);

        }
        return result;
    }
}
