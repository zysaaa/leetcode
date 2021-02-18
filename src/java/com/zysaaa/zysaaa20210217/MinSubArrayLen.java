package com.zysaaa.zysaaa20210217;

/**
 * @description: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @author:zysaaa
 * @date: 2021/2/17 21:02
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        // 移动窗口

        int left = 0;
        int right = 1;

        int result = 0;

        while (left <= nums.length && right <= nums.length) {
            int sum = 0;
            for (int i = left; i < right; i++) {
                sum += nums[i];
            }
            if (sum < target) {
                right++;
            } else {
                if (result != 0) {
                    result = Math.min(result, (right - left));
                } else {
                    result = (right - left);
                }
                left++;
            }
        }
        return result;

    }
}
