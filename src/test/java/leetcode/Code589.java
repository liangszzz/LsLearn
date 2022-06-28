package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code589 {


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        addFront(root, list);
        return list;
    }

    public void addFront(Node node, List<Integer> list) {
        list.add(node.val);
        for (Node child : node.children) {
            addFront(child, list);
        }
    }
}
