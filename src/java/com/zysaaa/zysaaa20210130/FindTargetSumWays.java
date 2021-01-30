package com.zysaaa.zysaaa20210130;

/**
 * @description: 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/30 18:59
 */
public class FindTargetSumWays {

    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0);
        return result;
    }

    public void dfs(int[] nums, int sum, int begin) {
        if (begin == nums.length) {
            if (sum == 0) {
                result++;
            }
            return;
        }
        dfs(nums, sum - nums[begin], begin + 1);
        dfs(nums, sum + nums[begin], begin + 1);
    }
}
