package july.one;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        // 使用奇偶指针
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode tmp = head.next;

        while(cur != null && cur.next != null){

            pre.next = cur.next;
            cur.next = cur.next.next;

            pre = pre.next;
            cur = cur.next;
        }

        pre.next = tmp;
        return head;
    }

    class ListNode {
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
