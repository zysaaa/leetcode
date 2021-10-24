package again.leetcode.链表;

import again.common.ListNode;

/**
 * @description:存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *  *
 *  * 返回同样按升序排列的结果链表。
 *  *
 *  * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author: zysaaa
 * @date: 2021/10/24 14:26
 */
public class 删除链表中重复的节点 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head.next;
        ListNode pre = head;

        while (node != null) {
            if (node.val == pre.val) {
                pre.next = node.next;
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return head;

    }
}
