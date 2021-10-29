package again.leetcode.数组;

/**
 * @description: https://leetcode-cn.com/problems/missing-number/
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @author: zysaaa
 * @date: 2021/10/26 17:19
 */
public class 丢失的数字 {

    public int missingNumber(int[] nums) {

        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num] = 1;
        }
        int idx = 0;
        for (int num : arr) {
            if (num == 0) {
                return idx;
            }
            idx++;
        }
        return 0;

    }
}
