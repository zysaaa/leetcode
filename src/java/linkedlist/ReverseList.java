package linkedlist;

import common.ListNode;

/**
 * https://leetcode.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode node = head;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
