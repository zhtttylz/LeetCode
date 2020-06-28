package backup;

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

        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        for(int i = 1; cur != null; i++){

            // 将链表从pre到cur.next进行反转
            if(i % k == 0){

                // 返回变换后的头节点
                pre = help(pre, cur.next);

                // 这里cur的值已经在上面发生了改变
                cur = pre.next;
            }else{

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

            // cur指向后一个节点,也就是pre.next
            cur.next = pre.next;

            // pre.next最终要指向最后的一个节点,也就是cur
            pre.next = cur;
            cur = last.next;
        }

        return last;
    }
}


