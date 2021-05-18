package may.fifteen;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null || preorder.length == 0) return null;

        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder 前序遍历数组 中左右
     * @param preStart
     * @param preEnd
     * @param inorder 中序遍历数组 左中右
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {


        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int i = inStart;
        // 在中序遍历中找到root节点位置，确定左右子树
        for(; i <= inEnd; i++){

            if(inorder[i] == preorder[preStart]) break;
        }

        root.left = help(preorder, preStart + 1, preStart + (i - inStart), inorder, inStart, i - 1);
        root.right = help(preorder, preStart + (i - inStart) + 1, preEnd, inorder, i + 1, inEnd);
        return root;
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
