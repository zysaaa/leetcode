package again.sort;

import again.common.Utils;

/**
 * @description:
 * @author: zysaaa
 * @date: 2021/10/21 14:09
 */
public class QuickSort {

    public void sort(int[] nums) {
        doSort(nums, 0, nums.length - 1);
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
        int i = low;
        int j = high + 1;
        int target = nums[i];

        while (true) {
            while ((nums[++i] < target)) {
                if (i == high) {
                    break;
                }
            }
            while (nums[--j] > target) {
                // 可以注释以下代码
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Utils.swap(nums, i, j);
        }
        Utils.swap(nums, low, j);
        return j;

    }
}
