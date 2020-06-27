package face;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * @author zhtttylz
 * 因为快指针每次走2，慢指针每次走1，快指针走的距离是慢指针的两倍。
 * 而快指针又比慢指针多走了一圈。所以 head 到环的起点+环的起点到
 * 他们相遇的点的距离 与 环一圈的距离相等。现在重新开始，head
 * 运行到环起点 和 相遇点到环起点 的距离也是相等的，相当于他们
 *  同时减掉了 环的起点到他们相遇的点的距离
 *
 * @date 2020/6/7 22:38
 */                                                                                                                                                                                                                                                                                                         
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode quick = head;

        while(quick != null && quick.next != null){

            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick){

                slow = head;
                while(slow != quick) {

                    slow = slow.next;
                    quick = quick.next;
                }

                return slow;
            }
        }

        return null;
    }
}
