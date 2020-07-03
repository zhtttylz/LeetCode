package face;

import java.util.Stack;

/**
 * @author zhtttylz
 * @date 2020/7/3 0:15
 */
public class MyQueue {

    Stack<Integer> input = null;
    Stack<Integer> output = null;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

        this.input = new Stack<Integer>();
        this.output = new Stack<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        input.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        if (output.isEmpty()) {

            swap(input, output);
        }
        return output.pop();
    }

    private void swap(Stack<Integer> input, Stack<Integer> output) {

        while (!input.isEmpty()) {

            output.push(input.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {

        if (output.isEmpty()) {

            swap(input, output);
        }
        return output.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {

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