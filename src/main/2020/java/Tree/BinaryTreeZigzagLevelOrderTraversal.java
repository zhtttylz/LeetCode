package Tree;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 左右左将整棵树层序遍历输出
 * @author zhtttylz
 * @date 2020/5/7 23:35
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        queue.add(root);
        // 是否需要反转
        boolean reversal = false;

        int pre = 1;
        int next = 0;
        int index = 0;

        Integer[] tmp = new Integer[pre];

        while(!queue.isEmpty()){

            TreeNode n = queue.poll();

            if(reversal){

                tmp[pre - 1] =  n.val;
            }else{
                tmp[index++] = n.val;
            }

            if(n.left != null){

                queue.add(n.left);
                next++;
            }

            if(n.right != null){

                queue.add(n.right);
                next++;
            }
            if(--pre == 0){

                res.add(Arrays.asList(tmp));
                tmp = new Integer[next];
                pre = next;
                next = 0;
                reversal = !reversal;
                index = 0;
            }
        }
        return res;
    }
}
