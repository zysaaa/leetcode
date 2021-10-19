package com.zysaaa.zysaaa20210215;

import com.zysaaa.common.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Codec {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(2);
        System.out.println(new Codec().serialize(treeNode));

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode treeNode = list.removeFirst();
            if (treeNode == null) {
                stringBuilder.append("null,");
            } else {
                stringBuilder.append(treeNode.val).append(",");
                list.add(treeNode.left);
                list.add(treeNode.right);
            }
        }
        return stringBuilder.substring(0, stringBuilder.toString().length() - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split) {
            list.add(s);
        }
        TreeNode head = new TreeNode(Integer.parseInt(list.removeFirst()));
        while (!list.isEmpty()) {

        }

        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));