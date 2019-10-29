package October.twenty_eight;

import java.util.HashMap;
import java.util.Map;

/** Two Sum
 * @author zhtttylz
 * @date 2019/10/29 23:27
 */
public class Solution {
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];

        if(nums == null || nums.length < 2){

            return res;
        }
        // 简单方法，二重循环
        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                if(nums[i] + nums[j] == target){

                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    /**
     * 采用字典的方式，每次经过一个数就将其存起来，如果发现有差值跟存储的数相同的，直接返回即可
     * target = a + b, target- b = a, map.put(b, index), if(map.containskey(a)) success
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        if (nums == null || nums.length < 2) {

            return res;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            // 如果nums[i]和target的差值在map中有记录，说明找到了想要的值
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }else{
                // 将这个数与其角标存放
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
