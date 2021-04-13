package April.thirteen;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        if(nums == null || nums.length <= 1) return;
        // 使用双指针
        int left = 0;

        // 获取起止位置
        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 0) {
                left = i;
                break;
            }
        }

        for(int i = left; i < nums.length; i++){

            if(nums[i] != 0){

                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                left++;
            }
        }
    }

    public static void main(String[] args) {

        MoveZeroes m = new MoveZeroes();
        m.moveZeroes(new int[]{0,1,0,3,12});
    }

}
