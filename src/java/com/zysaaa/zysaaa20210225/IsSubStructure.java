package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @author:zysaaa
 * @date: 2021/3/6 13:33
 */
public class IsSubStructure {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;



        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode222 = new TreeNode(4);
        TreeNode treeNode333 = new TreeNode(5);
        treeNode11.left = treeNode222;
        treeNode11.right = treeNode333;


        System.out.println(new IsSubStructure().isSubStructure(treeNode, treeNode11));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean dfs(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
