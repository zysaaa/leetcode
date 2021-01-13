package com.zysaaa.zysaaa20210113;

import java.util.List;

/**
 * @description: 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * @author:zysaaa
 * @date: 2021/1/13 21:00
 */
public class IsBalanced {

    public static void main(String[] args) {

    }
    static boolean flag = true;
    public static boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right= dfs(node.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
