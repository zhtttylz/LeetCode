package June.fifteen;

/**
 * 求一个树是不是平衡二叉树
 * 子树之间的最大深度不能超过1
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;
        return help(root) != -1;
    }

    private int help(TreeNode root) {
        if(root == null) return 0;
        int left = help(root.left);
        if(left == -1) return -1;
        int right = help(root.right);
        if(right == -1) return -1;
        int diff = Math.abs(left - right);
        if(diff > 1) return -1;
        return Math.max(left, right) + 1;
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