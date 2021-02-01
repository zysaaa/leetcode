package zysaaa20210201;

import com.zysaaa.common.TreeNode;

/**
 * @description: 该方法适用于：所有二叉树。
 * @author:zysaaa
 * @date: 2021/2/1 20:35
 */
public class SearchBST {

    public TreeNode search(TreeNode root, TreeNode target) {

        if (root == null) {
            return null;
        }
        if (root.val == target.val) {
            return root;
        }
        TreeNode search = search(root.left, target);
        if (search != null) {
            return search;
        }
        return search(root.right, target);
    }
}
