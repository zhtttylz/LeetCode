package ten_day.one;

import ten_day.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 * @author zhtttylz
 * @date 2020/8/23 10:22
 * 删除倒数第n个元素 使用两个指针,中间间隔n个,当钱一个指针到达链表末尾后,第二个指针指向的就是要进行删除的node
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || n == 0) return head;

        ListNode dummary = new ListNode(-1);
        dummary.next = head;
        ListNode slow = dummary;
        ListNode quick = dummary;

        // 这里假链表长度>=n的都合法
        while(n -- > 0) quick = quick.next;

        while(quick.next != null){

            slow = slow.next;
            quick = quick.next;
        }

        // slow 的下一个就是要删除的
        slow.next = slow.next.next;
        return dummary.next;
    }
}
