package again.leetcode.树;

import again.common.TreeNode;

import java.util.LinkedList;

/**
 * @description:
 * @author: zysaaa
 * @date: 2021/11/4 21:09
 */
public class 找树左下角的值 {



    public int findBottomLeftValue(TreeNode root) {

        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.add(root);

        int value = 0;

        while (!linkedList.isEmpty()) {


            int size = linkedList.size();

            while (size -- > 0) {
                TreeNode remove = linkedList.remove();
                if (remove.right != null) {
                    linkedList.add(remove.right);
                }
                if (remove.left != null) {
                    linkedList.add(remove.left);
                }
                if (size == 0) {
                    value = remove.val;
                }

            }
        }

        return value;




    }


}
