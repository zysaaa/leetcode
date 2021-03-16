package com.zysaaa.zysaaa20210225;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/16 21:53
 */
public class SortArray {

    public static void main(String[] args) {
        System.out.println(new SortArray().sortArray(new int[] {5,2,3,1}));
    }

    public int[] sortArray(int[] nums) {
        // 找到最大的元素作为哨兵
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int tmp = nums[max];
        nums[max] = nums[nums.length - 1];
        nums[nums.length - 1] = tmp;
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int partition = partition(nums, i, j);
        sort(nums, i, partition - 1);
        sort(nums, partition + 1, j);
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
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

        }
        nums[lo] = nums[j];
        nums[j] = target;
        return j;

    }



}
