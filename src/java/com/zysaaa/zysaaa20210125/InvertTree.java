package com.zysaaa.zysaaa20210125;

import com.zysaaa.common.TreeNode;

/**
 * @description: 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 *
 * 自顶而下！
 *
 * @author:zysaaa
 * @date: 2021/1/25 21:03
 */
public class InvertTree {


    public static void main(String[] args) {



    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
