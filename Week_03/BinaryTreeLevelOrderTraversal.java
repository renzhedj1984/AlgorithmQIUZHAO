package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class BinaryTreeLevelOrderTraversal {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> _queue = new LinkedList<>();
            List<Integer> levels = new ArrayList<>();
            for (TreeNode node : queue) {
                levels.add(node.val);
                if (node.left != null)
                    _queue.add(node.left);
                if (node.right != null)
                    _queue.add(node.right);
            }
            res.add(levels);
            queue = _queue;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
