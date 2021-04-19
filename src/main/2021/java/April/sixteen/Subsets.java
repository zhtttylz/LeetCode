package April.sixteen;

/**
 * 求出数组中所有的可能组合，为0的也要，最简单的递归回溯
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> tmp, int start, int[] nums) {

        if(!res.contains(tmp)){

            List<Integer> list = new ArrayList<>();
            list.addAll(tmp);
            res.add(list);
        }
        if(nums == null || start == nums.length) return;

        for(int i = start; i < nums.length; i++){

            tmp.add(nums[i]);
            help(res, tmp, i + 1, nums);
            tmp.remove(new Integer(nums[i]));
        }

    }


    public static void main(String[] args) {

        Subsets s = new Subsets();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
