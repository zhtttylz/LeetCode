package April.fourteen;

public class DiameterOfBinaryTree {
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

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return res;

        help(root);
        return res - 1;
    }

    private int help(TreeNode root){

        if(root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);

        res = Math.max(res, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
