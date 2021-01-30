package com.zysaaa.zysaaa20210130;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/30 15:43
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        List<List<Integer>> lists = new ArrayList<>();

        while (!linkedList.isEmpty()) {

            int size = linkedList.size();
            List<Integer> tmp = new ArrayList<>();
            while (size -- > 0) {
                TreeNode remove = linkedList.remove();
                tmp.add(remove.val);
                if (remove.left != null) {
                    linkedList.add(remove.left);
                }
                if (remove.right != null) {
                    linkedList.add(remove.right);
                }
            }
            lists.add(new ArrayList<>(tmp));
            tmp.clear();

        }
        return lists;

    }
}
