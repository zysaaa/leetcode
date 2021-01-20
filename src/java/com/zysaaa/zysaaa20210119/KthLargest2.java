package com.zysaaa.zysaaa20210119;

import java.util.ArrayList;
import java.util.List;


/**
 * @description: 给定一棵二叉搜索树，请找出其中第k大的节点。  --优化方式
 * @author:zysaaa
 * @date: 2021/1/19 20:54
 */
public class KthLargest2 {

    public static void main(String[] args) {




    }

    static int count = 0;
    static int flag = 0;
    static int result = 0;

    public static int kthLargest(TreeNode root, int k) {
        flag = k;
        bianli(root);
        return result;
    }

    public static void bianli(TreeNode node) {
        if (node.right != null  && count != flag) {
            bianli(node.right);
        }
        count++;
        if (count == flag) {
            result = node.val;
            return;
        }
        if (node.left != null) {
            bianli(node.left);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
