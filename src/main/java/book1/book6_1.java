package book1;

import org.junit.Test;

/**
 * 遍历二叉树
 */
public class book6_1 {

    /**
     * 先序
     */
    @Test
    public void test0() {
        Node tree = init();
        preOrderRecursion(tree);
    }

    /**
     * 中序遍历
     */
    @Test
    public void test1() {
        Node tree = init();
        preOrderRecursion1(tree);
    }

    /**
     * 后续遍历
     */
    @Test
    public void test2() {
        Node tree = init();
        preOrderRecursion2(tree);
    }


    public void preOrderRecursion(Node node) {
        if (node == null) {
            return;
        }
        preOrderRecursion(node.left);
        System.out.println("value:" + node.value);
        preOrderRecursion(node.right);
    }

    public void preOrderRecursion1(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("value:" + node.value);
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }

    public void preOrderRecursion2(Node node) {
        if (node == null) {
            return;
        }
        preOrderRecursion(node.right);
        System.out.println("value:" + node.value);
        preOrderRecursion(node.left);
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


