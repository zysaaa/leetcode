package again.leetcode.回溯;

import again.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author: zysaaa
 * @date: 2021/10/25 15:13
 */
public class 二叉树中和为某一值的路径 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return result;
    }


    private void dfs(TreeNode node, int sum, List<Integer> list) {

        if (node == null) {
            return;
        }
        if (sum - node.val == 0 && node.left == null && node.right == null) {

            list.add(node.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        sum -= node.val;
        list.add(node.val);
        dfs(node.left, sum, list);
        dfs(node.right, sum, list);
        list.remove(list.size() - 1);
    }
}
