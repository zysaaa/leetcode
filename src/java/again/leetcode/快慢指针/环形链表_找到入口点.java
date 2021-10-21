package again.leetcode.快慢指针;

import again.common.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/linked-list-cycle-ii
 * @author: zysaaa
 * @date: 2021/10/21 14:09
 */
public class 环形链表_找到入口点 {


    /**
     *
     * 注意，由于快指针的速度是慢指针2倍，所以快指针进入环之后，追上慢指针的时候，慢指针走的路程不可能超过一圈.
     *
     * 假设起点到入环点的距离为 a，顺时针方向入环点到相遇点的距离为 b，相遇点到入环点的距离为 c.
     *
     * 快指针走的路程 = 2 * 慢
     *
     * (a + b) * 2 = a + b + n(b + c) =>
     * (a + b) = n(b + c) =>
     * a = n(b + c) - b =>
     * a = n(b + c) - b - c + c =>
     * a = (n - 1)(b + c) + c =>
     *
     * 起点到入环点的距离为 a 等于 n圈距离 + 相遇点到入环点的距离为 c 所以，入环点可以有以下的逻辑找到。
     *
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;


    }

}
