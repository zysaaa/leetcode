package com.zysaaa.zysaaa20210110;

/**
 * @description: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

 * @author:zysaaa
 * @date: 2021/1/10 10:02
 */
public class Search {

    public static void main(String[] args) {



    }

    // 非递归
    public static int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;  // left + ( right - left) / 2 aviod overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;

    }

    public static int search(int[] nums, int target) {

        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return search(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, right);
        } else {
            return nums[mid];
        }
    }
}
