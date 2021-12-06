package sort;

/**
 * Merge sort. Code from <<Algorithms(4th Edition)>>
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class MergeSort {

    public int[] sortArray(int[] nums) {
        doSort(nums, new int[nums.length], 0, nums.length - 1);
        return nums;
    }

    private void doSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        doSort(nums, tmp, left, mid);
        doSort(nums, tmp, mid + 1, right);
        merge(nums, tmp, left, mid, right);
    }


    private void merge(int[] nums, int[] tmp, int left, int mid, int right) {
        // Copy array to tmp
        // Or: if (right + 1 - left >= 0) System.arraycopy(nums, left, tmp, left, right + 1 - left);
        for (int k = left; k < right + 1; k++) {
            tmp[k] = nums[k];
        }
        // Two pointers
        int i = left;
        int j = mid + 1;
        for (int k = left; k < right + 1; k++) {
            if (i > mid) {
                nums[k] = tmp[j++];
            } else if (j > right) {
                nums[k] = tmp[i++];
            } else if (tmp[i] > tmp[j]) {
                nums[k] = tmp[j++];
            } else {
                nums[k] = tmp[i++];
            }
        }
    }

}
