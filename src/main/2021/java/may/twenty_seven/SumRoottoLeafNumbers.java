package may.twenty_seven;

public class SumRoottoLeafNumbers {

    int res = 0;

    public int sumNumbers(TreeNode root) {

        if(root == null) return 0;
        help(root, 0);
        return res;
    }

    private void help(TreeNode root, int i) {

        if(root == null) return;

        if(root.left == null && root.right == null){
            System.out.println(i*10 + root.val);
            res += (i*10 + root.val);
            return;
        }

        // 分别将当前节点的值传给左右子树
        help(root.left, root.val + i*10);
        help(root.right, root.val + i*10);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
