package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        getLeafList(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        getLeafList(root2, list2);
        return list1.equals(list2);
    }

    public void getLeafList(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        getLeafList(node.left, list);
        getLeafList(node.right, list);
    }
}
