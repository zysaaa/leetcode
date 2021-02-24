package com.zysaaa.zysaaa20210223;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author:zysaaa
 * @date: 2021/2/24 22:22
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;

    }
}
