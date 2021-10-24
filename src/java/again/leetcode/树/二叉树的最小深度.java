package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description:
 *   给定一个二叉树，找出其最小深度。
 *  *
 *  * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *  *
 *  * 说明：叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * @author: zysaaa
 * @date: 2021/10/24 19:29
 */
public class 二叉树的最小深度 {



    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null && root.left != null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
