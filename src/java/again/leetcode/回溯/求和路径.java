package again.leetcode.回溯;

import again.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/paths-with-sum-lcci/
 * @author: zysaaa
 * @date: 2021/10/25 16:56
 */
public class 求和路径 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (sum - node.val == 0) {
            count ++;
        }
        int val = sum - node.val;
        return count + dfs(node.left, val) + dfs(node.right, val);
    }
}
