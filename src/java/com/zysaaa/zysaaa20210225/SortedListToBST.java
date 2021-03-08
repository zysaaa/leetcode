package com.zysaaa.zysaaa20210225;

import com.zysaaa.common.ListNode;
import com.zysaaa.common.TreeNode;

/**
 * @description: https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @author:zysaaa
 * @date: 2021/3/8 21:08
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        ListNode next = slow.next;

        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(next);
        return treeNode;

    }


}
