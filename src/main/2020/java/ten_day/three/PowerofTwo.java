package ten_day.three;

/**
 * @author zhtttylz
 * @date 2020/9/2 0:01
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        PowerofTwo p = new PowerofTwo();
        System.out.println(p.isPowerOfTwo(-2147483648));
    }
}
