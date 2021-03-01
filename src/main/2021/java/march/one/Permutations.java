package march.one;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        // 记录访问过的数的角标
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        help(nums, visited, new ArrayList<Integer>(), res);
        return res;
    }

    public void help(int[] nums, boolean[] visited, List<Integer> tmpRes, List<List<Integer>> res){
        // 满足条件返回
        if(tmpRes.size() == nums.length){
            List<Integer> list = new ArrayList<>(tmpRes);
            res.add(list);
            return;
        }
        // 从头开始遍历，使用
        for(int i = 0; i < nums.length; i++){
            // 如果当前位置的数没被访问过，将其加入到tmpRes中，进行下一轮递归
            if(!visited[i]){
                // 记录当前位置的数已经被方位过
                visited[i] = true;
                tmpRes.add(nums[i]);
                help(nums, visited, tmpRes, res);
                //访问后要还原
                tmpRes.remove(Integer.valueOf(nums[i]));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Permutations p = new Permutations();
        System.out.println(p.permute(new int[]{1, 2, 3}));
    }
}
