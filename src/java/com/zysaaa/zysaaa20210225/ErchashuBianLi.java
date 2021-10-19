//package com.zysaaa.zysaaa20210225;
//
//import com.zysaaa.common.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * @description: 迭代的方式 ----- 遍历二叉树
// * @author:zysaaa
// * @date: 2021/2/27 16:56
// */
//public class ErchashuBianLi {
//
//    // 中序
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                TreeNode pop = stack.pop();
//                result.add(pop.val);
//                cur = pop.right;
//            }
//        }
//        return result;
//    }
//
//    // 前序
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            if (root != null) {
//                result.add(root.val);
//                stack.push(root);
//                root = root.left;
//
//            } else {
//                TreeNode pop = stack.pop();
//                root = pop.right;
//            }
//        }
//        return result;
//    }
//
//
///*
//    // 后序
//    public List<Integer> postorderTraversal(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode tmp = null;
//
//        while (root != null || !stack.isEmpty()) {
//            if (root != null) {
//                stack.push(root);
//                tmp = root;
//                root = root.left;
//            } else {
//                if (tmp.right != null) {
//                    stack.push(tmp.right);
//
//                } else {
//
//                }
//            }
//        }
//
//*/
//
//
//    }
//
//
//
//}
