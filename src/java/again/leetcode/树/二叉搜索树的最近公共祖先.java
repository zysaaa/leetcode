package again.leetcode.树;

import again.common.TreeNode;

/**
 * @description: 二叉搜索树的最近公共祖先
 * @author: zysaaa
 * @date: 2021/10/21 14:31
 */
public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p ,q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
