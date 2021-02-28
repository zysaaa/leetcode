package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/paths-with-sum-lcci/
 *
 * 被注释掉的i递归是有问题的。
 *
 * @author:zysaaa
 * @date: 2021/2/28 12:32
 */
public class PathSum2 {


    public static void main(String[] args) {

        /*TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(-2);
        TreeNode treeNode3 = new TreeNode(-3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(-2);
        TreeNode treeNode7 = new TreeNode(-1);

       *//* treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode4.left = treeNode7;*//*

       treeNode.left = treeNode2;
       treeNode2.left = treeNode5;

//        TreeNode treeNode8 = new TreeNode(5);
        *//*treeNode.right = treeNode2;
        treeNode2.right = treeNode3;*//*
        *//*treeNode3.left = treeNode4;
        treeNode4.left = treeNode5;*//*
        System.out.println(new PathSum2().pathSum(treeNode, 3));*/

    }

    /*private int count;
    private int initSum;

    public int pathSum(TreeNode root, int sum) {
        initSum = sum;
        dfs(root, sum);
        return count;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + ";" + sum);
        if (sum - node.val == 0) {
            count++;
            return;
        }
        dfs(node.left, sum - node.val);
        dfs(node.left, initSum);
        dfs(node.right, sum - node.val);
        dfs(node.right, initSum);
    }*/

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (sum - node.val == 0) {
            count++;
        }
        return count + dfs(node.left, (sum - node.val)) + dfs(node.right, (sum - node.val));
    }
}
