package com.zysaaa.zysaaa20210123;

/**
 * @description: 计算给定二叉树的所有左叶子之和。
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/submissions/
 * @author:zysaaa
 * @date: 2021/1/23 16:40
 */
public class SumOfLeftLeaves {

     int sum = 0;


    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root.left, true);
        dfs(root.right, false);
        return sum;
    }

    public  void dfs(TreeNode node, boolean fromLeft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && fromLeft) {
            sum += node.val;
            return;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
