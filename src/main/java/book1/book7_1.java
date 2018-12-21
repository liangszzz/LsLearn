package book1;

import org.junit.Test;

/**
 * 二叉搜索树
 * <p>
 * 若它的左子树不空，则其左子树中所有结点的值不大于根结点的值；
 * 若它的右子树不空，则其右子树中所有结点的值不小于根结点的值；
 * 它的左、右子树都是二叉查找树。
 */
public class book7_1 {

    Node tree;

    @Test
    public void test0() {
        insertNode(15);
        insertNode(6);
        insertNode(18);
        insertNode(3);
        insertNode(7);
        insertNode(17);
        insertNode(20);
        insertNode(2);
        insertNode(4);
        insertNode(13);
        insertNode(9);
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

    /**
     * 插入
     */
    public void insertNode(int value) {
        if (tree == null) {
            tree = new Node(value);
            return;
        }
        Node willInsert = null;
        Node current = tree;
        while (current != null) {
            willInsert = current;
            if (current.value > value) {
                current = current.left;
            } else if (current.value < value) {
                current = current.right;
            } else {
                System.out.println("#无需插入1");
                return;
            }
        }

        if (willInsert.value > value) {
            willInsert.left = new Node(value);
        } else if (willInsert.value < value) {
            willInsert.right = new Node(value);
        } else {
            System.out.println("#无需插入2");
            return;
        }
        System.out.println("\n");
        System.out.println(tree);
    }

    /**
     * 删除
     */
    public void delNode(int value) {
        if (tree == null) {
            System.out.println("#tree is null");
            return;
        }


    }

    public boolean deleteNode(Node node) {
        return true;
    }


}
