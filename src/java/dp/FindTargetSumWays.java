package dp;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class FindTargetSumWays {

    int count;

    public int findTargetSumWays(int[] nums, int target) {

        backtrack(nums, target, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
            return;
        }
        backtrack(nums, target + nums[index], index + 1);
        backtrack(nums, target - nums[index], index + 1);
    }
}
