package April.nine;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        if(s == null || s.length() == 0) return "";
        // 存放[左边的数字
        Stack<Integer> num_stack = new Stack<>();
        // 存放[左边的字母
        Stack<String> str_stack = new Stack<>();
        // 记录[左边的数字大小
        int cun = 0;
        // 记录[左边的字母
        String str = "";
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){

            if(cs[i] >= '0' && cs[i] <= '9'){

                // 如果是数字,记录该值
                cun = cun * 10 + cs[i] - '0';
            }else if(cs[i] == '['){

                // 记录[左边的数字和字母,准备遇到]进行计算
                num_stack.push(cun);
                str_stack.push(str);
                cun = 0;
                str = "";
            }else if(cs[i] == ']'){

                // 那出[前面的数字进行循环递增
                Integer pop = num_stack.pop();
                // 将[]括号里面的字母根据数字循环后加到它前面的字符(str_stack.pop)后面
                StringBuilder ss = new StringBuilder(str_stack.pop());
                for(int j = 0; j < pop; j++) ss.append(str);
                str = ss.toString();
            }else{
                str += cs[i];
            }
        }

        return str;
    }
}
