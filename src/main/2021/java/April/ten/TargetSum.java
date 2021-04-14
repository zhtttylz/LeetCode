package April.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中的数相加减能够得到target的个数
 */
public class TargetSum {

    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        help(nums, target, 0, 0);

        return res;
    }

    private void help(int[] nums, int target, int tmp, int start) {

        if (target == tmp && start == nums.length) {
            res++;
        }

        if(start >= nums.length) return;

        // 对于当前数可以+或者-,因为不能跳过中间数值，所以不使用循环
        help(nums, target, tmp - nums[start], start + 1);
        help(nums, target, tmp + nums[start], start + 1);
    }

    public static void main(String[] args) {

        TargetSum ts = new TargetSum();
        System.out.println(ts.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
