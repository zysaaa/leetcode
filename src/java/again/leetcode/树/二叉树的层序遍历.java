package again.leetcode.树;

import again.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * @author: zysaaa
 * @date: 2021/10/24 19:44
 */
public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        List<Integer> list = new ArrayList<>();

        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            while (size -- > 0) {
                TreeNode treeNode = linkedList.removeLast();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addFirst(treeNode.right);
                }
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;

    }
}
