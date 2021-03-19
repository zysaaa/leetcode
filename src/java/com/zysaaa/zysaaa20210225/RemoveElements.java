package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author:zysaaa
 * @date: 2021/3/19 22:54
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}
