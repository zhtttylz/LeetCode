package June.seventeen;

/**
 * 查找二叉搜索树中第k小的元素
 * 二叉搜索树,左中右就是顺序的大小
 * 题目要求能够最快速的返回所需的第k个元素,并且树是在不停的变化中
 */
public class KthSmallestElementInABST {

    // 这里设置全局的k,因为需要将k的修改传递回上一层
    int k = 0;

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) return -1;
        this.k = k;
        return help(root);
    }

    private int help(TreeNode root) {

        if(root == null) return -1;
        int left = help(root.left);
        // 如果k == 0 说明当前节点的left符合第k小
        if(k == 0) return left;
        // 如果k-- == 0 说明当前节点是符合的值
        if(--k == 0) return root.val;
        // 否则遍历右节点
        return help(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n4;

        n2.right = n3;

        KthSmallestElementInABST k = new KthSmallestElementInABST();
        System.out.println(k.kthSmallest(n1, 1));

    }
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