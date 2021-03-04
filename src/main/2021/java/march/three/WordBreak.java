package march.three;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        // dp[i] s从0到i能否被字典排序 数组第一位表示0个元素时为true
        boolean[] dp = new boolean[s.length() + 1];

        // init dp
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){

            for(int j = 0; j < wordDict.size(); j++){

                String str = wordDict.get(j);
                // 如果s可以且分出来指定字符
                if( (str.length() <= i)){

                    // 判断str是否可以进行
                    dp[i] = dp[i - str.length()] && s.substring(i - str.length(), i).equals(str);
                }

                if(dp[i]) break;
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {

        WordBreak w = new WordBreak();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("leet");
        objects.add("code");
        System.out.println(w.wordBreak("leetcode", objects));
    }
}
