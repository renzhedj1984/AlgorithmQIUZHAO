package week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            List<Node> navNodes = new LinkedList();
            navNodes.add(root);
            while (!navNodes.isEmpty()) {
                List<Integer> levelNodes = new ArrayList();
                List<Node> tmp = new LinkedList();
                for (int i = 0; i < navNodes.size(); i++) {
                    Node node = navNodes.get(i);
                    levelNodes.add(node.val);
                    tmp.addAll(node.children);
                }
                list.add(levelNodes);
                navNodes = tmp;
            }
        }
        return list;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
