package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode treeNodeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode treeNodeRight = lowestCommonAncestor(root.right, p, q);
        if (treeNodeLeft != null && treeNodeRight != null) {
            return root;
        }
        if (treeNodeLeft != null) {
            return treeNodeLeft;
        }
        return treeNodeRight;
    }
}
