package face;

import java.util.List;

/**
 * @author zhtttylz
 * @date 2020/11/24 23:57
 * 判断链表是否是回文
 * 使用递归难点： 递归想不到好办法，没办法在递归过程中修改left的值
 * 使用循环： 先找到中节点，然后反转
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 先找到链表中间节点, 思考奇偶节点的情况
        ListNode quick = head;
        ListNode slow = head;
        // 确定中间节点
        while (quick.next != null && quick.next.next != null) {

            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode right = help(slow.next);
        while (head != null && right != null) {

            if (head.val != right.val) return false;
            head = head.next;
            right = right.next;
        }

        return true;
    }

    private ListNode help(ListNode head) {

        if (head.next == null) return head;
        ListNode res = help(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {

        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(p.isPalindrome(n1));
    }
}

