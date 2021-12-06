package sort;

import static common.Utils.swap;

/**
 * Quick sort. Code from <<Algorithms(4th Edition)>>
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        doSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void doSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int partition = partition(nums, i, j);
        doSort(nums, i, partition - 1);
        doSort(nums, partition + 1, j);
    }

    public int partition(int[] nums, int low, int high) {
        // This is necessary. The test cases of leetcode usually contain a sorted array.
        // If this line is not added, the time complexity will degrade to the square level.
        // Of course this is a relatively simple way, in order to avoid special test cases.
        // Quick sort can have some other optimizations, please google.
        swap(nums, low, (low + (high - low) / 2));
        int i = low;
        int j = high + 1;
        int target = nums[i];
        while (true) {
            while ((nums[++i] < target)) {
                if (i == high) {
                    break;
                }
            }
            while (nums[--j] > target) {}
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

}
