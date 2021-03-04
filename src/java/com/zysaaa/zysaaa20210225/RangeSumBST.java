package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/longest-nice-substring/
 * @author:zysaaa
 * @date: 2021/3/4 21:33
 */
public class RangeSumBST {



    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }


    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        if (node.val >= low & node.val <= high) {
            return node.val + dfs(node.left, low, high) + dfs(node.right, low, high);
        }
        if (node.val < low) {
            return dfs(node.right, low, high);
        }
        return dfs(node.left, low, high);
    }
}
