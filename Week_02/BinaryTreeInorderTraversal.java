package week2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        search(root,list);
        return list;
    }

    public void search(TreeNode root, List < Integer > list) {
        if (root != null) {
            if (root.left != null) {
                search(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                search(root.right, list);
            }
        }
    }
}
