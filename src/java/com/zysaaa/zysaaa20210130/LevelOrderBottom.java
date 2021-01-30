package com.zysaaa.zysaaa20210130;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @author:zysaaa
 * @date: 2021/1/30 16:43
 */
public class LevelOrderBottom {




    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        LinkedList<List<Integer>> lists = new LinkedList<>();

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
            lists.addFirst(new ArrayList<>(tmp));
            tmp.clear();

        }
        return lists;
    }
}
