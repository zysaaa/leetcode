package com.zysaaa.zysaaa20210111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 *
 * @author:zysaaa
 * @date: 2021/1/11 22:58
 */
public class Intersect {

    public static void main(String[] args) {
        intersect(new int[] {1,2, 2,1}, new int[] {2,2});
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (list.contains(i)) {
                result.add(i);
                // 移除
                list.remove(new Integer(i));
            }
        }
        int[] resultArr = new int[result.size()];
        int idx = 0;
        for (Integer i : result) {
            resultArr[idx++] = i;
        }
        return resultArr;

    }

    // 如果已经排序
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                result.add(nums1[i]);
                i++;j++;
            }
        }
        int[] resultArr = new int[result.size()];
        int idx = 0;
        for (Integer i : result) {
            resultArr[idx++] = i;
        }
        return resultArr;
    }
}
