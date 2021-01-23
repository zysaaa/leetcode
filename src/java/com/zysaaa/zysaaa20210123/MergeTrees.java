package com.zysaaa.zysaaa20210123;

/**
 * @description: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * @author:zysaaa
 * @date: 2021/1/23 14:06
 */
public class MergeTrees {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }

    private static TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = 0;
        if (t1 != null) {
            val += t1.val;
        }
        if (t2 != null) {
            val += t2.val;
        }
        TreeNode newTree = new TreeNode(val);
        newTree.left = dfs(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newTree.right = dfs(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newTree;

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
