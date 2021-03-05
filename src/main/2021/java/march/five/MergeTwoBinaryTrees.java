package march.five;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果节点为空，则直接将另一个节点及其子树返回
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        // 如果两个树之间有重合，则进行加值计算
        TreeNode node = new TreeNode(root1.val + root2.val);
        // 因为合并了节点，所以要对子树进行合并
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        // 将合并后的子树返回到上一层
        return node;
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