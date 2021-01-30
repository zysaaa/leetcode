package com.zysaaa.zysaaa20210130;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author:zysaaa
 * @date: 2021/1/30 15:54
 */
public class ZigzagLevelOrder {


    public static void main(String[] args) {

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        List<List<Integer>> lists = new ArrayList<>();
        boolean fromLeft = false;
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
            if (!fromLeft) {
                List<Integer> list = new ArrayList<>();
                for (int i = tmp.size() - 1; i >=0; i--) {
                    list.add(tmp.get(i));
                }
                lists.add(new ArrayList<>(list));
            } else {
                lists.add(new ArrayList<>(tmp));
            }
            tmp.clear();
            fromLeft = !fromLeft;

        }
        return lists;
    }
}
