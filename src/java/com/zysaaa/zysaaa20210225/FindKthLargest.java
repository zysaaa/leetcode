package com.zysaaa.zysaaa20210225;

/**
 * @description: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author:zysaaa
 * @date: 2021/3/14 16:54
 */
public class FindKthLargest {



    public int findKthLargest(int[] nums, int k) {
        return solve(nums, 0, nums.length - 1, nums.length - k);
    }

    private int solve(int[] a, int lo, int hi, int idx) {
        if (hi <= lo) {
            return a[hi];
        }
        int partition = partition(a, lo, hi);
        if (partition == idx) {
            return a[partition];
        }
        return partition > idx ? solve(a, lo, partition - 1, idx) : solve(a, partition + 1, hi, idx);
    }

    private  int partition(int[] a, int lo, int hi) {

        int target = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i] < target) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > target) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
