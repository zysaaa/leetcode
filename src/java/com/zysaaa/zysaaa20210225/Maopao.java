package com.zysaaa.zysaaa20210225;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/30 22:01
 */
public class Maopao {
    public int[] sortArray(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            boolean flg = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flg = true;
                }

            }
            if (!flg) {
                break;
            }
        }
        return nums;

    }


}
