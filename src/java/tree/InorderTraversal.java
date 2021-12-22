package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node = pop.right;
            }

        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            } else {
                node = stack.pop();
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        TreeNode p = root, r = null;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || p != null) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.peek();
                if (p.right == null || p.right == r) {
                    ans.add(p.val);
                    r = p;
                    s.pop();
                    p = null;
                } else
                    p = p.right;

            }

        }

        return ans;
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static int powerOfTwo(int value) {
        int n = -1 >>> Integer.numberOfLeadingZeros(value - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

    }

    public static int powerOfTwo2(int value) {
        return 1 << (32 - Integer.numberOfLeadingZeros(value - 1));
    }

    public static void main(String[] args) {
        System.out.println(powerOfTwo(10));
        System.out.println(powerOfTwo2(10));
    }
}
