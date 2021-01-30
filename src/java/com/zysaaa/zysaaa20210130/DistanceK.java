package com.zysaaa.zysaaa20210130;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * from website: 很笨的方法，先记录节点的父节点，再从target往子节点和父节点搜索，注意剪枝
 *
 * @author:zysaaa
 * @date: 2021/1/30 16:49
 */
public class DistanceK {

    private  Map<TreeNode, TreeNode> map = new HashMap<>();

    private  List<TreeNode> reached = new ArrayList<>();

    private  List<Integer> list = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildMap(root);
        dfs(target, K);
        return list;


    }

    private  void dfs(TreeNode node, int length) {
        if (node == null) {
            return;
        }
        if (reached.contains(node)) {
            return;
        }
        if (length == 0) {
            list.add(node.val);
            return;
        }

        reached.add(node);

        dfs(node.left, length - 1);
        dfs(node.right, length - 1);
        dfs(map.get(node), length - 1);
    }


    private  void buildMap(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left, node);
            buildMap(node.left);
        }
        if (node.right != null) {
            map.put(node.right, node);
            buildMap(node.right);
        }
    }
}
