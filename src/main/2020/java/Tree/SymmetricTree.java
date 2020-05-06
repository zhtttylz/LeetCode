package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * @author zhtttylz
 * @date 2020/5/6 1:13
 */
public class SymmetricTree {

    /**
     * 判断一个树是不是它自己的镜像 递归方式
     * @param root
     * @return
     */
    public boolean isSymmetric01(TreeNode root) {

        if(root == null){
            return true;
        }

        return help(root.left, root.right);

    }

    private boolean help(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null  || right == null || left.val != right.val) return false;

        // 两个节点值相同，继续向下判断，知道没有节点为止
        return help(left.left, right.right) && help(left.right, right.left);
    }


    /**
     * 循环方式，采用层序遍历，为空的话，集合中放入null
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if(root == null)  return true;

        // 两个集合，分别存储左右子树
        Queue<TreeNode> qleft = new LinkedList<TreeNode>();
        Queue<TreeNode> qright = new LinkedList<TreeNode>();

        qleft.add(root.left);
        qright.add(root.right);

        while(!qleft.isEmpty() && !qright.isEmpty()){

            TreeNode q1 = qleft.poll();
            TreeNode q2 = qright.poll();

            if(q1 == null && q2 == null) continue;
            if((q1 != null && q2 == null) || (q2 != null && q1 == null) || (q1.val != q2.val)) return false;
            qleft.add(q1.left);
            qleft.add(q1.right);
            qright.add(q2.right);
            qright.add(q2.left);
        }

        return true;
    }
}
