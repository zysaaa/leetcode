package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author:zysaaa
 * @date: 2021/3/2 21:34
 */
public class PathSumAgain {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return lists;
    }

    private void dfs(TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.right == null && node.left == null && sum - node.val == 0) {
            list.add(node.val);
            lists.add(list);
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        dfs(node.left, sum - node.val, list);
        dfs(node.right, sum - node.val, list);
        list.remove(list.size() - 1);
    }
}
