package again.sort;

import again.common.Utils;

/**
 * @description: heap sort
 * @author: zysaaa
 * @date: 2021/10/25 17:47
 */
public class HeapSort {

    public void sortArray(int[] nums) {
        int parent = nums.length / 2 - 1;
        for (int i = parent; i > -1; i--) {
            heapify(nums, i, nums.length);
        }
        // 剪
        for (int i = nums.length - 1; i > -1; i--) {
            Utils.swap(nums, i, 0);
            heapify(nums, 0, i);
        }
    }


    private void heapify(int[] nums, int index, int length) {

        if (index == length) {
            return;
        }

        int a = index * 2 + 1;
        int b = index * 2 + 2;
        int max = index;
        if (a < length && nums[a] > nums[max]) {
            max = a;
        }
        if (b < length && nums[b] > nums[max]) {
            max = b;
        }
        if (max != index) {
            Utils.swap(nums, index, max);
            heapify(nums, max, length);
        }
    }

}
