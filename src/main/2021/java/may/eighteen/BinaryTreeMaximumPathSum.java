package may.eighteen;

import com.sun.deploy.perf.NativePerfHelper;

/**
 * 二叉树中的最大路径和
 * 返回0代表为负数或者是空节点,不进行处理 res = max(left+right+root.val,res) left|right = 0
 * 或者正数
 */
public class BinaryTreeMaximumPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) return 0;

        help(root);
        return res;
    }

    private int help(TreeNode root) {

        if (root == null) return 0;
        // 如果子节点的值小于0 则直接默认其为0 不会将其加到当前节点上
        int left = Math.max(help(root.left), 0);
        int right = Math.max(help(root.right), 0);

        // 如果左右节点都为负数，则比较res和当前节点的大小 res已经和其左右子树比较过了，只需要和当前节点比较即可
        res = Math.max(left + right + root.val, res);

        return Math.max(left + root.val, right + root.val);
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