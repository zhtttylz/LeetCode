package face;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @author zhtttylz
 * @date 2020/7/22 0:36
 * 使用分治的方法进行求解 注意栈溢出的情况
 */
public class Powxn {

    public double myPow(double x, int n) {

        if (n == 0) return 1;

        if (n == Integer.MIN_VALUE) {
            n = n / 2;
            x *= x;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if ((n & 1) == 1)
            return x * myPow(x, n - 1);
        // 2的6次幂  2*2 4*4 8*8
        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {

        System.out.println(1 / Integer.MIN_VALUE);
        Powxn p = new Powxn();
        System.out.println(p.myPow(2, Integer.MIN_VALUE));
    }
}
