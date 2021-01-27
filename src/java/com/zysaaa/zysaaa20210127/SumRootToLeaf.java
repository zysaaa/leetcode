package com.zysaaa.zysaaa20210127;

import com.zysaaa.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。

对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

返回这些数字之和。题目数据保证答案是一个 32 位 整数。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/27 20:33
 */
public class SumRootToLeaf {

    private static Set<String> strings = new HashSet<>();

    public static void main(String[] args) {

    }

    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);

    }
    public int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = sum * 2 + root.val;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
}
