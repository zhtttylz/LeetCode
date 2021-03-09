package march.seven;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        help(root, targetSum, res, new ArrayList<Integer>());
        return res;
    }

    public void help(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> tmp){

        if(root == null) return ;
        // 当前节点时叶子节点，并且target为0 则添加到最终结果及
        tmp.add(root.val);
        if(root.left == null && root.right == null && targetSum - root.val == 0){

            List<Integer> list = new ArrayList<>();
            list.addAll(tmp);
            res.add(list);
            // list 需要从末尾删除指定元素
            removeNum(tmp, root.val);
            return;
        }

        // 处理左右节点
        help(root.left, targetSum - root.val, res, tmp);
        help(root.right, targetSum - root.val, res, tmp);
        removeNum(tmp, root.val);

    }

    private void removeNum(List<Integer> tmp, int val) {

        for (int i = tmp.size() - 1; i >= 0; i--) {
            if(tmp.get(i) == val) {
                tmp.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(-2);
        TreeNode n7 = new TreeNode(-1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n4.left = n7;

        PathSumII p = new PathSumII();
        System.out.println(p.pathSum(n1, 2));
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