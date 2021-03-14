package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * @author:zysaaa
 * @date: 2021/3/14 15:34
 */
public class FindPath {

    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(new ArrayList<>(), root, target);
        return lists;
    }


    private void dfs(List<Integer> list, TreeNode node, int target) {
        if (node == null) {
            return;
        }
        if (node.right == null && node.left == null && target - node.val == 0) {
            list.add(node.val);
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(node.val);
        dfs(list, node.right, target - node.val);
        dfs(list, node.left, target - node.val);
        list.remove(list.size() - 1);
    }
}
