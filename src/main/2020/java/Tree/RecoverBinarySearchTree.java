package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 * 方法1：找到不符合规则的两个节点，将其数值调换，跟之前那个找寻这个树是不是二叉搜索树一样
 * 问题：没办法解决需要调换左右两个节点的情况 如
 *   2
 *  / \
 * 3  1
 *
 * 方法2：
 *
 * @author zhtttylz
 * @date 2020/5/2 9:46
 */
public class RecoverBinarySearchTree {

    public void recoverTree01(TreeNode root) {

        if(root == null)
            return;

        // 虚拟根节点
        TreeNode temp1 = new TreeNode(Integer.MIN_VALUE);
        TreeNode temp2 = new TreeNode(Integer.MAX_VALUE);
        List<TreeNode> res = new ArrayList<TreeNode>();

        help01(root, temp1, temp2, res);

        TreeNode r1 = res.get(0);
        TreeNode r2 = res.get(1);
        int temp  = r1.val;
        r1.val = r2.val;
        r2.val = temp;
    }

    /**
     *
     * @param root 根节点
     * @param left 根节点最大值
     * @param right 根节点的最小值
     */
    private void help01(TreeNode root, TreeNode left, TreeNode right, List<TreeNode> res) {

        if(root == null) return;

        if(root.val <= left.val){

            res.add(root);
            res.add(left);
            return;
        }

        if(root.val >= right.val){

            res.add(root);
            res.add(right);
            return;
        }

        help01(root.left, left, root, res);
        help01(root.right, root, right, res);

    }


    /**
     * 两个一维数组，将所有节点的数值排好序后重新赋值
     * @param root
     */
    public void recoverTree(TreeNode root) {

        if(root == null) return;

        // 存放所有节点的值
        List<Integer> nums = new ArrayList<Integer>();

        // 按顺序存放所有节点
        List<TreeNode> res = new ArrayList<TreeNode>();

        help(root, nums, res);

        Collections.sort(nums);

        for(int i = 0; i < res.size(); i++){

            res.get(i).val = nums.get(i);
        }
    }


    private void help(TreeNode root, List<Integer> nums, List<TreeNode> res) {

        if(root == null) return;

        help(root.left, nums, res);
        res.add(root);
        nums.add(root.val);
        help(root.right, nums, res);
    }
}
