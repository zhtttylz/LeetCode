package October.thirty;

import org.omg.CORBA.RepositoryIdHelper;

/**11. Container With Most Water
 * 使用双指针的方式
 * @author zhtttylz
 * @date 2019/11/3 3:00
 */
public class Solution1 {

    public int maxArea(int[] height) {

        if(height == null || height.length == 0){

            return 0;
        }

        int max = 0;

        int left = 0;
        int right = height.length - 1;

        // 使用双指针
        while(left < right){

            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

            // 如果左边的边小，则左指针右移
            if(height[left] < height[right]){

                left ++;
            }else{// 如果left > right了 说明right已经和left之前的所有比它小的边组成过矩形了

                right--;
            }
        }

        return max;
    }
}
