package face;

import java.util.*;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * For example:
 * Given BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * <p>
 * return [2].
 *
 * @author zhtttylz
 * @date 2020/7/19 14:50
 * <p>
 * 返回二叉搜索树中出现最多的元素，不用任何额外空间
 */
public class FindModeinBinarySearchTree {

    int max = 0;

    public int[] findMode(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        help(root, map);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        List<Integer> list = new ArrayList<>();
        while (iterator.hasNext()) {

            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() == max) list.add(next.getKey());
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void help(TreeNode root, Map<Integer, Integer> map) {

        if (root == null) return;
        int temp = map.getOrDefault(root.val, 0) + 1;
        max = Math.max(temp, max);
        map.put(root.val, temp);
        help(root.left, map);
        help(root.right, map);
    }
}
