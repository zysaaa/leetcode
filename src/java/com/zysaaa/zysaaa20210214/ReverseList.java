package com.zysaaa.zysaaa20210214;

import com.zysaaa.common.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode re = reverseList(head.next);
        ListNode tmp = re;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        head.next = null;
        return re;
    }
}
