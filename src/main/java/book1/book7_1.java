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

    TreeNode tree;

    @Test
    public void test0() {
        insertTreeNode(15);
        insertTreeNode(6);
        insertTreeNode(18);
        insertTreeNode(4);
        insertTreeNode(9);
        insertTreeNode(13);
        insertTreeNode(17);
        insertTreeNode(20);
        delTreeNode(15);
    }

    public TreeNode searchTreeNode(TreeNode TreeNode, int value) {
        if (TreeNode == null) {
            return null;
        }
        if (TreeNode.value == value) {
            return TreeNode;
        }
        if (TreeNode.value >= value) {
            return searchTreeNode(TreeNode.right, value);
        } else {
            return searchTreeNode(TreeNode.left, value);
        }
    }

    public TreeNode getMinTreeNode(TreeNode TreeNode) {
        if (TreeNode.left != null) {
            return getMinTreeNode(TreeNode);
        }
        return TreeNode;
    }

    public TreeNode getMaxTreeNode(TreeNode TreeNode) {
        if (TreeNode.right != null) {
            return getMaxTreeNode(TreeNode);
        }
        return TreeNode;
    }

    /**
     * 插入
     */
    public void insertTreeNode(int value) {
        if (tree == null) {
            tree = new TreeNode(value);
            return;
        }
        TreeNode willInsert = null;
        TreeNode current = tree;
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
            willInsert.left = new TreeNode(value);
        } else if (willInsert.value < value) {
            willInsert.right = new TreeNode(value);
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
    public void delTreeNode(int value) {
        if (tree == null) {
            System.out.println("#tree is null");
            return;
        }

        TreeNode willDel = null;
        TreeNode currentParent = tree;
        boolean left_right = true;
        TreeNode current = tree;
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
            TreeNode preTreeNode = getPreTreeNode(willDel.left);
            delTreeNode(preTreeNode.value);
            willDel.value = preTreeNode.value;
        }

        System.out.println("\n");
        System.out.println(tree);
    }

    public TreeNode getPreTreeNode(TreeNode TreeNode) {

        TreeNode current = TreeNode;

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
