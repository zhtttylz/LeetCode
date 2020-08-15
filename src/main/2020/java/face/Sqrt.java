package face;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * @author zhtttylz
 * @date 2020/8/16 0:14
 * 求一个数的平方根，这里使用二叉
 */
public class Sqrt {

    public int mySqrt(int x) {

        if(x <= 1) return x;

        int left = 0;
        int right = x;
        int res = 0;

        while(left <= right){

            int mid = left + (right - left) / 2;
            // 小心越界
            if(mid == x / mid) return mid;

            if(mid > x / mid){

                right = mid - 1;
            }else{
                // left + 1 * right 可能会大于x 所以要保留之前的值
                res = mid;
                left = mid + 1;
            }

        }

        return res;
    }
}
