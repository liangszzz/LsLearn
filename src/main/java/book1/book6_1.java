package book1;

import org.junit.Test;

/**
 * 遍历二叉树-先序
 */
public class book6_1 {


    @Test
    public void test0() {
        Node tree = init();
        showTree(tree);
    }

    public void showTree(Node node) {
        if (node.left != null)
            showTree(node.left);
        System.out.println(node.value);
        if (node.right != null)
            showTree(node.right);
    }


    public Node init() {
        Node tree = new Node("tree");
        Node left1 = new Node("left1");
        Node right1 = new Node("right1");
        tree.left = left1;
        tree.right = right1;
        Node left2 = new Node("left2");
        Node right2 = new Node("right2");
        left1.left = left2;
        left1.right = right2;
        Node left3 = new Node("left3");
        Node right3 = new Node("right3");
        right1.left = left3;
        right1.right = right3;

        Node left4 = new Node("left4");
        Node right4 = new Node("right4");
        left2.left = left4;
        left2.right = right4;

        return tree;
    }


    public static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node[" + value + "-left:" + left.value + "-right" + right.value + "]";
        }
    }
}


