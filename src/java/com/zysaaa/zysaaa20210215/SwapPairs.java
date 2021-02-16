package com.zysaaa.zysaaa20210215;

import com.zysaaa.common.ListNode;

public class SwapPairs {


    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = head.next;
        ListNode tmp = head2.next;
        head2.next = head1;
        head1.next = swapPairs(tmp);
        return head2;


    }
}
