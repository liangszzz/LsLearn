package book1;


/**
 * 遍历二叉树
 */
public class book6_1 {

    /**
     * 先序
     */
    public void test0() {
        TreeNode tree = init();
        preOrderRecursion(tree);
    }

    /**
     * 中序遍历
     */
    public void test1() {
        TreeNode tree = init();
        preOrderRecursion1(tree);
    }

    /**
     * 后续遍历
     */
    public void test2() {
        TreeNode tree = init();
        preOrderRecursion2(tree);
    }


    public void preOrderRecursion(TreeNode TreeNode) {
        if (TreeNode == null) {
            return;
        }
        preOrderRecursion(TreeNode.left);
        System.out.println("value:" + TreeNode.value);
        preOrderRecursion(TreeNode.right);
    }

    public void preOrderRecursion1(TreeNode TreeNode) {
        if (TreeNode == null) {
            return;
        }
        System.out.println("value:" + TreeNode.value);
        preOrderRecursion(TreeNode.left);
        preOrderRecursion(TreeNode.right);
    }

    public void preOrderRecursion2(TreeNode TreeNode) {
        if (TreeNode == null) {
            return;
        }
        preOrderRecursion(TreeNode.right);
        System.out.println("value:" + TreeNode.value);
        preOrderRecursion(TreeNode.left);
    }


    public TreeNode init() {
        TreeNode tree = new TreeNode(0);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        tree.left = left1;
        tree.right = right1;
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        left1.left = left2;
        left1.right = right2;
        TreeNode left3 = new TreeNode(5);
        TreeNode right3 = new TreeNode(6);
        right1.left = left3;
        right1.right = right3;

        TreeNode left4 = new TreeNode(7);
        TreeNode right4 = new TreeNode(8);
        left2.left = left4;
        left2.right = right4;

        return tree;
    }


}


