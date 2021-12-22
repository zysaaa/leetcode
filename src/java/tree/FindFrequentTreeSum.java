package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class FindFrequentTreeSum {

    public static void main(String[] args) {
        FindFrequentTreeSum findFrequentTreeSum = new FindFrequentTreeSum();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-5);
        System.out.println(Arrays.toString(findFrequentTreeSum.findFrequentTreeSum(node)));
    }

    Map<Integer, Integer> map = new HashMap<>();
    int maxTimes;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> sums = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == maxTimes) {
                sums.add(k);
            }
        });
        return sums.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        int sum = sum(node);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxTimes = Math.max(maxTimes, map.get(sum));
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

}
