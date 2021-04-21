package April.seventeen;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {

        help(root, targetSum, 0, new ArrayList<TreeNode>());

        return res;
    }

    private void help(TreeNode root, int targetSum, int curSum, List<TreeNode> list) {

        if(root == null) return;
        // 记录当前节点的值，将当前节点放入到list中,记录后判断是否等于目标值
        curSum += root.val;
        list.add(root);
        if(curSum == targetSum) res++;

        int tmp = curSum;
        // 不需要都减去，tmp为list中所有节点的集合，tmp最后会等于最后一个节点
        for(int i = 0; i < list.size() - 1; i++){

            if((tmp -= list.get(i).val) == targetSum) res++;
        }

        help(root.left, targetSum, curSum, list);
        help(root.right, targetSum, curSum, list);
        list.remove(list.size() - 1);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}