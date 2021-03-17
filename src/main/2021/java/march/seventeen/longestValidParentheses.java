package march.seventeen;

import java.util.Stack;

public class longestValidParentheses {

    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 1) return 0;
        // 存储左括号的位置，为了计算括号的总长度
        Stack<Integer> stack = new Stack<>();
        // 记录全局最大值
        int res = 0;
        int start = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') { // 当前为左括号

                stack.push(i);
            } else {

                if (stack.isEmpty()) {
                    //当前为右括号，且stack为空，说明要抛弃当前位
                    start = i + 1;
                } else {

                    // 删除stack中的元素
                    stack.pop();
                    // 如果栈位空了，求一次start到当前位置的长度
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) :
                            // 栈没空，求当前的最大值
                            Math.max(res, i - stack.peek());

                }

            }
        }
        return res;
    }
}
