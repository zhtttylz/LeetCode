package face;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 *
 * @author zhtttylz
 * @date 2020/7/19 14:06
 * 判断一个树是不是二叉搜索树，判断左子树的max和右子树的min是否合法
 * root作为左子树的max 右子树的min
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        return help(root, null, null);
    }

    private boolean help(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        // left ! >= root right ! <= root
        return help(root.left, min, root.val) && help(root.right, root.val, max);
    }
}
