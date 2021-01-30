package com.zysaaa.zysaaa20210130;

import com.zysaaa.common.TreeNode;

/**
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 * @author:zysaaa
 * @date: 2021/1/30 18:23
 */
public class IsBalanced {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {

        depth(root);
        return result;

    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return 1 + Math.max(left, right);
    }

}
