package com.zysaaa.zysaaa20210213;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        // int mid = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
