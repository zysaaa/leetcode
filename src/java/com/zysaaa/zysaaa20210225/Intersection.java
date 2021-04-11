package com.zysaaa.zysaaa20210225;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Intersection().intersection(new int[]{1,2,2,3,2}, new int[] {2,2})));

    }
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] arr = new int[result.size()];
        int idx = 0;
        for (Integer integer : result) {
            arr[idx++] = integer;
        }
        return arr;
    }
}
