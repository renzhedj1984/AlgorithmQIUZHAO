package week2;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList();
        perOrder(ls, root);
        return ls;
    }

    private void perOrder(List<Integer> ls ,Node root) {
        if(root != null){
            ls.add(root.val);
            for(Node subNode : root.children){
                perOrder(ls, subNode);
            }
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

