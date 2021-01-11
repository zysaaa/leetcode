package com.zysaaa.zysaaa20210111;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/1/11 21:06
 */
public class Intersection {


    public static void main(String[] args) {



    }

    public static int[] intersection(int[] nums1, int[] nums2) {

               Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> result = new HashSet<>();

        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
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
