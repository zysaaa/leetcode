package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
 * @author:zysaaa
 * @date: 2021/3/6 14:04
 */
public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list(root, list);
        int val = 0;
        for (int i : list) {
            val = Math.max(Math.abs(root.val - i), val);
        }
        int leftMax = maxAncestorDiff(root.left);
        int rightMax = maxAncestorDiff(root.right);
        return Math.max(Math.max(leftMax,rightMax), val);
    }

    private void list(TreeNode node, List<Integer> list) {

        if (node == null) {
            return ;
        }
        list.add(node.val);
        list(node.right, list);
        list(node.left, list);
    }


}
