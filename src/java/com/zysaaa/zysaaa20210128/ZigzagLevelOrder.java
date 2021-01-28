package com.zysaaa.zysaaa20210128;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @author:zysaaa
 * @date: 2021/1/28 20:32
 */
public class ZigzagLevelOrder {




    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                root = pop.right;
            }
        }
        return result;

    }
}
