package com.zysaaa.zysaaa20210225;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/4/10 14:48
 */
public class FindDuplicate123 {


    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
