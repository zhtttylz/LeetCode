package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhtttylz
 * @date 2020/4/12 19:37
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 */
public class BinaryTreeInorderTraversal {

    // 返回给定树的中序遍历(递归方式)
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null){
            return new ArrayList<Integer>();
        }

        return help(root, new ArrayList<Integer>());
    }

    private List<Integer> help(TreeNode root, ArrayList<Integer> list) {

        if(root == null){

            return list;
        }

        help(root.left, list);
        list.add(root.val);
        help(root.right, list);
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
