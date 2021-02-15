package com.zysaaa.zysaaa20210214;

import com.zysaaa.common.ListNode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse后半部分
        ListNode reverse = reverseList(slow.next);
        // 开始比较
        while (head != null && reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode re = reverseList(head.next);
        ListNode tmp = re;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        head.next = null;
        return re;
    }
}
