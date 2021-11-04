package again.leetcode.链表;

import again.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author: zysaaa
 * @date: 2021/11/3 19:36
 */
public class 两个链表的第一个公共节点 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> listNodes = new ArrayList<>();

        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (listNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;

    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }


}
