package zysaaa20210201;

import com.zysaaa.common.TreeNode;

import java.util.LinkedList;

/**
 * @description: 给定一个二叉树，在树的最后一行找到最左边的值。
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/2/1 20:41
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {

            TreeNode first = linkedList.removeFirst();
            if (first.right != null) {
                linkedList.add(first.right);
            }
            if (first.left != null) {
                linkedList.add(first.left);
            }
            if (linkedList.size() == 0) {
                return first.val;
            }
        }
        return 0;


    }
}
