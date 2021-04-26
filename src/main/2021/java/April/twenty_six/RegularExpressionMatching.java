package April.twenty_six;

public class RegularExpressionMatching {

    /**
     * 关键在于对*的处理
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        // 如果正则p为空，s不为空直接反false 反之不行，因为如a*等同于空
        if(p.isEmpty()) return s.isEmpty();
        // 如果p长度为1 直接进行比对
        if(p.length() == 1) return s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));

        // 如果第二位不等于* 则判断当前位置和去掉当前位置后是否匹配即可,
        if(p.charAt(1) != '*'){
            // 如果p的当前位置有字符,但是s没有了,并且p的第二位没有*让当前位位0 返回false
            if(s.isEmpty()) return false;
            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

        // 如果第二位为* 则需要循环遍历当前位置是否可以用p进行匹配
        while(!s.isEmpty() && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))){

            // 假设第二位*的作用是让第一位和第二位长度位0，对此情况进行计算
            if(isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }

        // 最后需要排除(“b” “a*b”) (“” “a*”)需要去掉p的前两位的情况
        return isMatch(s, p.substring(2));
    }

    public static void main(String[] args) {

        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("a", ".*..a*"));
    }
}
