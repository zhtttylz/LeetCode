package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @author zhtttylz
 * @date 2020/4/29 23:36
 *
 * 判断一个树是不是二叉搜索树 二叉搜索树:左<中<右
 * 方法有很多
 * 1.接中序遍历放入数组,进行比对即可,比对过程要注意是前一个节点>=后一个节点,则不成立(占用了额外的空间)
 * 2.直接中序进行比对即可
 */
public class ValidateBinarySearchTree {

    /**
     * 使用数组的方式进行比对
     * @param root
     * @return
     */
    public boolean isValidBST01(TreeNode root) {

        if(root == null){

            return true;
        }

        List<Integer> res = new ArrayList<Integer>();
        help01(root, res);
        for(int i = 0; i < res.size()-1; i++){

            if(res.get(i) >= res.get(i + 1)) {
                System.out.println(res.get(i));
                System.out.println(res.get(i) + 1);
                System.out.println();
                return false;
            }
        }

        return true;
    }

    private void help01(TreeNode root, List<Integer> res) {

        if(root == null){

            return;
        }
        help01(root.left, res);
        res.add(root.val);
        help01(root.right, res);

    }


    /**
     * 直接中需进行比对,关键:中左右,当前节点的值作为最大值向左子树下传,作为最小值向右子树传
     * 注意,此题integer会超出范围,使用long进行判断
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if(root == null){

            return true;
        }

        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean help(TreeNode root, long left, long right) {


        if(root == null){

            return true;
        }

        // 中左右进行判断
        if(root.val >= right || root.val <= left){

            return false;
        }

        // 左子树不能大于当前节点,将当前节点的值作为right向下传,右子树不能小于left,将前节点的值作为left向下传
        return help(root.left, left, root.val) && help(root.right, root.val, right);
    }
}
