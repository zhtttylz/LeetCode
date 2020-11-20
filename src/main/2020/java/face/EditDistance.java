package face;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * <p>
 * dp[i][j] 两个字符串前i和j相等需要进行的操作
 * 三种情况
 * word[i] == word[j] dp[i][j] = dp[i -1][j - 1]
 * dp[i][j] = Min( delete(dp[i - 1][j])
 * insert[dp[i][j - 1]]
 * replace[dp[i - 1][j - 1]]
 * )
 *
 * @author zhtttylz
 * @date 2020/11/21 0:31
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        if (word1 == null && word2 == null) return 0;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();

        // init
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 当word2没有字符时,word1需要进行word1长度的处理才能相等
        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        //i= 1是为了避免角标越界,word从0开始,但是dp数组是从1(一个字母)开始匹配的
        for (int i = 1; i <= word1.length(); i++) {

            for (int j = 1; j <= word2.length(); j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    // word1 delete dp[i - 1][j] + 1
                    // word1 insert w1[i + 1]=w2[j]   w1[i] = w2[j - 1] dp[i][j - 1] + 1
                    // replace dp[i - 1][j - 1] + 1
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(
                            dp[i][j - 1], dp[i - 1][j - 1]
                    )) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        EditDistance e = new EditDistance();
        System.out.println(e.minDistance("horse", "ros"));
    }
}
