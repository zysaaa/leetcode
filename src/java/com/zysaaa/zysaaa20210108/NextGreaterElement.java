package com.zysaaa.zysaaa20210108;

import java.util.Arrays;

/**
 * @description: 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

 * @author:zysaaa
 * @date: 2021/1/8 19:47
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(nextGreaterElement(new int[] {2, 4}, new int[] {1,2,3,4})));

    }

    // num1 是 num2 的子集
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int len = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len2 && !flag; j++) {
                // 先找到
                if (nums2[j] == nums1[i] && j != len2 - 1) {
                    // 再次开始遍历
                    for (int o = j+1; o < len2; o++) {
                        if (nums2[o] > nums1[i]) {
                            result[i] = nums2[o];
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (result[i] == 0)
                result[i] = -1;
        }
        return result;
    }
}
