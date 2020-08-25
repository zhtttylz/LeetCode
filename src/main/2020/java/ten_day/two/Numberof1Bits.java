package ten_day.two;

/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 * @author zhtttylz
 * @date 2020/8/25 23:59
 * x &（x - 1） 每次都去掉1后面的所有的0
 */
public class Numberof1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        if(n == 0) return 0;
        int res = 0;

//        while(n != 0){
//
//            if((n & 1) == 1) res ++;
//            n = n >> 1;
//        }

        while(n != 0){

            res ++;
            // 如 3：11 2：10   做&操作就会去掉左后的一个0，然后再去掉0，知道变为1
            n = n & (n - 1);
        }

        return res;
    }

    public static void main(String[] args) {

        Numberof1Bits b = new Numberof1Bits();
        System.out.println(b.hammingWeight(5));
    }
}
