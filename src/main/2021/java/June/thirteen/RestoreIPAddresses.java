package June.thirteen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhtttylz
 * @date 2021/6/13 20:46
 * 复原ip地址
 * 难点：
 * 1.如何确定每个ip中的每个segment都是合法的(小于255 0开始,后面不能有数如01不合法)
 * 2.如何确定每个segment 如果是0开始,后面不能有数 转为int (在转化成string判断长度是否相同)
 */
public class RestoreIPAddresses {


    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || s.length() < 4 || s.length() > 16) return res;
        help(s, 0, "", res);
        return res;
    }

    private void help(String s, int segmentCount, String tmp, List<String> res) {

        if (segmentCount == 4) {
            // 判断如果字符串为空了,再进行添加
            if(s.length() == 0) res.add(tmp);
            return;
        }

        String str = "";
        //最多遍历segment个元素,小心s越界
        for (int i = 1; i <= 4 && s.length() >= i ; i++) {
            str += s.charAt(i - 1);
            // 判断如果是0开头,或者是大于255 直接返回
            if (String.valueOf(Integer.parseInt(str)).length() != str.length() || Integer.parseInt(str) > 255) {
                return;
            }
            help(s.substring(i), segmentCount + 1, tmp + str + (segmentCount == 3 ? "" : ".") , res);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses r = new RestoreIPAddresses();
        System.out.println(r.restoreIpAddresses("25525511135"));
    }
}
