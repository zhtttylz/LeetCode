package bak.两个数组求和;

//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself.
//
//
// Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//
// Example 2:
//
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//
//
// Example 3:
//
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//
// Constraints:
//
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading
// zeros.
//
// Related Topics Linked List Math Recursion
// 👍 11506 👎 2745

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.List;

/**
 * 使用归并的方法，注意要记录进位，最后单独对进位和剩余的数组进行处理
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // 创建虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 记录进位
        int next = 0;

        while(l1 != null && l2 != null){

            int l1Val = l1.val;
            int l2Val = l2.val;

            int val = l1Val + l2Val + next;
            // 创建新节点进行处理
            cur.next = new ListNode(val % 10);
            cur = cur.next;

            // 更新进位值
            next = val / 10;

            // 更新 l1 l2
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){

            int val = l1.val + next;
            // 创建新节点进行处理
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            // 更新进位值
            next = val / 10;
            // 更新 l1
            l1 = l1.next;
        }

        while(l2 != null){

            int val = l2.val + next;
            // 创建新节点进行处理
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            // 更新进位值
            next = val / 10;
            // 更新 l1
            l2 = l2.next;
        }

        if(next != 0){
            cur.next = new ListNode(next);
        }

        return dummy.next;
    }

   class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
