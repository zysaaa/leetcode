package com.zysaaa.zysaaa20210225;

public class MaxSubArray3456 {

    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;




    }

}
