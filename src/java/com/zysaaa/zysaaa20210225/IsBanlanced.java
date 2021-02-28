package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @author:zysaaa
 * @date: 2021/2/28 21:36
 */
public class IsBanlanced {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return 1 + Math.max(left, right);

    }
}
