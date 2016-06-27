package tree;


/**
 * Created by gs on 2016-06-23.
 */
public class AVLtree {


    public static class AVLnode {
        public int height;

        AVLnode left, right;

        int value;

        public AVLnode(int data) {

            height = 1;
        }

    }

    static int height(AVLnode node) {
        if(node == null) {
            return 0;
        }

        return node.height;
    }


    static int heightOfTree(TreeNode root) {
        if(root == null) return -1;

        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }


    public static AVLnode insert(AVLnode root, int value) {
        if(root == null) {
            return new AVLnode(value);
        }

        if(value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        root.height = Math.max(height(root.left), height(root.right))+1;

        return root;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        AVLnode root = constructSlow(pre);
        root = insert(root, 8);
        printInorder(root);
    }

    public static AVLnode constructSlow(int[] pre) {
        return constructTree(pre, 0, pre.length - 1);
    }

    static void printInorder(AVLnode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    private static AVLnode constructTree(int[] pre, int start, int end) {
        if (start > end) return null;

        AVLnode root = new AVLnode(pre[start]);

        if ((end - start) < 1) {
            return root;
        }

        int greaterIdx = findFirstGreater(pre[start], pre, start + 1, end);

        root.left = constructTree(pre, start + 1, greaterIdx - 1);
        root.right = constructTree(pre, greaterIdx, end);

        return root;
    }


    private static int findFirstGreater(int value, int[] pre, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (pre[i] > value) {
                return i;
            }
        }

        return -1;
    }

}
