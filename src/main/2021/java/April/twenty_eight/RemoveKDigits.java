package April.twenty_eight;

import java.util.Stack;

/**
 * 计算数组中去掉一个数后能组成的最小值
 * 使用单调递增栈
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        if(num == null || k == 0 || num.length() == 0) return num;

        if(num.length() <= k) return "0";

        char[] c = num.toCharArray();
        // 使用递增栈，当栈顶元素大于当前元素，将栈顶元素移除
        Stack<Character> stack = new Stack<>();
        stack.push(c[0]);
        for(int i = 1; i < c.length; i++){

            if(stack.isEmpty() || stack.peek() <= c[i]){

                stack.push(c[i]);
            }else{
                stack.pop();
                k--;
                i--;

                if(k == 0){

                    for(int j = i + 1; j < c.length; j++){

                        stack.push(c[j]);
                    }

                    break;
                }
            }
        }

        StringBuilder tmp = new StringBuilder();
        while(!stack.isEmpty()){
            if(--k >= 0) stack.pop();
            else
                tmp.append(stack.pop());
        }

        String res = new String();
        for(int i = tmp.length() - 1; i >= 0; i--){

            res += tmp.charAt(i);
        }

        // 做字符串头去0处理 找到第一个不为0的位置，进行切分
        int index = 0;
        for(; index < res.length() - 1;index++){

            if(res.charAt(index) != '0') break;
        }
        //while(res.c)
        return res.substring(index);
    }

    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        System.out.println(r.removeKdigits("10200", 1));
    }
}
