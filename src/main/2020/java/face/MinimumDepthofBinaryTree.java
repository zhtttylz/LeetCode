package face;

/**
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 *
 * @author zhtttylz
 * @date 2020/8/1 0:22
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        // 如果是叶子节点直接返回1
        if (root.left == null && root.right == null) return 1;

        // 如果当前节点不是叶子节点，返回不是空的子树
        if (root.left == null) return minDepth(root.right) + 1;

        if (root.right == null) return minDepth(root.left) + 1;

        // 如果当前节点左右子树都不为空，则返回左右子树的最小值
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
