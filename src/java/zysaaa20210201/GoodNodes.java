package zysaaa20210201;

import com.zysaaa.common.TreeNode;

/**
 * @description: 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * @author:zysaaa
 * @date: 2021/2/1 20:50
 */
public class GoodNodes {

    private int count = 0;

    public int goodNodes(TreeNode root) {
        count(root.left, root.val);
        count(root.right, root.val);
        return count+1;
    }

    public void count(TreeNode node, int lastNodeVal) {

        if (node == null) {
            return;
        }

        if (node.val >= lastNodeVal) {
            count++;
            count(node.left, node.val);
            count(node.right, node.val);
        } else {
            count(node.left, lastNodeVal);
            count(node.right, lastNodeVal);
        }


    }
}
