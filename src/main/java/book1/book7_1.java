package book1;

import org.junit.Test;

/**
 * 二叉搜索树
 */
public class book7_1 {

    private Node tree = new Node(-1);

    @Test
    public void test0() {

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

    public boolean insertNode(Node node) {

        return true;
    }

    public boolean deleteNode(Node node) {
        return true;
    }


}
