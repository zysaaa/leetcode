package com.zysaaa.zysaaa20210123;

import javax.swing.tree.TreeNode;

/**
 * @description: 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @author:zysaaa
 * @date: 2021/1/23 11:26
 */
public class IsSymmetric {

    static boolean result = true;

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root.left, root.right);
        return result;
    }

    public void dfs(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return;
        }
        if (nodeLeft == null || nodeRight == null) {
            result = false;
            return;
        }
        if (nodeLeft.val != nodeRight.val) {
            result = false;
            return;
        }
        dfs(nodeLeft.left, nodeRight.right);
        dfs(nodeLeft.right, nodeRight.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
}
