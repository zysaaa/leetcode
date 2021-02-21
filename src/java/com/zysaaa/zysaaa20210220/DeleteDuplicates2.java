package com.zysaaa.zysaaa20210220;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author:zysaaa
 * @date: 2021/2/20 21:02
 */
public class DeleteDuplicates2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(new DeleteDuplicates2().deleteDuplicates(listNode));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode tmp = cur.next;
                while (tmp.next != null) {
                    if (tmp.next.val == cur.val) {
                        tmp = tmp.next;
                    } else {
                        break;
                    }
                }
                pre.next = tmp.next;
                cur = tmp.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
