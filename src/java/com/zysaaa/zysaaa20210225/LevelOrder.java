package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @author:zysaaa
 * @date: 2021/2/26 21:55
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
            List<Integer> list = new ArrayList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = linkedList.removeFirst();
                list.add(remove.val);
                if (remove.left != null) {
                    linkedList.add(remove.left);
                }
                if (remove.right != null) {
                    linkedList.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
