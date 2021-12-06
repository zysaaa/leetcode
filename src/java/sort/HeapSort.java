package sort;

import static common.Utils.swap;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class HeapSort {

    public int[] sortArray(int[] nums) {
        // Start from the first non-leaf node
        int firstNonLeafNode = nums.length / 2 - 1;
        for (int i = firstNonLeafNode; i > -1; i--) {
            headify(nums, i, nums.length);
        }
        // Swap and rebuild the heap
        for (int i = nums.length - 1; i > -1; i--) {
            swap(nums, 0, i);
            headify(nums, 0, i);
        }
        return nums;
    }

    private void headify(int[] nums, int index, int length) {
        if (index >= length) {
            return;
        }
        int max = index;
        int a = index * 2 + 1;
        int b = index * 2 + 2;
        if (a < length && nums[a] > nums[max]) {
            max = a;
        }
        if (b < length && nums[b] > nums[max]) {
            max = b;
        }
        if (max != index) {
            swap(nums, index, max);
            headify(nums, max, length);
        }
    }

}
