package October.thirty;

import sun.nio.cs.ext.MacHebrew;

/**11. Container With Most Water
 *  * 缺点是遍历了两次，所以时间复杂度是N*N
 * @author zhtttylz
 * @date 2019/10/31 0:08
 */
public class Solution {

    public int maxArea(int[] height) {

        if(height == null || height.length == 0){

            return 0;
        }

        int max = 0;

        // 使用二重循环，找出所有的可能
        for(int i = 0; i < height.length; i++){

            // 选定左侧的边
            int left = height[i];

            for(int j = i + 1; j < height.length; j++){

                // 计算出i和j之间的距离
                int len = j - i;
                // 计算出两个边的最下边
                int hei = Math.min(height[i], height[j]);
                max = Math.max(hei * len, max);
            }
        }

        return max;
    }
}
