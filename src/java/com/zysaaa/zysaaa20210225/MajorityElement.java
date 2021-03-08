package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/majority-element/
 * @author:zysaaa
 * @date: 2021/3/8 20:56
 */
public class MajorityElement {
    public static void main(String[] args) {

        System.out.println(new MajorityElement().majorityElement(new int[]{6,5,5}));

    }

    public int majorityElement(int[] nums) {
        int result = 0;

        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                result = num;
                count++;
            } else {
                count += (result == num) ? 1 : -1;
            }

        }
        return result;

    }
}
