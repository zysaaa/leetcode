package tree;

import common.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
