package com.zysaaa.zysaaa20210123;

/**
 * @description: 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/23 14:33
 */
public class FindTilt {


    public int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int sum = 0;
        sum += Math.abs(dfs(root.left) - dfs(root.right));
        return sum + findTilt(root.right) + findTilt(root.left);
    }

    public static int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftSum = 0;
        int rightSum = 0;
        if (node.left != null) {
            leftSum += dfs(node.left);
        }
        if (node.right != null) {
            rightSum += dfs(node.right);
        }
        return leftSum + rightSum + node.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
