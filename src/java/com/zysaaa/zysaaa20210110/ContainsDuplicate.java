package com.zysaaa.zysaaa20210110;

import java.util.Arrays;

/**
 * @description: 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @author:zysaaa
 * @date: 2021/1/10 10:54
 */
public class ContainsDuplicate {
    public static void main(String[] args) {


    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i + 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
