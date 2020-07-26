package week2;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> idxMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            throw null;
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return recursionBuildTree(preorder, inorder, 0, idxMap.size() - 1, 0, idxMap.size() - 1);
    }

    private TreeNode recursionBuildTree(int[] preorder, int[] inorder, int pStart, int pEdn, int iStart, int iEnd) {
        if (pStart > pEdn)
            return null;
        int head = preorder[pStart];
        int iHeadIdx = idxMap.get(head);
        TreeNode root = new TreeNode(head);
        root.left = recursionBuildTree(preorder, inorder, pStart + 1, iHeadIdx - iStart + pStart, iStart, iHeadIdx - 1);
        root.right = recursionBuildTree(preorder, inorder, iHeadIdx - iStart + pStart + 1, pEdn, iHeadIdx + 1, iEnd);
        return root;
    }
}
