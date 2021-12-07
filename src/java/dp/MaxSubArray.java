package dp;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
