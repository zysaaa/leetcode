package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @author:zysaaa
 * @date: 2021/3/21 22:21
 */
public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode2;
        System.out.println(new RemoveDuplicateNodes().removeDuplicateNodes(listNode));
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;

        while (second != null) {
            ListNode pre = first;
            while (second != null) {
                if (second.val == first.val) {
                    pre.next = second.next;
                    second = second.next;
                } else {
                    pre = second;
                    second = second.next;
                }

            }
            first = first.next;
            if (first == null) {
                break;
            }
            second = first.next;

        }
        return head;
    }
}
