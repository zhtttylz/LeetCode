package April.fifteen;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0 || k == 0 || k > nums.length) return 0;

        int left = 0;
        int right = nums.length - 1;

        // 注意第k大的数在数组中的角标是反过来的
        int tmp = nums.length - k;

        while(left <= right) {
            // 使用类似快排的办法进行处理,每次返回中间值
            int index = help(nums, left, right);
            if (index == tmp) return nums[index];
            // 注意 topK是倒序
            if (tmp > index) left = index + 1;
            else right = index - 1;
        }

        return 0;
    }

    private int help(int[] nums, int left, int right) {

        // 以left作为要放到中间的值，让left<= num <= right
        int num = nums[left];
        int l = left + 1;
        // 最终right指向第一个<=num的位置
        while(l <= right){

            if(nums[l] > num && nums[right] < num){
                int tmp = nums[l];
                nums[l] = nums[right];
                nums[right] = tmp;
                l++;
                right--;
            }

            if(nums[l] <= num) l++;
            if(nums[right] >= num) right--;
        }

        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;

        return right;
    }

    public static void main(String[] args) {

        KthLargestElementInAnArray k = new KthLargestElementInAnArray();
        System.out.println(k.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 6));
    }
}
