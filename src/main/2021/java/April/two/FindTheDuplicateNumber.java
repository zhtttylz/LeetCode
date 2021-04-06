package April.two;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        // nums里面的数是从1到n的，而nums.length有n+1个数,所以使用二分法进行处理
        int left = 1;
        int right = nums.length;
        while(left < right){

            int mid = left - (left - right) / 2;
            // 统计nums数组中小于mid的个数,从而判断重复数在mid的左边还是右边
            int num = 0;
            // 注意，这里要统计等于mid的数的个数，方便下面进行判断
            for (int i : nums) {
                if(i <= mid) num++;
            }

            // 说明重复数在mid的右边
            if(num <= mid){

                left = mid + 1;
            }else{

                right = mid;
            }
        }
        return left;

    }


    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        System.out.println(f.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
