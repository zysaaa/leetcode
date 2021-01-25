package com.zysaaa.zysaaa20210125;

import com.zysaaa.common.TreeNode;

/**
 * @description: 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/25 21:40
 */
public class IsSymmetric {

    static boolean result = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root.left, root.right, true);
        return result;
    }

    public static void dfs(TreeNode left, TreeNode right, boolean isLeft) {
        if (left == null && right == null) {
            return;
        }
        if (left != null && right == null) {
            result = false;
            return;
        }
        if (left == null) {
            result = false;
            return;
        }
        if (left.val != right.val) {
            result = false;
            return;
        }
        dfs(left.left, right.right, true);
        dfs(left.right, right.left, true);
    }
}
