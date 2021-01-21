package com.zysaaa.zysaaa20210121;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @description: 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * @author:zysaaa
 * @date: 2021/1/21 20:39
 */
public class IncreasingBST {

    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        TreeNode node = new TreeNode(list.get(0));
        TreeNode tmp = node;
        for (int i = 1; i<list.size(); i++) {
            tmp.right = new TreeNode(list.get(i));
            tmp = tmp.right;
        }
        return node;
    }

    public static void dfs(List<Integer> stack, TreeNode node) {
        if (node.left != null) {
            dfs(stack, node.left);
        }
        stack.add(node.val);
        if (node.right != null) {
            dfs(stack, node.right);
        }
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
