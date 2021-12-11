package linkedlist;

import common.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        // while(fast.next != null&& fast.next.next != null ) { will return first one if there are two middle nodes
        while(fast != null&& fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
