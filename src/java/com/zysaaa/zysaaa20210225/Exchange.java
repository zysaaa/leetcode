package com.zysaaa.zysaaa20210225;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/13 18:32
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];

        int aIdx = 0;
        int bIdx = nums.length - 1;
        for (int n : nums) {
            if (n % 2 == 0) {
                result[bIdx--] = n;
            } else {
                result[aIdx++] = n;
            }
        }
        return result;

    }

    // 维持先后顺序
    public int[] exchange2(int[] nums) {

        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {

            } else {
                idx = i;
            }
        }
        return nums;
    }
}
