package June.eight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如果一个层序集合中，一个null节点后面还有不为null的节点，说明有left=null right！= null的情况
 */
public class CheckCompletenessofaBinaryTree {


    public boolean isCompleteTree(TreeNode root) {

        if(root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 如果队列头不为null，说明仍有节点需要添加到集合
        while(queue.peek() != null){

            TreeNode node = queue.poll();
            // 即便为null也进行添加
            queue.add(node.left);
            queue.add(node.right);
        }

        // 如queue中为 7，8，9，null，10 排掉队列头所有未null的节点，判断队列是否为空即可
        while(!queue.isEmpty() && queue.peek() == null) queue.poll();

        return queue.isEmpty();
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
