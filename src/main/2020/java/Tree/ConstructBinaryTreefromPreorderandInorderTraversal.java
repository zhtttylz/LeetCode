package Tree;

/**
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 给中序前序，能否还原出原本的树
 * 前序：左中右 中序：中左右，可以根据中序遍历在前序遍历中分出左右子树
 * 关键在于根据前序遍历在中序遍历中切分出每个数组的左右子树开始和结束位置
 * @author zhtttylz
 * @date 2020/5/9 0:13
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length != inorder.length || preorder.length == 0) return null;
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 根据切分出来的中间节点不停的切分两个数组，病向下传递左右子树节点
     * @param preorder
     * @param preStart pre开始位置
     * @param preEnd pre结束位置
     * @param inorder
     * @param inStart in 开始位置
     * @param inEnd in 结束位置
     * @return
     */
    private TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);

        // 在in 左中右 中寻找节点位置
        int i = 0; // 根据i将inorder进行拆分
        for(i = inStart; i < inorder.length;i++){

            if(inorder[i] == preorder[preStart]) break;
        }
        node.left = help(preorder, preStart + 1, preStart + (i - inStart), inorder, inStart, i - 1);
        node.right = help(preorder, preStart + (i - inStart) + 1, preEnd, inorder, i + 1, inEnd);

        return node;
    }
}
