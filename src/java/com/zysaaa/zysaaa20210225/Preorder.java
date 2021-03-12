package com.zysaaa.zysaaa20210225;

import java.util.*;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/12 21:48
 */
public class Preorder {

    public static void main(String[] args) {

        Node node = new Node(1);

        Node node1 = new Node(3);

        node1.children = Arrays.asList(new Node(5), new Node(6));

        List<Node> ccc = new ArrayList<>();
        ccc.add(node1);
        ccc.add(new Node(2));
        ccc.add(new Node(4));
        node.children = ccc;

        System.out.println(new Preorder().preorder(node));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();

        Node node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                result.add(node.val);
                if (node.children == null || node.children.isEmpty()) {
                    node = null;
                } else {
                    for (int i = node.children.size() - 1; i > 0; i--) {
                        stack.add(node.children.get(i));
                    }
                    node = node.children.get(0);

                }
            } else {
                node = stack.removeLast();
            }
        }
        return result;


    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}


