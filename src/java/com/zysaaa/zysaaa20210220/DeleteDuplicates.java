package com.zysaaa.zysaaa20210220;

import com.zysaaa.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author:zysaaa
 * @date: 2021/2/20 20:54
 */
public class DeleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tmp;
    }
}
