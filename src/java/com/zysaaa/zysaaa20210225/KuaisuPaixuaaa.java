package com.zysaaa.zysaaa20210225;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/26 20:47
 */
public class KuaisuPaixuaaa {

    public int[] sort(int[] nums) {
        // 找到最大的数 放到右边
        int maxInd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxInd]) {
                maxInd = i;
            }
        }
        swap(nums, maxInd, nums.length - 1);
        sort(nums, 0, nums.length - 1);
        return nums;
    }


    private void sort(int[] nums, int lo, int high) {
        if (lo >= high) {
            return;
        }
        int partition = partition(nums, lo, high);
        sort(nums, lo, partition - 1);
        sort(nums, partition + 1, high);

    }

    private int partition(int[] nums, int lo, int high) {

        int i = lo;
        int j = high + 1;
        int target = nums[lo];
        while (true) {
            while (nums[++i] < target);
            while (nums[--j] > target);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;

    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }

}
