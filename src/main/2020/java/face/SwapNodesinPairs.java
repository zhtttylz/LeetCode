package face;

import sun.text.normalizer.CharTrie;

import java.util.List;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author zhtttylz
 * @date 2020/6/7 17:01
 * <p>
 * 两两反转,思路就是多维护几个指针,要注意奇数个节点的情况
 */
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);

        // 两个节点转换后的需要重新指定的节点
        ListNode cur = dummy;
        cur.next = head;

        while(cur.next != null && cur.next.next != null){

            // 记录要转换的第一个节点
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            // 保留first指向second后面的节点
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
