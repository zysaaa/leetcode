package again.sort;

/**
 * @description: InsertSort
 * @author:zysaaa
 * @date: 2021/10/20 20:34
 */
public class InsertSort {

    public void sort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int key = nums[i];
            for (; j > -1 && nums[j] > key; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = key;
        }
    }

}
