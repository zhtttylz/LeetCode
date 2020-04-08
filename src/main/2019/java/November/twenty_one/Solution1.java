package November.twenty_one;

/**
 * @author zhtttylz
 * @date 2019/11/22 0:12
 * 41. First Missing Positive
 * 找寻一个数组中缺少的一个正整数，难点是怎么不适用额外空间，并且时间复杂度是o（n）
 * 肯定不崩使用额外内存的方式，所以可以使用数组替换的方式,将数组中的每个整数移动到指定的位置,1移动到[0]的位置
 * 然后遍历数组,如果发现某一位的角标+1雨当前位的数值不同,则返回当前角标+1
 */
public class Solution1 {

    public int firstMissingPositive(int[] nums) {

        if(nums == null || nums.length == 0){

            return 1;
        }

        int size = nums.length;

        // 将数组中的每一位数放到指定的位置上，如1就应该放到nums[0]这一位上
        for(int i = 0; i < nums.length; i++){

            // 三种判断条件 使用while循环,目的是不停的将替换到的当前位置的数移动到属于它的位置
            // 角标i代表的数必须是正数才有替换的价值
            // 确定nums[i]这个数可以放入到数组中,防止越界
            // 当前数nums[i] 如果它的位置不是处于数组中它应该在的位置(当前数-1作为nums的角标),则要进行替换
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                // swap 注意,如果直接swap,因为nums[i]的值改变了,所以nums[nums[i] - 1]也会改变
                int a = nums[i] - 1;
                int b = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[a] = b;
            }
        }

        // 数组角标从0开始,第一个数是1,依次向后
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != i + 1){

                return i + 1;
            }
        }
        // 注意顺序正整数数组的情况
        return nums.length + 1;
    }


    public static void main(String[] args) {

        Solution1 s = new Solution1();
        System.out.println(s.firstMissingPositive(new int[]{-1,4,2,1,9,10}));
    }
}
