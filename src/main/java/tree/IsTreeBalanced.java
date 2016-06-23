package tree;

import static tree.BSTConstruct.printInorder;

/**
 * Created by U200320 on 2016-06-23.
 */
public class IsTreeBalanced {


    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TreeNode root = BSTConstruct.constructSlow(pre);

        BSTConstruct.insert(root, 8);
        BSTConstruct.insert(root, 6);
        BSTConstruct.insert(root, 9);
        printInorder(root);


        System.out.println("height of tree: " + HeightOfTree.heightOfTree(root));

        System.out.println("is balanced: " + isTreeBalanced(root));
    }

    private static boolean isTreeBalanced(TreeNode root) {

        if(root == null) return true;

        int lh = HeightOfTree.heightOfTree(root.left);
        int rh = HeightOfTree.heightOfTree(root.right);

        return isTreeBalanced(root.left) && isTreeBalanced(root.right) && Math.abs(lh - rh) <= 1;
    }
}
