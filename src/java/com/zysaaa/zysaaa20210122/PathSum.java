package com.zysaaa.zysaaa20210122;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @author:zysaaa
 * @date: 2021/1/22 21:14
 */
public class PathSum {


    public static void main(String[] args) {

    }

    static List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        dfs(list, targetSum, root);
        return result;
    }

    public static void dfs(List<Integer> tmpList, int targetNum, TreeNode node) {
        if (node == null) {
            return;
        }
        if (targetNum - node.val == 0 && node.left == null && node.right == null) {
            tmpList.add(node.val);
            result.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        tmpList.add(node.val);
        dfs(tmpList, targetNum - node.val, node.left);
        dfs(tmpList, targetNum - node.val, node.right);
        tmpList.remove(tmpList.size() - 1);
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
