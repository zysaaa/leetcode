package com.zysaaa.zysaaa20210121;

import java.util.List;

/**
 * @description: 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * @author:zysaaa
 * @date: 2021/1/21 21:14
 */
public class HasPathSum {

    public static void main(String[] args) {




    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null  && (targetSum - root.val) == 0 && root.left == null && root.right == null) {
            return true;
        }
        if (root != null) {
            targetSum -= root.val;
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        } else {
            return false;
        }
    }

    public static void dfs(List<Integer> list, TreeNode node) {

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
