package linkedlist;

import common.ListNode;

/**
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newNode = slow.next;
        slow.next = null;
        // reverse
        ListNode reverseList = reverseList(newNode);
        while (head != null && reverseList != null) {
            if (head.val != reverseList.val) {
                return false;
            }
            head = head.next;
            reverseList = reverseList.next;
        }
        return true;
    }

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
