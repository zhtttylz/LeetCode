package february.twelve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhtttylz
 * @date 2021/2/12 19:53
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0) return null;

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        help(set, candidates, target, 0, new ArrayList<Integer>());
        for (List<Integer> i : set) {
            res.add(i);
        }
        return res;
    }

    private void help(Set<List<Integer>> set, int[] candidates, int target, int index, List<Integer> tmp) {

        // 如果target已经减没了，说明可以将此数组添加到最终集合里卖弄，但是不能返回，以防0的添加
        if(target == 0) {
            List<Integer> list = new ArrayList<>();
            list.addAll(tmp);
            set.add(list);
        }
        if(target < 0) return;
        if(index >= candidates.length) return;

        // 这里默认等于index 因为允许同一数被相加
        for(int i = index; i < candidates.length; i++){

            tmp.add(candidates[i]);
            help(set, candidates, target - candidates[i], i, tmp);
            tmp.remove(Integer.valueOf(candidates[i]));
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        c.combinationSum(new int[]{2,3,6,7}, 7);
    }
}
