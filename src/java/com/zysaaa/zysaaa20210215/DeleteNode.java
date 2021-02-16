package com.zysaaa.zysaaa20210215;

import com.zysaaa.common.ListNode;

/**
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
