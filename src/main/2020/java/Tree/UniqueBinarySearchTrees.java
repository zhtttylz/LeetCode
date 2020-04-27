package Tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 可以看作斐波那契数列
 * 当为空树的时候，即n=0的时候赋值为1
 * 当只有一个节点的时候，即n=1的时候 左右子树都是空树，所以为1*1为1
 * 当n=2的时候，1和2都可以作为根节点,所以，递推式就是dp[0] * dp[1] + dp[1] * dp[0]
 * dp[2] = dp[0] * dp[1]  (根为1的情况,左子树为空,右子树有一个数字)
 * + dp[1] * dp[0]  (根为2的情况,右子树为空,左子树有一个数字)
 * <p>
 * dp[3] = dp[0] * dp[2]  (根为1的情况,左子树为空,右子树有2个节点)
 * + dp[1] * dp[1]  (根为2的情况,右子树有一个节点,左子树有一个节点)
 * + dp[2] * dp[0]  (根为3的情况,右子树为有两个节点,左子树有一个节点)
 *
 * @author zhtttylz
 * @date 2020/4/28 0:17
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        if (n == 0) {

            return 0;
        }
        // 求第n个数,长度n+1
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){

            for(int j = 0; j < i; j++){

                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        // 返回第n个数
        return dp[n];
    }
}
