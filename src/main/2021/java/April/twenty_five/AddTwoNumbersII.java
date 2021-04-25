package April.twenty_five;


import java.util.List;
import java.util.Stack;

/**
 * 难点：链表如何进行尾部对其 使用栈先进后出特性
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();

        ListNode dummy = new ListNode(-1);
        ListNode cur = null;
        int next = 0;

        while (l1 != null){

            l1Stack.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null){

            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        while(!l1Stack.isEmpty() || !l2Stack.isEmpty()){

            int a = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int b = l2Stack.isEmpty() ? 0 : l2Stack.pop();

            ListNode node = new ListNode((a + b + next) % 10);
            node.next = cur;
            cur = node;

            next = (a + b + next) / 10;
        }

        if(next != 0){

            ListNode node = new ListNode(next);
            node.next = cur;
            cur = node;
        }

        return cur;
    }



    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
