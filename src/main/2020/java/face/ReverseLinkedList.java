package face;

import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;

import java.awt.*;

/**
 * 反转单链表
 * 递归,循环方式,代码控制在10行以内
 * @author zhtttylz
 * @date 2020/6/7 12:07
 */
public class ReverseLinkedList {

    /**
     * 循环
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode cur  = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归方式,关键在于保存最后的节点返回上一层
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
