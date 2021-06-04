package June.one;

import java.util.Arrays;
import java.util.Collections;

/**
 * 将字符串按照空格切割后进行反转
 * 使用java构造函数，只需要4行
 */
public class ReverseWordsinAString {

    public String reverseWords(String s) {

        if(s == null || s.length() == 0) return s;
        String[] strs = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(strs));
        return String.join(" ", strs);
    }

    public static void main(String[] args) {

        ReverseWordsinAString r = new ReverseWordsinAString();
        System.out.println(r.reverseWords("hello world"));
    }
}
