package february.eight;
//You are given an integer array nums sorted in ascending order (with distinct v
//alues), and an integer target.
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
//0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// If target is found in the array return its index, otherwise, return -1.
//
//
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3:
// Input: nums = [1], target = 0
//Output: -1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104
//
// Related Topics Array Binary Search
// 👍 6880 👎 607
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) return -1;
        // 使用二分查找查找数组中某个值
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){

            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return  mid;

            // 难点是如何在反转的有序数组中进行二分查找
            //如果 num[mid] < num[right] 说明从mid到right是有序的,只要判断target是否在这个集合里面,就可以进行二分查找
            if(nums[mid] < nums[right]){

                // 如果右边有序,则判断target是否在右边的数组中
                if(nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }else{

                // 左边数组有序,判断target是否在左边数组里
                if(nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            }

        }

        return -1;
    }
}
