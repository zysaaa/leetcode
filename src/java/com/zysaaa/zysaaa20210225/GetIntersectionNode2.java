package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/4/10 16:08
 */
public class GetIntersectionNode2 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }
        return a;

    }

}
