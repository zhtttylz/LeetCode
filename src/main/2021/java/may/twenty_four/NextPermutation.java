package may.twenty_four;

import java.util.Arrays;

/**
 * 下一个字典序数组
 * 找规律:从最后一位找到第一个降序的数,将其和右边第一个大于他的进行互换
 * 互换完成后,将互换完成的数+1位到最后进行调换即可
 *
 * 从右往左全部升序,说明需要将整个数组进行转换
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length <= 1) return;

        // 从右往左遍历
        for(int i = nums.length - 1; i > 0; i-- ){

            // 如果当前位置的前一位比当前位置小,找到了降序点 为i-1
            if(nums[i] > nums[i - 1]){

                int j = nums.length - 1;
                // 从右边找到第一个大于i - 1的数
                for(; j > (i -1); j--){

                    if(nums[j] > nums[i - 1]) break;;
                }

                // 先调换
                swap(i - 1, j, nums);
                // 将从i后面的数进行排序
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }

        // 最后说明需要将整个数组进行全排序
        Arrays.sort(nums);
        return;
    }

    private void swap(int i, int j, int[] nums) {

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        NextPermutation n = new NextPermutation();
        n.nextPermutation(new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
    }

}
