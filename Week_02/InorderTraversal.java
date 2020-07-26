package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InorderTraversal {
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(new InorderTraversal().inorderTraversal(node));
        Map<String,Integer> map = new HashMap();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            entry.getValue();
        }
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

