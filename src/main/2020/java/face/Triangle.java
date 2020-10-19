package face;

import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author zhtttylz
 * @date 2020/10/19 22:41
 * 使用压缩
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){

            return 0;
        }

        List<Integer> dp = triangle.get(triangle.size() - 1);

        // 从最外层开始递归
        for(int i = triangle.size() - 2; i >= 0; i--){

            for(int j = 0; j < triangle.get(i).size(); j++){
                // 递归式 从下开始 dp[j] = min[dp[j], dp[j + 1]] + triangle[i][j],因为每次j只使用一次，所以可以进行覆盖
                dp.set(j, triangle.get(i).get(j) + Math.min(dp.get(j), dp.get(j + 1)));
            }
        }

        return dp.get(0);
    }
}
