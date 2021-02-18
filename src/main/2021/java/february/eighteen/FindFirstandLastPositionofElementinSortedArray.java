package february.eighteen;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int index = help(0, nums.length - 1, target, nums);
        if(index == -1) return new int[]{-1, -1};
        int left = index;
        int right = index;
        while(left > 0 && nums[left - 1] == target) --left;
        while(right < nums.length - 1 && nums[right + 1] == target) ++right;

        return new int[]{left, right};
    }

    public int help(int left, int right, int target, int[] nums){

        if(left > right) return -1;
        int mid = left + (right - left) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return help(left + 1, right, target, nums);
        else return help(left, right - 1, target, nums);
    }
}
