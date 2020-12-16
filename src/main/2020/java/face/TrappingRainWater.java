package face;

import java.util.Arrays;
import java.util.Stack;

/**Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



 Example 1:


 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Example 2:

 Input: height = [4,2,0,3,2,5]
 Output: 9


 Constraints:

 n == height.length
 0 <= n <= 3 * 104
 0 <= height[i] <= 105
 * @author zhtttylz
 * @date 2020/12/17 0:02
 * 求出总共的能接住雨水的量
 * 对于数组中每一位能接住的雨水为左右两边大于当前位的最小值和当前位的差值
 * height[i]能接住的雨水 = min(left, right) - height[i] left 和right均>height[i]
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        if(height == null || height.length <= 2) return 0;

        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];

        int res = 0;

        // dpleft[i] 到第i个数为止,左边最大的数
        for(int i = 1; i < height.length; i++){
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
        }

        // dpRight[i] 到第i个数为止,右边最大数
        for(int i = height.length - 2; i >= 0; i--){

            dpRight[i] = Math.max(dpRight[i + 1], height[i + 1]);
        }

        // 数组的第一位和最后一位不用进行计算
        for(int i = 1; i < height.length - 1; i++){
            // 计算每一位的左右两边是否有大于的,如果有,则取最小值和当前位的差值,否则不做计算
            int num = height[i];
            if(dpLeft[i] > num && dpRight[i] > num){
                res += Math.min(dpLeft[i], dpRight[i]) - num;
            }
        }

        return res;
    }

    /**
     * 使用栈进行运算,类似于括号匹配,但是要计算两个数之间的差值
     * @param height
     * @return
     */
    public int trap1(int[] height) {

        if(height == null || height.length <= 2) return 0;

        // 使用栈,存放的是每一位的角标
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int res = 0;
        while(index < height.length){

            // 如果当前位>栈顶元素,说明能接住雨水了,要进行计算
            while(!stack.isEmpty() && stack.peek() < height[index]){

                int num = stack.pop();
                //计算当前长度和栈顶元素长度的差值
                int diff = index - num;
                res += diff * (height[index] - height[num]);
            }

            stack.push(height[index]);
            index++;
        }

        return res;
    }
}
