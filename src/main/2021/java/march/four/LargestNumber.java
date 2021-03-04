package march.four;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        if(nums == null || nums.length == 0) return null;
        if(nums.length == 0) return nums[0] + "";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){

            strs[i] = nums[i] + "";
        }
        // 自定义比较器，比较结果为ab ba 相比较的升序排列
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(strs, comparator);
        StringBuilder str = new StringBuilder();
        for(int i = nums.length - 1; i >=0; i--){

            str.append(strs[i]);
        }
        // 避免全零的情况
        if(str.charAt(0) == '0') return "0";
        return str.toString();
    }
}
