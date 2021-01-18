package com.zysaaa.zysaaa20210118;

/**
 * @description: 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 *  注意和摩尔的差别 see {@link com.zysaaa.zysaaa20210110.MajorityElement}
 *
 *
 * @author:zysaaa
 * @date: 2021/1/18 21:21
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 0)
            return -1;

        int flag = 0;
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
            if (count == 0) {
                flag = nums[i];
            }
            if (nums[i] == flag) {
                count++;
            } else {
                count--;
            }

        }
        // 验证
        int tmp = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == flag)
                tmp++;
        }
        return tmp > nums.length / 2 ? flag : -1;
    }
}
