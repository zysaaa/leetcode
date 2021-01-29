package com.zysaaa.zysaaa20210129;

import com.zysaaa.common.TreeNode;

import java.util.List;

/**
 * @description: 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 注意 是正负的，所以可能是 5 | 5，-5，5 | ......
 * @author:zysaaa
 * @date: 2021/1/29 20:56
 */
public class PathSum {



    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    public  int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (sum - node.val == 0) {
            count = 1;
        }
        return count + dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
    }
}
