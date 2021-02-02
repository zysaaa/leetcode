package com.zysaaa.zysaaa20210202;

/**
 * @description: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @author:zysaaa
 * @date: 2021/2/2 21:20
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1,3,4,2,2}));
    }

    public int findDuplicate(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i : nums) {
            tmp[i]++;
            if (tmp[i] > 1) {
                return i;
            }
        }
        return -1;
    }
}
