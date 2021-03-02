package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/paths-with-sum-lcci/
 * @author:zysaaa
 * @date: 2021/3/2 21:41
 */
public class PathSum2Again {

    private int count;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        if (sum - node.val == 0) {
            count++;
        }
        dfs(node.right, sum - node.val);
        dfs(node.left, sum - node.val);
    }

}
