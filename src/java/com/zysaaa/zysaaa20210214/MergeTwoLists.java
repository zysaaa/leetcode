package com.zysaaa.zysaaa20210214;

import com.zysaaa.common.ListNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

}
