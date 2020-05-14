package top100;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 求出链表加和
 * @author zhtttylz
 * @date 2020/5/14 21:15
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int num = 0;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int carry = 0;

        while(l1 != null || l2 != null){

            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            ListNode node = new ListNode((n1 + n2 + carry) % 10);
            cur.next = node;
            cur = cur.next;
            carry = (n1 + n2 + carry) / 10;

            if(l1!= null) l1 = l1.next;
            if(l2!= null) l2 = l2.next;

        }
        // 处理进位
        if(carry != 0) cur.next = new ListNode(carry);
        return dummy.next;
    }
}
