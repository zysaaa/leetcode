package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author:zysaaa
 * @date: 2021/3/10 20:57
 */
public class BianLi {


    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node = pop.right;
            }

        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                node = pop.right;
            }

        }
        return result;
    }
}
