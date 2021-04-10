package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/4/10 18:30
 */
public class ReverseList22 {

    public ListNode reverseList(ListNode head) {

        // 迭代
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;


    }
}
