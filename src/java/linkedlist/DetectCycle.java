package linkedlist;

import common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class DetectCycle {


    /**
     *
     * Note that since the speed of the fast pointer is twice the speed of the slow pointer,
     * after the fast pointer enters the ring, when it catches up with the slow pointer,
     * the slow pointer cannot travel more than one circle.
     *
     * Suppose that the distance from the starting point to the ring-entry point is a,
     * the distance from the ring-entry point in the clockwise direction to the meeting point is b,
     * and the distance from the meeting point to the ring-entry point is c.
     *
     * The distance traveled by the fast hand = 2 * slow
     *
     * (a + b) * 2 = a + b + n(b + c) =>
     * (a + b) = n(b + c) =>
     * a = n(b + c) - b =>
     * a = n(b + c) - b - c + c =>
     * a = (n - 1)(b + c) + c =>
     *
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
