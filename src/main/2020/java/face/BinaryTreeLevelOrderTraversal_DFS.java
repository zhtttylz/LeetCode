package face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author zhtttylz
 * @date 2020/7/27 23:57
 *
 * 层序遍历，DFS方法
 */
public class BinaryTreeLevelOrderTraversal_DFS {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        return help(root, res, 1);
    }

    private List<List<Integer>> help(TreeNode root, List<List<Integer>> res, int level) {

        if(root == null) return res;

        // 说明到了新的一层
        if(res.size() < level){

            // arrays。aslist生成的不是list的子类arraylist 是它内部自己的实现类，没有实现add方法
            //res.add(Arrays.asList(root.val));
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            res.add(tmp);
        }else{

            res.get(level - 1).add(root.val);
        }

        help(root.left, res, level + 1);
        help(root.right, res, level + 1);

        return res;
    }
}
