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
        insertNode(4);
        insertNode(9);
        insertNode(13);
        insertNode(17);
        insertNode(20);
        delNode(15);
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

        Node willDel = null;
        Node currentParent = tree;
        boolean left_right = true;
        Node current = tree;
        while (current != null) {
            if (current.value == value) {
                willDel = current;
                break;
            }

            currentParent = current;

            if (current.value > value) {
                current = current.left;
                left_right = true;
            } else {
                current = current.right;
                left_right = false;
            }
        }
        if (willDel == null) {
            System.out.println("#not find this value");
            return;
        }

        //1.如果待删除的节点 是 叶子节点
        if (willDel.left == null && willDel.right == null) {
            if (left_right) {
                currentParent.left = null;
            } else {
                currentParent.right = null;
            }
        }
        //2.如果只有左子树 或 只有右子树
        else if (willDel.left != null && willDel.right == null) {
            if (left_right) {
                currentParent.left = willDel.left;
            } else {
                currentParent.right = willDel.left;
            }
        } else if (willDel.left == null && willDel.right != null) {
            if (left_right) {
                currentParent.left = willDel.right;
            } else {
                currentParent.right = willDel.right;
            }
        }
        //3.如果左右子树都存在
        else {
            //获取前驱节点
            Node preNode = getPreNode(willDel.left);
            delNode(preNode.value);
            willDel.value = preNode.value;
        }

        System.out.println("\n");
        System.out.println(tree);
    }

    public Node getPreNode(Node node) {

        Node current = node;

        while (current != null) {
            if (current.right == null) {
                return current;
            } else {
                current = current.right;
            }
        }
        return null;
    }

}
