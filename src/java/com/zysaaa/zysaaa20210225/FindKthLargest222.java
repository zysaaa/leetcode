package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author:zysaaa
 * @date: 2021/3/27 10:21
 */
public class FindKthLargest222 {

    public static void main(String[] args) {
        System.out.println(new FindKthLargest222().findKthLargest(new int[]{-1,2,0}, 2));
    }


    public int findKthLargest(int[] nums, int k) {
        return nums[slove(nums, k, 0, nums.length - 1)];

    }

    private int slove(int[] nums, int k, int lo, int high) {
        if (lo >= high) {
            return lo;  // 注意这里。
        }
        int partiton = partition(nums, lo, high);
        if (partiton == nums.length - k) {
            return partiton;
        } else if (partiton > nums.length - k) {
            return slove(nums, k, lo, partiton - 1);
        } else {
            return slove(nums, k, partiton + 1, high);
        }
    }

    private int partition(int[] nums, int lo, int high) {
        int i = lo;
        int j = high + 1;
        int target = nums[lo];
        while (true) {
            while (nums[++i] < target) {
                if (i == high)
                    break;
            }
            while (nums[--j] > target);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);

        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
