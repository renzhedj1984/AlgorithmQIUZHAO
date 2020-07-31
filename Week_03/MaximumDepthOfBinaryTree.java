package week3;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfBinaryTree {
    private int depth = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        dfs(1, root);
        return depth;
    }

    private void dfs(int floor, TreeNode node) {
        if (node == null)
            return;
        dfs(floor + 1, node.left);
        dfs(floor + 1, node.right);
        depth = Math.max(depth, floor);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            List _queue = new ArrayList<>();
            for (TreeNode t : queue) {
                if (t.left != null)
                    _queue.add(t.left);
                if (t.right != null)
                    _queue.add(t.right);
            }
            queue = _queue;
            depth++;
        }
        return depth;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
