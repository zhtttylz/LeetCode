package face;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author zhtttylz
 * @date 2020/7/17 0:11
 * 4sum 跟院线一样,使用先排序,然后双重循环的方式进行处理
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Set<List<Integer>> temp = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {

                        temp.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }else if (left < right && nums[i] + nums[j] + nums[left] + nums[right] < target) left++;
                    else right--;
                }
            }
        }

        for(List<Integer> l : temp){

            res.add(l);
        }

        return res;
    }
}
