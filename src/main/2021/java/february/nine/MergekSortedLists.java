package february.nine;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        // 创建一个虚拟头节点，每次从数组中找出做小的链表
        // 难点1 如何确定数组中每个链表都已经遍历完成了？ 这里使用标记的方法，新建一个boolean数组记录是否全部完成
        boolean[] bool = new boolean[lists.length];
        // 初始化bool数组,将[]链表设置为true, 同时排除全空数组的情况
        boolean b = true;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                bool[i] = true;
            }else{
                b = false;
            }
        }

        if(b) return null;
        // 结束标注：所有的链表都已经遍历完成
        boolean down = true;
        // 虚拟头节点
        ListNode dummary = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummary;
        while (down) {

            int nextIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (!bool[i] && lists[i].val <= min) {
                    min = lists[i].val;
                    nextIndex = i;
                }
            }

            // 将选出来的node的next设置为list中的下一个节点
            cur.next = lists[nextIndex];
            cur = cur.next;
            // 这里要修改list的引用
            lists[nextIndex] = lists[nextIndex].next;
            // 如果某个链表移动完了，将字典记录为true
            if (lists[nextIndex] == null) bool[nextIndex] = true;

            // 结束条件：数组中所有链表都已经添加到新链表中
            for (int i = 0; i < bool.length; i++) {
                down = false;
                if (!bool[i]) {
                    down = true;
                    break;
                }
            }
        }
        return dummary.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}