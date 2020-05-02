package Tree;

import java.util.*;

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
 *
 * 层序遍历一个树
 * @author zhtttylz
 * @date 2020/5/3 1:51
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){

            return new ArrayList<List<Integer>>();
        }

        // 记录当前层节点个数，默认为1（root）
        int cur = 1;

        // 记录下层节点个数
        int next = 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        while(cur != 0){

            TreeNode poll = queue.poll();
            temp.add(poll.val);

            if(poll.left != null){

                queue.add(poll.left);
                next++;
            }

            if(poll.right != null){

                queue.add(poll.right);
                next++;
            }
            if(--cur == 0){

                cur = next;
                next = 0;
                res.add(temp);
                temp = new ArrayList<Integer>();
            }
        }

        return res;
    }
}
