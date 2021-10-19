package com.zysaaa.zysaaa20210215;

import com.zysaaa.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head)) {
                return head;
            }
            list.add(head);
            head = head.next;
        }
        return null;
    }

    // 快慢指针 ？？
    public ListNode detectCycle2(ListNode head) {
        return null;
    }
}
