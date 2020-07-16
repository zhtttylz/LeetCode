package face;

import java.util.*;

/**
 * iven an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author zhtttylz
 * @date 2020/7/16 22:01
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();

        // 先排序 logn时间复杂度
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> temp = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {

            int num = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {

                if (num + nums[left] + nums[right] == 0) {

                    temp.add(Arrays.asList(num , nums[left] , nums[right]));

                    // 排除重复数字
                    while (left < right && nums[left + 1] == nums[left]) left++;

                    while (left < right && nums[right - 1] == nums[right]) right--;

                    left++;
                    right--;
                } else if (left < right && num + nums[left] + nums[right] < 0) left++;
                else right--;
            }
        }

        for (List<Integer> i : temp) {

            res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {


        ThreeSum t = new ThreeSum();
        t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
