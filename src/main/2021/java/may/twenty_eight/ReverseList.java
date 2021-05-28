package may.twenty_eight;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
