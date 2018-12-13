package book1;

import org.junit.Test;

/**
 * 二叉搜索树
 */
public class book7_1 {

    @Test
    public void test0() {
        Node tree = new Node(3);
        insertNode(tree, tree, 1);
        insertNode(tree, tree, 2);
        insertNode(tree, tree, 3);
        insertNode(tree, tree, 4);
        System.out.println(tree);
    }

    public Node searchNode(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value >= value) {
            return searchNode(node.right, value);
        } else {
            return searchNode(node.left, value);
        }
    }

    public Node getMinNode(Node node) {
        if (node.left != null) {
            return getMinNode(node);
        }
        return node;
    }

    public Node getMaxNode(Node node) {
        if (node.right != null) {
            return getMaxNode(node);
        }
        return node;
    }

    public Node insertNode(Node parent, Node node, int value) {
        if (parent == null) {
            parent = new Node(value);
            return parent;
        }
        if (node == null) {
            Node node1 = new Node(value);
            if (value > parent.value) {
                parent.right = node1;
            } else if (value < parent.value) {
                parent.left = node1;
            } else {
                return parent;
            }
        } else {
            if (node.value > value) {
                return insertNode(node, node.left, value);
            } else if (node.value < value) {
                return insertNode(node, node.right, value);
            } else {
                return node;
            }
        }
        return null;
    }

    public boolean deleteNode(Node node) {
        return true;
    }


}
