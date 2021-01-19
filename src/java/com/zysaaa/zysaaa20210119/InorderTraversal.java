package com.zysaaa.zysaaa20210119;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author:zysaaa
 * @date: 2021/1/19 21:24
 *
 * 递归算法很简单，你可以通过迭代算法完成吗？  迭代和递归：https://www.zhihu.com/question/20278387?sort=created
 */
public class InorderTraversal {


    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
           List<Integer> list = new ArrayList<>();
           dfs(list, root);
           return list;
    }

    // 迭代 fixme
    public List<Integer> inorderTraversal2(TreeNode root) {

    }

    public static void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            dfs(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            dfs(list, node.right);
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
