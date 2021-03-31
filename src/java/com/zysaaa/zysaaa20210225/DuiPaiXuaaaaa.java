package com.zysaaa.zysaaa20210225;

import java.util.Arrays;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/31 23:40
 */
public class DuiPaiXuaaaaa {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DuiPaiXuaaaaa().sortArray(new int[]{5,2,3,1})));
    }

    public int[] sortArray(int[] nums) {
        build_heap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        return nums;
    }

    public void build_heap(int[] nums) {
        int parent = nums.length / 2 - 1;
        while (parent > -1) {
            heapify(nums, nums.length, parent);
            parent --;
        }
    }

    public void heapify(int[] nums, int n, int index) {
        if (index >= n) {
            return;
        }
        int c1 = 2 * index + 1;
        int c2 = 2 * index + 2;
        int maxIndx = index;
        if (c1 <= n - 1 && nums[c1] > nums[maxIndx]) {
            maxIndx = c1;
        }
        if (c2 <= n - 1 && nums[c2] > nums[maxIndx]) {
            maxIndx = c2;
        }
        if (maxIndx != index) {
            swap(nums, maxIndx, index);
            heapify(nums, n, maxIndx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
