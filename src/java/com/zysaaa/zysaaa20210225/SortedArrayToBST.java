package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * @author:zysaaa
 * @date: 2021/2/25 21:56
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length - 1, nums);
    }

    public TreeNode dfs(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(left, mid - 1, nums);
        treeNode.right = dfs(mid + 1, right, nums);
        return treeNode;
    }
}
