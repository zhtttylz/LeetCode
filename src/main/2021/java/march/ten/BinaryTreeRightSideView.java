package march.ten;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        // 层序遍历的变种，记录每一层的最后一个元素
        if(root == null) return new ArrayList<>();
        // 记录当前层的节点个数
        int cur = 1;
        // 记录下一层的节点个数
        int next = 0;
        List<Integer> res = new ArrayList<>();
        // 存储下一层的节点个数
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            if(node.left != null){

                queue.offer(node.left);
                next++;
            }

            if(node.right != null){

                queue.offer(node.right);
                next++;
            }

            if(--cur == 0){

                res.add(node.val);
                cur = next;
                next = 0;
            }
        }

        return res;
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