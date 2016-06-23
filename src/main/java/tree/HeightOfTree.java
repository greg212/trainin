package tree;

import static tree.BSTConstruct.printInorder;

/**
 * Created by U200320 on 2016-06-23.
 */
public class HeightOfTree {


    static int heightOfTree(TreeNode root) {
        if(root == null) return -1;

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        TreeNode root = BSTConstruct.constructSlow(pre);

        BSTConstruct.insert(root, 8);
        printInorder(root);

        System.out.println("height of tree: " + heightOfTree(root));
    }
}
