package com.zysaaa.zysaaa20210124;

import com.zysaaa.common.TreeNode;

/**
 * @description: 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * @author:zysaaa
 * @date: 2021/1/24 12:22
 */
public class DiameterOfBinaryTree {


    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            return Math.max((depth(root.left) + depth(root.right)), Math.max(diameterOfBinaryTree(root.right), diameterOfBinaryTree(root.left)));
        }
        return 0;
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = 1;
        if (node.left != null) {
            leftDepth += depth(node.left);
        }

        int rightDepth = 1;
        if (node.right != null) {
            rightDepth += depth(node.right);
        }

        return Math.max(leftDepth, rightDepth);
    }


}
