package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-tilt
 * @author: zysaaa
 * @date: 2021/10/24 19:36
 */
public class 二叉树的坡度 {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calc(root) + findTilt(root.left) + findTilt(root.right);
    }

    public int calc(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.abs(sum(node.left) - sum(node.right));
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }
}
