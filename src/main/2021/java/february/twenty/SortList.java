package february.twenty;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SortList {

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;

        // 慢指针，记录将整个链表拆开的右子链表起始位置
        ListNode slow = head;
        // 快指针，记录何时到达链表末尾
        ListNode fast = head;

        // 记录断开链表的左子链表的结束位置
        ListNode pre = head;

        while(fast != null && fast.next != null){

            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 断开链表之间的连接，避免左边链表越界到右边链表
        pre.next = null;
        // 链表拆成两个子链表，返回的是两个有序链表，使用归并（help）进行排序
        //1-2-3-4-5-6 =>  (1-2-3)   (4-5-6) => (1-2) (3) => ((1-2)  (3))
        return help(sortList(head), sortList(slow));
    }

    public ListNode help(ListNode l1, ListNode l2){

        // 虚拟头节点
        ListNode dummary = new ListNode(-1);
        ListNode cur = dummary;

        while(l1 != null && l2 != null){

            if(l1.val > l2.val){

                cur.next = l2;
                l2 = l2.next;
            }else{

                cur.next = l1;
                l1 = l1.next;
            }

            cur = cur.next;
        }

        // 将剩余的有序链表拼接到已经排好序的链表后面
        if(l1 != null) cur.next = l1;
        if(l2 != null) cur.next = l2;

        return dummary.next;
    }
}
