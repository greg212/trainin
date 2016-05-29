package tree;

/**
 * Created by gs on 2016-05-29.
 */
public class SymmetricCheck {

    public static boolean isSymetric(TreeNode root) {
        return root == null || isSymetric(root.left, root.right);
    }

    static boolean isSymetric(TreeNode left, TreeNode right) {

        return left.value == right.value &&
                isSymetric(left.left, right.right) && isSymetric(left.right, right.left);
    }

    public static void main(String[] args) {

        int pre[] = new int[] {10, 5, 1, 7, 40, 50, 60};
        TreeNode root = BSTConstruct.constructSlow(pre);
        BSTConstruct.printInorder(root);
        System.out.println(isSymetric(root));
    }
}
