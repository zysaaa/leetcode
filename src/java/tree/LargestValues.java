package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = linkedList.size();
            while (size -- > 0) {
                TreeNode last = linkedList.removeLast();
                if (last.left != null) {
                    linkedList.addFirst(last.left);
                }
                if (last.right != null) {
                    linkedList.addFirst(last.right);
                }
                max = Math.max(last.val, max);
            }
            result.add(max);
        }
        return result;
    }
}
