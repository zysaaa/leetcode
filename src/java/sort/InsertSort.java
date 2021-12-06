package sort;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class InsertSort {

    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;
            // nums[j] > target no inside for block!!!
            for ( ;j > -1 && nums[j] > target; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = target;
        }
        return nums;
    }
}
