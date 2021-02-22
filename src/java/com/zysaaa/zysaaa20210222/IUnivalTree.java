package com.zysaaa.zysaaa20210222;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/
 * @author:zysaaa
 * @date: 2021/2/22 20:40
 */
public class IUnivalTree {

    private int rootVal;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        rootVal = root.val;
        return dfs(root);

    }

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        return node.val == rootVal && dfs(node.left) && dfs(node.right);
    }

}
