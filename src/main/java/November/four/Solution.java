package November.four;

import java.util.*;

/**3Sum
 * @author zhtttylz
 * @date 2019/11/4 23:12
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length == 0){

            return new ArrayList<List<Integer>>();
        }

        // 首先排序， 时间复杂度O(nlogn) sort 是从小到大
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<List<Integer>>();


        // 因为是三个数，所以i只到长度-2的位置
        for(int i = 0; i < nums.length - 2; i++){

            // 如果当前位和前一位的数值相同，要排除重复值
            if(i >= 1 && nums[i] == nums[i - 1]){

                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            // 双指针的方式进行计算
            while(left < right){

                // 分别移动左右指针
                if(nums[left] + nums[right] + nums[i] > 0){

                    right--;
                }else if (nums[left] + nums[right] + nums[i] < 0){

                    left ++;
                }else{// 三个数相加等于零的情况

                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));

                    // 排除重复值 这里是先将right--和left++ 的顺序的问题在下面
                    right--;
                    while(right >= 0 && nums[right] == nums[right + 1])
                        right--;
                    left++;
                    while(left < nums.length && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }

        return res;
    }

    // hashset 只要是值相同，也算是同一个对象
    public static void main(String[] args) {

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);

        set.add(l1);
        set.add(l2);

        int[] nums = new int[]{4,3,2,7,9};
        Arrays.sort(nums);
        System.out.println(nums[0]);

        System.out.println(l1.hashCode() == l2.hashCode());
    }
}

