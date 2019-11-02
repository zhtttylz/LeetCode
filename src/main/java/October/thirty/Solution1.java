package October.thirty;

import org.omg.CORBA.RepositoryIdHelper;

/**11. Container With Most Water
 * 使用双指针的方式,其实并不用将所有可能性列出来,因为是面积是最小边*长度
 * 所以只要不停的跳过最小边同时*两个边之间的距离即为当前最大面积
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
            }else{

                right--;
            }
        }

        return max;
    }
}
