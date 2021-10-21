package again.leetcode.快慢指针;

import again.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/linked-list-cycle
 * @author: zysaaa
 * @date: 2021/10/21 14:09
 */
public class 环形链表_判断是否有环 {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
