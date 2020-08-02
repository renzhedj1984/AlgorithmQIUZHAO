package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 */
public class FindLargestValueInEachTreeRow {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Integer largest = null;
            LinkedList<TreeNode> _queue = new LinkedList<>();
            for (TreeNode node : queue) {
                if (largest == null)
                    largest = node.val;
                else
                    largest = Math.max(largest, node.val);
                if (node.left != null) _queue.add(node.left);
                if (node.right != null) _queue.add(node.right);
            }
            res.add(largest);
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
