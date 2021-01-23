package com.zysaaa.zysaaa20210123;

/**
 * @description: 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * @author:zysaaa
 * @date: 2021/1/23 13:27
 */
public class MaxDepth {

    static int depth;

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1;
        int right = 1;
        if (node.left != null) {
            left += dfs(node.left);
        }
        if (node.right != null) {
            right += dfs(node.right);
        }
        return Math.max(left, right);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
}
