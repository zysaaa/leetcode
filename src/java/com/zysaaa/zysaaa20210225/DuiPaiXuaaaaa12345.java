package com.zysaaa.zysaaa20210225;

public class DuiPaiXuaaaaa12345 {

    public void sort(int[] nums) {

        buildHeap(nums);

        for (int i = nums.length - 1; i > -1; i--) {
            // swap
            heapify(i, nums, 0);
        }

    }

    public void buildHeap(int[] nums) {
        int parent = nums.length / 2 - 1;
        while (parent > -1) {
            heapify(nums.length, nums, parent--);
        }
    }

    public void heapify(int n, int[] nums, int index) {
        if (index >= n) {
            return;
        }
        int a = 2 * index + 1;
        int b = 2 * index + 2;
        int max = index;
        if (a < n && nums[a] > nums[max]) {
            max = a;
        }
        if (b < n && nums[b] > nums[max]) {
            max = b;
        }
        if (max != index) {
            // swap
            heapify(n, nums, max);
        }
    }
}
