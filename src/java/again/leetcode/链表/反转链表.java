package again.leetcode.链表;

import again.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @author: zysaaa
 * @date: 2021/11/3 22:36
 */
public class 反转链表 {



    public ListNode reverseList(ListNode head) {
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

