package march.thirty;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        // 叶子节点字节返回
        if(root == null) return;

        // 先对左右子树进行递归
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);

        // 记录右子树，方便拼接点左子树的最下面
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        // 已经将左子树替换为右子树，找到左子树的叶子节点，将原本的右子树tmp拼上
        while(root.right != null) root = root.right;
        root.right = tmp;
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