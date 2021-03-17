package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/comments/
 * @author:zysaaa
 * @date: 2021/3/17 22:39
 */
public class DeleteNode {


    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode node = dummy.next;
        while (node.val != val) {
            pre = node;
            node = node.next;
        }
        pre.next = node.next;
        return dummy.next;

    }
}
