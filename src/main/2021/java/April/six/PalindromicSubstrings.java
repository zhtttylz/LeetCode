package April.six;

public class PalindromicSubstrings {
    int res = 0;
    // fdsklf
    public int countSubstrings(String s) {

        if(s == null || s.length() <= 1) return s.length();
        char[] chars = s.toCharArray();
        // 以每个char作为中间节点同时向左右扩散,这里要注意奇偶
        for(int i = 0; i < chars.length; i++){

            // 以i为中间数向外扩散
            help(i, i, chars);

            // 以i和i+1为中间数向外扩散
            help(i, i + 1, chars);
        }
        return res;
    }

    private void help(int left, int right, char[] chars) {

        // 从中间向外扩散,小心越界
        for(;left >= 0 && right < chars.length; left--, right++){

            if(chars[left] == chars[right]) res++;
                // 不满足不继续遍历了,直接退出
            else return;
        }
    }
}
