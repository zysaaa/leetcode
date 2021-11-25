package again.leetcode.链表;

import again.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author: zysaaa
 * @date: 2021/11/3 22:36
 */
public class 反转链表2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(reverseBetween(listNode, 2,4));
    }

    // m>=1  m<="length"
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode left = head;
        ListNode pre = dummyNode;

        for (int i = 2; i <= m; i++) {
            pre = left;
            left = left.next;
        }

        ListNode right = left;

        for (int i = m; i < n; i++) {
            right = right.next;
        }

        ListNode after = right.next;
        right.next = null;
        reverseList(left);
        ListNode next = pre.next;
        pre.next = right;
        next.next = after;
        return dummyNode.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

