package com.zysaaa.zysaaa20210214;

import com.zysaaa.common.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode {
    // 4 5 1 9  = > 1
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }

    // 哑节点
    public ListNode deleteNode2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        dummyHead.next = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                break;
            }
            pre = pre.next;
        }
        return dummyHead.next;
    }

}
