package face;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 * @author zhtttylz
 * @date 2020/8/16 20:17
 * 判断一个属是不是完美平方，使用二分法，当找不到刚刚好相乘等于接过书的数的时候，直接返回false
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        if(num <= 1) return true;

        int left = 0;
        int right = num;

        while(left <= right){
            int mid = left - (left - right) / 2;

            if(mid == 0) return false;

            if(mid * mid == num) return true;

            if(mid >= num / mid){

                right = mid - 1;
            }else{

                left = mid + 1;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        ValidPerfectSquare v = new ValidPerfectSquare();
        System.out.println(v.isPerfectSquare(5));

    }
}
