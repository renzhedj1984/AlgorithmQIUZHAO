package week2;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> ls = new ArrayList();
        postOrder(ls, root);
        return ls;
    }

    private void postOrder(List<Integer> ls , Node root){
        if(root !=null){
            for(Node subNode : root.children){
                postOrder(ls, subNode);
            }
            ls.add(root.val);
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
