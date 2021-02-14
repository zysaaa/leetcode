package com.zysaaa.zysaaa20210213;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }
}
