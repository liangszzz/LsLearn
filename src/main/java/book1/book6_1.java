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
        Node tree = new Node(0);
        Node left1 = new Node(1);
        Node right1 = new Node(2);
        tree.left = left1;
        tree.right = right1;
        Node left2 = new Node(3);
        Node right2 = new Node(4);
        left1.left = left2;
        left1.right = right2;
        Node left3 = new Node(5);
        Node right3 = new Node(6);
        right1.left = left3;
        right1.right = right3;

        Node left4 = new Node(7);
        Node right4 = new Node(8);
        left2.left = left4;
        left2.right = right4;

        return tree;
    }


}


