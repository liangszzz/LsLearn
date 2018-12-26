package book1;

import org.junit.Test;

import java.util.Stack;


public class book_8_1 {

    TreeNode tree;

    /**
     * 左左
     */
    @Test
    public void test0() {
        insertTreeNode(16);
        insertTreeNode(18);
        insertTreeNode(10);
        insertTreeNode(7);
        insertTreeNode(5);
        insertTreeNode(4);
        System.out.println(tree);
    }

    /**
     * 右右
     */
    @Test
    public void test1() {
        insertTreeNode(16);
        insertTreeNode(18);
        insertTreeNode(10);
        insertTreeNode(17);
        insertTreeNode(20);
        insertTreeNode(22);
        System.out.println(tree);
    }

    /**
     * 左右
     */
    @Test
    public void test2() {
        insertTreeNode(16);
        insertTreeNode(18);
        insertTreeNode(10);
        insertTreeNode(5);
        insertTreeNode(15);
        insertTreeNode(11);
        System.out.println(tree);
    }

    /**
     * 右左
     */
    @Test
    public void test3() {
        insertTreeNode(16);
        insertTreeNode(10);
        insertTreeNode(25);
        insertTreeNode(20);
        insertTreeNode(30);
        insertTreeNode(19);
        System.out.println(tree);
    }

    /**
     * 插入节点
     *
     * @param val
     */
    public void insertTreeNode(int val) {
        if (tree == null) {
            tree = new TreeNode(val);
            return;
        }

        TreeNode willInsert = tree;
        TreeNode current = tree;

        while (current != null) {
            willInsert = current;
            if (current.value == val) {
                System.out.println("#无需插入");
                return;
            } else if (current.value > val) {
                current = current.left;
            } else if (current.value < val) {
                current = current.right;
            }
        }

        TreeNode node = new TreeNode(val);

        if (willInsert.value > val) {
            willInsert.left = node;
        } else if (willInsert.value < val) {
            willInsert.right = node;
        }
        System.out.println(tree);
        TreeNode check = checkBalance(tree);
        while (check != null) {
            route(check);
            check = checkBalance(tree);
        }


    }

    /**
     * 删除节点
     *
     * @param val
     */
    public void delTreeNode(int val) {

    }

    /**
     * 判断是否失衡,将所有的节点修改 平衡因子
     *
     * @param TreeNode
     * @return
     */
    public TreeNode checkBalance(TreeNode TreeNode) {
        if (TreeNode == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(TreeNode);

        TreeNode error_node = null;

        while (!stack.empty()) {

            TreeNode current = stack.pop();

            int left_height = getTreeNodeHeight(current.left);
            int right_height = getTreeNodeHeight(current.right);
            current.balance = left_height - right_height;

            if (current.balance > 1 || current.balance < -1) {
                error_node = current;
            }

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }

        }
        return error_node;
    }

    /**
     * 获取节点高度
     *
     * @param TreeNode
     * @return
     */
    public int getTreeNodeHeight(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;
        int a = getTreeNodeHeight(TreeNode.left);
        int b = getTreeNodeHeight(TreeNode.right);
        return (a > b ? a : b) + 1;
    }

    /**
     * 获取节点的上一级
     *
     * @param node
     * @return
     */
    public TreeNode getHighNode(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode selectNode = null;
        TreeNode current = tree;

        while (current != null) {
            if (current.value == node.value) {
                return selectNode;
            } else if (current.value > node.value) {
                selectNode = current;
                current = current.left;
            } else if (current.value < node.value) {
                selectNode = current;
                current = current.right;
            }
        }
        return null;
    }

    /**
     * 旋转
     *
     * @param node 失衡的节点
     */
    public void route(TreeNode node) {

        //判断节点类型
        if (node.balance > 1) {
            //左比右大
            //判断插入节点的是左 还是 右
            if (node.left.balance > 0) {
                //左左

                //获取g的上一级
                TreeNode g_p = getHighNode(node);
                TreeNode g = node;
                TreeNode p = node.left;
                //右旋
                g.left = p.right;
                p.right = g;
                if (g_p != null) {
                    g_p.left = p;
                } else {
                    tree = p;
                }

            } else {
                //左右
                //node.left左旋
                TreeNode g_p = getHighNode(node);
                TreeNode g = node;
                TreeNode p = g.left;
                TreeNode v = p.right;

                p.right = v.left;
                v.left = p;
                g.left = v;

                //node右旋
                g.left = v.right;
                v.right = g;
                if (g_p != null) {
                    g_p.left = v;
                } else {
                    tree = v;
                }

            }
        } else if (node.balance < -1) {
            //右比左大
            if (node.right.balance > 0) {
                //右左
                //node.right右旋
                TreeNode g_p = getHighNode(node);
                TreeNode g = node;
                TreeNode p = g.right;
                TreeNode v = p.left;

                p.left = v.right;
                v.right = p;
                g.right = v;

                //node左旋
                g.right = v.left;
                v.left = g;
                if (g_p != null) {
                    g_p.right = v;
                } else {
                    tree = v;
                }

            } else {
                //右右
                TreeNode g_p = getHighNode(node);
                TreeNode g = node;
                TreeNode p = node.right;
                g.right = p.left;
                p.left = g;
                if (g_p != null) {
                    g_p.right = p;
                } else {
                    tree = p;
                }

            }
        }

    }

}
