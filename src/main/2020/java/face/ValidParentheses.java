package face;

import java.util.Stack;

/**
 * @author zhtttylz
 * @date 2020/6/28 23:16
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * 天然使用栈,每次遇到一个右括号就进行比对处理
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if(s == null || s.length() == 0) return true;

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for(char c : chars){

            if(c == ']' || c == ')' || c == '}'){

                if(stack.isEmpty()) return false;
                Character pop = stack.pop();
                if(c == ']' && pop != '[') return false;
                if(c == ')' && pop != '(') return false;
                if(c == '}' && pop != '{') return false;

            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {


        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()"));
    }
}
