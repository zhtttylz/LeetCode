package may.eight;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        if(nums == null || nums.length <= 1) return 0;

        // copy nums 进行排序
        int[] tmp = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while(i < nums.length && nums[i] == tmp[i]) i++;
        while(j >= i && nums[j] == tmp[j]) j--;

        return j - i + 1;

    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        int unsortedSubarray = s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});

    }
}
