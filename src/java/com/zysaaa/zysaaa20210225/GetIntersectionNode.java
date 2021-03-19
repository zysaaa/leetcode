package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author:zysaaa
 * @date: 2021/3/19 22:39
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode listNode = hasIt(headA, headB);
            if (listNode != null) {
                return listNode;
            } else {
                headA = headA.next;
            }
        }
        return null;
    }

    private ListNode hasIt(ListNode node, ListNode list) {
        while (list != null) {
            if (node == list) {
                return list;
            }
            list = list.next;
        }
        return null;
    }
}
