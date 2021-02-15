package com.zysaaa.zysaaa20210214;

import com.zysaaa.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 快慢找到中点。
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 拆
        ListNode next = slow.next;
        slow.next = null;
        // 翻转后半段
        ListNode reverse = revereList(next);
        while (head != null && reverse != null) {
            ListNode tmpHead = head.next;
            ListNode tmpReverse = reverse.next;
            head.next = reverse;
            reverse.next = tmpHead;
            head = tmpHead;
            reverse = tmpReverse;
        }
    }

    private ListNode revereList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
