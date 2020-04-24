package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhtttylz
 * @date 2020/4/25 0:20
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *   思路：造树用递归，左右子树用分治 使用分治将1~n中每个数作为root求解，使用递归将当前所有可能的树返回给上一层
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {

        if(n < 1){
           return new ArrayList<TreeNode>();
        }

        return help(1, n);
    }

    /**
     * 分治递归求解所有树
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> help(int start, int end) {

        List<TreeNode> res = new ArrayList<TreeNode>();
        // return null node
        if(start > end){
            res.add(null);
            return res;
        }
        // 从start到end每个节点都作为root向上返回，分治思想
        for(int i = start; i <= end; i++){

            // 左右子树
            List<TreeNode> left = help(start, i - 1);
            List<TreeNode> right = help(i + 1, end);
            // 将以该节点为root的所有左右子树拼接到该节点上，使用二重循环
            for(TreeNode a : left){

                for(TreeNode b : right){

                    TreeNode node = new TreeNode(i);
                    node.left = a;
                    node.right = b;
                    res.add(node);
                }
            }
        }

        return res;
    }
}
