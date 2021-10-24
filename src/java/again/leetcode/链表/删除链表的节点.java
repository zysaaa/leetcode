package again.leetcode.链表;

import again.common.ListNode;

/**
 * @description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 *              返回删除后的链表的头节点。 题目保证链表中节点的值互不相同
 * @author: zysaaa
 * @date: 2021/10/24 14:21
 */
public class 删除链表的节点 {


    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            } else {
                pre = head;
                head = head.next;
            }
        }


        return dummyNode.next;


    }

}
