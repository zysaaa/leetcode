package com.zysaaa.zysaaa20210119;

import com.zysaaa.zysaaa20210113.IsBalanced;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @author:zysaaa
 * @date: 2021/1/19 20:54
 */
public class KthLargest {

    public static void main(String[] args) {




    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        // 中序遍历一遍
        bianli(list, root);
        return list.get(list.size() - k);
    }

    public static void bianli(List<Integer> list, TreeNode node) {
        if (node.left != null) {
            bianli(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            bianli(list, node.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
