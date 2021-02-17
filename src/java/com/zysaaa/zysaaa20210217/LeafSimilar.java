package com.zysaaa.zysaaa20210217;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/leaf-similar-trees/
 * @author:zysaaa
 * @date: 2021/2/17 20:40
 */
public class LeafSimilar {

    private static List<Integer> root1Leaf = new ArrayList<>();
    private static List<Integer> root2Leaf = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaf(root1Leaf, root1);
        getLeaf(root2Leaf, root2);
        return root1Leaf.equals(root2Leaf);

    }

    private void getLeaf(List<Integer> list, TreeNode root1) {
        if (root1 == null) {
            return;
        }
        if (root1.left == null && root1.right == null) {
            list.add(root1.val);
        }
        getLeaf(list, root1.left);
        getLeaf(list, root1.right);
    }

}
