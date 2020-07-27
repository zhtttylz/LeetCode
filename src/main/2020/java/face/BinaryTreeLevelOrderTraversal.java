package face;

import com.sun.deploy.panel.TreeBuilder;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * @date 2020/7/27 23:41
 * 树的层序遍历
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        int level = 1;
        int next = 0;
        q.add(root);
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){

            TreeNode node = q.poll();
            tmp.add(node.val);
            if(node.left != null){

                q.add(node.left);
                next++;
            }

            if(node.right != null){

                q.add(node.right);
                next++;
            }

            if(--level == 0){

                res.add(tmp);
                tmp = new ArrayList<>();
                level = next;
                next = 0;
            }
        }

        return res;
    }
}
