package face;

import java.util.List;

/**
 * @author zhtttylz
 * @date 2020/6/27 21:50
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * 反转指定长度的链表 虚拟头节点需要多多练习
 */
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        for(int i = 1; cur != null; i++ ){

            if(i % k == 0){

                // 返回变换完成后的链表的尾节点
                pre = help(pre, cur.next);
                // 因为cur的值在上面发生了变化，所以要更新为pre.next
                cur = pre.next;
            }else {
                cur = cur.next;
            }
        }


        return dummy.next;
    }
    private ListNode help(ListNode pre, ListNode next) {

        ListNode last = pre.next;
        ListNode cur = last.next;

        while(cur != next){

            last.next = cur.next;
            cur.next = pre.next;
            pre.next  = cur;
            cur = last.next;
        }

        return last;
    }
}


