package may.twenty_six;


/**
 * 反转任意长度的链表,注意反转链表要使用虚拟头节点
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) return head;
        ListNode dummary = new ListNode(Integer.MIN_VALUE);
        dummary.next = head;

        // 记录left前面的节点
        ListNode pre = dummary;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 记录left初始节点,也就是pre.next
        ListNode cur = pre.next;

        // 1-    2  -  3 -   4 - 5   ->  1-3-2-4-5 -> 1-4-3-2-5
        // pre  cur    next
        // 只需要进行right - left - 1 次即可
        while (left++ < right) {

            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummary.next;
    }

    public static void main(String[] args) {

        ReverseLinkedListII r = new ReverseLinkedListII();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        r.reverseBetween(a1, 2, 4);


    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
