package again.leetcode.设计;

/**
 * @description: fucku
 * @author: zysaaa
 * @date: 2021/11/4 21:50
 */
public class 最小栈 {

    Node head;

    public 最小栈() {
    }

    public void push(int val) {
        if (head == null) {
            Node node = new Node();
            node.min = val;
            node.val = val;
            head = node;
        } else {
            Node node = new Node();
            node.val = val;
            node.min = head.min;
            node.next = head;
            head = node;
            head.min = Math.min(val, head.min);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    static class Node {
        int min;
        int val;
        Node next;
    }
}
