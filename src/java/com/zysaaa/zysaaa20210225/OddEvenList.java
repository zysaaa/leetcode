package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/odd-even-linked-list/
 * @author:zysaaa
 * @date: 2021/3/9 20:45
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode tmp = head.next;
        ListNode even = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = tmp;
        return head;

    }
}
