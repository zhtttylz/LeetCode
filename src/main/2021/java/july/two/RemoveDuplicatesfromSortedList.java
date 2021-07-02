package july.two;

/**
 * 删除链表中重复的元素，只保留一个即可
 * 跟之前有一道题要删除所有重复元素是同一类型
 */
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) return head;

        // 可能要删除头节点，创建虚拟头节点
        ListNode dummary = new ListNode(-1);
        dummary.next = head;

        ListNode cur = head;
        while(cur.next != null){

            ListNode next = cur.next;

            // 如果next的值和cur相等，则跳过next
            if(next.val == cur.val){

                cur.next = next.next;
            }else{

                cur = cur.next;
            }
        }

        return dummary.next;

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
