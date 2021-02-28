package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author:zysaaa
 * @date: 2021/2/28 12:09
 */
public class PathSum {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return lists;


    }

    private void dfs(TreeNode treeNode, int sum, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        if (sum - treeNode.val == 0 && treeNode.right == null && treeNode.left == null) {
            list.add(treeNode.val);
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(treeNode.val);
        sum -= treeNode.val;
        dfs(treeNode.left, sum, list);
        dfs(treeNode.right, sum, list);
        list.remove(list.size() - 1);
    }
}
