package com.zysaaa.zysaaa20210215;

import com.zysaaa.common.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode result = null;
        while (k -- > 0) {
            result = list.removeLast();
        }
        return result;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (k -- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;




    }
}
