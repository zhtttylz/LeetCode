package June.eleven;

/**
 * 寻找一个数组中的峰值，即 左右数均小于当前数的数就是峰值
 * 因为nums[-1] = nums[n] = -∞, 所以只要找最大就可以了
 * 规定了logn 所以使用二分法处理
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;
        while(left < right){

            int mid = left - (left - right) / 2;
            // 如果mid的右边是递增数组,说明峰值在右边
            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            // 如果不是递增的了,说明mid可能是峰值,将right设置为mid
            else right = mid;
        }

        return right;
    }
}
