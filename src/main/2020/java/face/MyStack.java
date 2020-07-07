package face;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhtttylz
 * @date 2020/7/7 8:36
 * 用队列实现栈
 * 队列：先进先出
 * 栈：先进后出
 * 双端队列即可解决
 */
public class MyStack {

    Deque<Integer> deque = null;

    /** Initialize your data structure here. */
    public MyStack() {

        this.deque = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {

        deque.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        return deque.removeLast();
    }

    /** Get the top element. */
    public int top() {

        return deque.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
