package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description: 二叉树的最近公共祖先
 * @author: zysaaa
 * @date: 2021/10/21 14:36
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftTrack = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTrack = lowestCommonAncestor(root.left, p, q);
        if (leftTrack != null && rightTrack != null) {
            return root;
        } else {
            return leftTrack == null ? rightTrack : leftTrack;
        }
    }
}
