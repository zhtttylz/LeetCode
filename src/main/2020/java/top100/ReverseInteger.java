package top100;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * 反转一个数，可以理解为求这个数的个位 求个位就是对10取余 %10 去掉最后一位就是 /10
 * @author zhtttylz
 * @date 2020/5/21 0:29
 */
public class ReverseInteger {

    public int reverse(int x) {

        if(x == 0) return 0;

        Long res = 0l;
        while(x != 0){

            int tmp = x % 10;
            System.out.println(tmp);
            x = x / 10;
            res = res * 10 + tmp;
            System.out.println(res);
        }

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = 0l;

        return x < 0 ? 0 - res.intValue() : res.intValue();
    }
}
