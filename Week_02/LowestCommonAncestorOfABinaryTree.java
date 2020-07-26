package week2;

public class LowestCommonAncestorOfABinaryTree {
    private TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findCommonPNode(root, p, q);
        return node;
    }

    private boolean findCommonPNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean inLeft = findCommonPNode(root.left, p, q);
        boolean inRight = findCommonPNode(root.right, p, q);
        if ((inLeft && inRight) || ((root.val == p.val || root.val == q.val) && (inLeft || inRight))) {
            node = root;
        }
        return inLeft || inRight || root.val == p.val || root.val == q.val;
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
