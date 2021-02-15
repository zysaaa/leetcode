package com.zysaaa.zysaaa20210214;

import com.zysaaa.common.ListNode;

/**
 * 快慢指针
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                break;
            }
        }
        return slow;
    }
}
