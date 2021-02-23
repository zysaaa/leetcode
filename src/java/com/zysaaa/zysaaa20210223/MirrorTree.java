package com.zysaaa.zysaaa20210223;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @author:zysaaa
 * @date: 2021/2/23 20:30
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = mirrorTree(left);
        root.left = mirrorTree(right);
        return root;
    }


}
