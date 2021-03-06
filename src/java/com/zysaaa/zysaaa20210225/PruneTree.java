package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-pruning/
 *
 * class Solution {
 *     public TreeNode pruneTree(TreeNode root) {
 *         if(root == null) {
 *             return null;
 *         }
 *         root.left = pruneTree(root.left);
 *         root.right = pruneTree(root.right);
 *         if(root.left == null && root.right == null && root.val == 0) {
 *             return null;
 *         }
 *         return root;
 *     }
 * }
 * @author:zysaaa
 * @date: 2021/3/6 13:07
 */
public class PruneTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);

        node.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(new PruneTree().pruneTree(node));
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (!hasOne(root.left)) {
            root.left = null;
        }
        if (!hasOne(root.right)) {
            root.right = null;
        }
        pruneTree(root.left);
        pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public boolean hasOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.val == 1) {
            return true;
        }
        return hasOne(node.left) || hasOne(node.right);

    }
}
