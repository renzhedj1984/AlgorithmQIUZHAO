package week2;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList();
        perOrderTrav(ls,root);
        return ls;

    }

    private void perOrderTrav(List<Integer> ls,TreeNode root){
        if(root != null){
            ls.add(root.val);
            perOrderTrav(ls,root.left);
            perOrderTrav(ls,root.right);
        }
    }
}
