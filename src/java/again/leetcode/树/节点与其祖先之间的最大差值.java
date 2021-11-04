package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description: 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *  https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
 * @author: zysaaa
 * @date: 2021/11/3 19:08
 */
public class 节点与其祖先之间的最大差值 {

    private int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        minValue(root, root.left);
        minValue(root, root.right);
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);
        return max;
    }


    public void minValue(TreeNode target, TreeNode node) {

        if (node == null) {
            return;
        }
        max = Math.max(max, Math.abs(target.val - node.val));
        minValue(target, node.left);
        minValue(target, node.right);

    }


}
