package com.zysaaa.zysaaa20210124;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 *  好像是最笨的方式了。。。。
 * @author:zysaaa
 * @date: 2021/1/24 13:02
 */
public class BinaryTreePaths {

    private  List<String> result = new ArrayList<>();

    private  List<List<TreeNode>> resultNodes = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root, new ArrayList<>());
        resultNodes.forEach(resultNodeList -> {
            final String[] s = {""};
            resultNodeList.forEach(resultNode -> {
                s[0] += resultNode.val + "->";
            });
            s[0] = s[0].substring(0, s[0].length() - 2);
            result.add(s[0]);
        });
        return result;

    }

    public  void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        list.add(node);
        if (node.left == null && node.right == null) {
            resultNodes.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        list.remove(list.size() - 1);
    }
}
