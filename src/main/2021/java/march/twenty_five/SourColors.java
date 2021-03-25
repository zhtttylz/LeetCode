package march.twenty_five;

public class SourColors {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) return;
        // 记录红色和蓝色指针，red左边的都是0 blue右边的都是2
        int red = 0;
        int blue = nums.length - 1;

        for (int i = 0; i <= blue; i++) {

            if (nums[i] == 0) {

                swap(nums, i, red);
                red++;
            } else if (nums[i] == 2) {

                swap(nums, i, blue);
                blue--;
                // 有可能当前位置是0，需要在进行一次处理
                i--;
            }
        }
    }
    void swap(int[] nums, int i, int index){

        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}
