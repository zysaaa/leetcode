package again.leetcode.链表;

import again.common.ListNode;

/**
 * @description: https://leetcode-cn.com/submissions/detail/153128690/
 * @author: zysaaa
 * @date: 2021/11/4 19:40
 */
public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode tmp = head.next;
        ListNode even = head.next;

        while (odd.next != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = tmp;
        return head;

    }
}
