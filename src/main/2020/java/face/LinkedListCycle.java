package face;

import javafx.beans.value.WritableLongValue;

/**
 * @author zhtttylz
 * @date 2020/6/7 19:13
 * 判断链表是否有回环 直接快慢指针
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode quick = head.next;
        ListNode slow = head;

        while (quick != null && quick.next != null) {

            if (slow.val == quick.val) return true;

            slow = slow.next;
            quick = quick.next.next;
        }

        return false;
    }
}
