package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;

import java.util.Stack;

/**
 * @description: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @author:zysaaa
 * @date: 2021/3/9 22:45
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = stack.pop();
        ListNode newhead = result;
        while (!stack.isEmpty()) {
            result.next = stack.pop();
            result = result.next;
        }
        result.next = null;
        return newhead;
    }
}
