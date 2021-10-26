package again.sort;

/**
 * @description:
 * @author: zysaaa
 * @date: 2021/10/26 15:24
 */
public class MergeSort {

    public void sort(int[] nums) {
        doSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private void doSort(int[] nums, int left, int right, int[] temp) {

        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        doSort(nums, left, mid, temp);
        doSort(nums, mid + 1, right, temp);
        merge(nums, left, right, mid, temp);
    }


    private void merge(int[] nums, int left, int right, int mid, int[] temp) {

        int i = left;
        int j = mid + 1;

        for (int k = left; k < right + 1; k++) {
            temp[k] = nums[k];
        }

        for (int k = left; k < right + 1; k++) {
            if (i > mid) {
                nums[k] = temp[j++];
            } else if (j > right) {
                nums[k] = temp[i++];
            } else if (nums[i] > nums[j]) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }

    }
}
