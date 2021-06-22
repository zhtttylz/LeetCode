package June.twenty_one;

/**
 * 删除所有重复的节点
 * 如1-2-2-2  -> 1
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummary = new ListNode(-1);
        dummary.next = head;
        ListNode pre = dummary;
        while(pre.next != null){

            ListNode cur = pre.next;

            // 排除pre后面所有重复的节点,结束标志是已经将链表遍历完了或者是cur和后面的值不相等了
            while(cur.next != null && cur.next.val == cur.val){

                cur = cur.next;
            }

            // 如果pre.next 和pre.next.next没有重复值,更新pre的位置
            if(pre.next == cur){

                pre = pre.next;
            }else{ // 即 pre.next != cur 说明cur是最后一个需要排除的node

                pre.next = cur.next;
            }
        }

        return dummary.next;
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
