package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *                https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * @author: zysaaa
 * @date: 2021/10/21 15:16
 */
public class 判断某二叉树是否是平衡二叉树 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);


        node.left = node2;
        node2.left = node3;

        System.out.println(new 判断某二叉树是否是平衡二叉树().isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        System.out.println("....");
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


}
